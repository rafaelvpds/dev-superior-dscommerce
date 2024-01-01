package com.example.devsuperior.dsecomecer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsuperior.dsecomecer.Service.ProductService;
import com.example.devsuperior.dsecomecer.dto.Request.RequestProductDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseProductDTO;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseProductDTO findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @GetMapping
    public Page<ResponseProductDTO> findAll(
            @PageableDefault(page = 0, size = 12) @SortDefault.SortDefaults({
                    @SortDefault(sort = "name", direction = Sort.Direction.ASC)
            }) Pageable pageable) {

        return service.findAll(pageable);
    }

    @PostMapping
    public ResponseProductDTO insertProduct(@RequestBody RequestProductDTO dto) {
        return service.insert(dto);
    }
}
