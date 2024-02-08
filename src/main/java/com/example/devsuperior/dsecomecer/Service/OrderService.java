package com.example.devsuperior.dsecomecer.Service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.Service.exceptions.ResourceNotFoundExceptions;
import com.example.devsuperior.dsecomecer.dto.Request.RequestOrderDTO;
import com.example.devsuperior.dsecomecer.dto.Request.RequestOrderItemDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseOrderDTO;
import com.example.devsuperior.dsecomecer.entities.Order;
import com.example.devsuperior.dsecomecer.entities.OrderItem;
import com.example.devsuperior.dsecomecer.entities.OrderStatus;
import com.example.devsuperior.dsecomecer.entities.Product;
import com.example.devsuperior.dsecomecer.entities.User;
import com.example.devsuperior.dsecomecer.repositories.OrderItemRepository;
import com.example.devsuperior.dsecomecer.repositories.OrderRepository;
import com.example.devsuperior.dsecomecer.repositories.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public ResponseOrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Order not found"));
        authService.validateSelfOrAdm(order.getClient().getId());
        return new ResponseOrderDTO(order);
    }

    @Transactional
    public ResponseOrderDTO insert(RequestOrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);
        for (RequestOrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new ResponseOrderDTO(order);
    }
}
