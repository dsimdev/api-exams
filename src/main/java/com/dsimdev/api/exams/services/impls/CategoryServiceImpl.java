package com.dsimdev.api.exams.services.impls;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.repos.CategoryRepository;
import com.dsimdev.api.exams.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> readCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category readCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
