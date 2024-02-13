package com.example.devsuperior.dsecomecer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.Service.exceptions.ResourceNotFoundExceptions;
import com.example.devsuperior.dsecomecer.dto.Request.RequestCategoryDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseCategoryDTO;
import com.example.devsuperior.dsecomecer.entities.Category;
import com.example.devsuperior.dsecomecer.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public ResponseCategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Category not found"));

        return new ResponseCategoryDTO(category);
    }

    @Transactional(readOnly = true)
    public List<ResponseCategoryDTO> findAll() {

        return categoryRepository.findAll().stream().map(x -> new ResponseCategoryDTO(x)).toList();

    }

    public ResponseCategoryDTO insert(RequestCategoryDTO request) {
        Category category = new Category();

        copytoEntity(request, category);

        category = categoryRepository.save(category);

        return new ResponseCategoryDTO(category);

    }

    private void copytoEntity(RequestCategoryDTO request, Category category) {
        category.setName(request.getName());

    }

}
