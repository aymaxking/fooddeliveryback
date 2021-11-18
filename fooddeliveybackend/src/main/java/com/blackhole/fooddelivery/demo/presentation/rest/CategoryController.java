package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.service.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/categories")
    public Page<Category> getAllPosts(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @PostMapping("/categories")
    public Category createPost(@Validated @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updatePost(@PathVariable Long categoryID, @Validated @RequestBody Category categoryRequest) {
        return categoryRepository.findById(categoryID).map(category -> {
            category.setTitle(categoryRequest.getTitle());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new ResourceNotFoundException("CategoryID " + categoryID + " not found"));
    }


    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<?> deletePost(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId).map(category -> {
            categoryRepository.delete(category);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CategoryID " + categoryId + " not found"));
    }

}
