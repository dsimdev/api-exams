package com.dsimdev.api.exams.controllers;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category localCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(localCategory);
    }

    @GetMapping("/{categoryId}")
    public Category readCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.readCategory(categoryId);
    }

    @GetMapping()
    public ResponseEntity<?> readCategories() {
        return ResponseEntity.ok(categoryService.readCategories());
    }

    @PutMapping()
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
