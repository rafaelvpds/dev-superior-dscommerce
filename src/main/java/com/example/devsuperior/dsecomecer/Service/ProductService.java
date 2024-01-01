package com.example.devsuperior.dsecomecer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.dto.Request.RequestProductDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseProductDTO;
import com.example.devsuperior.dsecomecer.entities.Product;
import com.example.devsuperior.dsecomecer.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ResponseProductDTO findById(Long id) {
        // Optional<Product> result = productRepository.findById(id);
        // Product product = result.get();
        // ProductDTO productDTO = new ProductDTO(product);
        // return productDTO;
        Product product = productRepository.findById(id).get();
        return new ResponseProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ResponseProductDTO> findAll(Pageable pageable) {
        // Optional<Product> result = productRepository.findById(id);
        // Product product = result.get();
        // ProductDTO productDTO = new ProductDTO(product);
        // return productDTO;
        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<Product> productList = productRepository.findAll(pageable);
        return productList.map(x -> new ResponseProductDTO(x));
    }

    public ResponseProductDTO insert(RequestProductDTO productDTO) {
        Product entity = new Product();
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setImgUrl(productDTO.getImgUrl());
        entity.setPrice(productDTO.getPrice());

        entity = productRepository.save(entity);

        return new ResponseProductDTO(entity);

    }

}
