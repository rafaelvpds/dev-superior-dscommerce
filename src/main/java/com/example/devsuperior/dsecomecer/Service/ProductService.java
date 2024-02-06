package com.example.devsuperior.dsecomecer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.Service.exceptions.DatabaseException;
import com.example.devsuperior.dsecomecer.Service.exceptions.ResourceNotFoundExceptions;
import com.example.devsuperior.dsecomecer.dto.Request.RequestProductDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseProductDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseProductMinDTO;
import com.example.devsuperior.dsecomecer.entities.Product;
import com.example.devsuperior.dsecomecer.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

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
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Produc not found"));
        return new ResponseProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ResponseProductMinDTO> findAll(String name, Pageable pageable) {
        // Optional<Product> result = productRepository.findById(id);
        // Product product = result.get();
        // ProductDTO productDTO = new ProductDTO(product);
        // return productDTO;
        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        Page<Product> productList = productRepository.searchByName(name, pageable);
        return productList.map(x -> new ResponseProductMinDTO(x));
    }

    @Transactional
    public ResponseProductDTO insert(RequestProductDTO productDTO) {
        Product entity = new Product();
        copyDtoToEntity(productDTO, entity);

        entity = productRepository.save(entity);

        return new ResponseProductDTO(entity);

    }

    @Transactional
    public ResponseProductDTO update(Long id, RequestProductDTO productDTO) {

        try {

            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, entity);
            // entity.setName(productDTO.getName());
            // entity.setDescription(productDTO.getDescription());
            // entity.setImgUrl(productDTO.getImgUrl());
            // entity.setPrice(productDTO.getPrice());
            entity = productRepository.save(entity);
            return new ResponseProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExceptions("Produc not found");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundExceptions("Produc not found");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(RequestProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setImgUrl(productDTO.getImgUrl());
        entity.setPrice(productDTO.getPrice());
    }

}
