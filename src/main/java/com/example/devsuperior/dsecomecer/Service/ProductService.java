package com.example.devsuperior.dsecomecer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.dto.ProductDTO;
import com.example.devsuperior.dsecomecer.entities.Product;
import com.example.devsuperior.dsecomecer.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        // Optional<Product> result = productRepository.findById(id);
        // Product product = result.get();
        // ProductDTO productDTO = new ProductDTO(product);
        // return productDTO;
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        // Optional<Product> result = productRepository.findById(id);
        // Product product = result.get();
        // ProductDTO productDTO = new ProductDTO(product);
        // return productDTO;
        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<Product> productList = productRepository.findAll(pageable);
        return productList.map(x -> new ProductDTO(x));
    }

}
