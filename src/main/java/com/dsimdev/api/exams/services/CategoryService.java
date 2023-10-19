package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.Category;

import java.util.Set;

public interface CategoryService {

    Category createCategory(Category category);

    Category updateCategory(Category category);

    Set<Category> readCategories();

    Category readCategory(Long categoryId);

    void deleteCategory(Long categoryId);

}
