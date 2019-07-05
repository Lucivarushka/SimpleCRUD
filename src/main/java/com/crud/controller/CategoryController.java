package main.java.com.crud.controller;

import main.java.com.crud.model.Category;
import main.java.com.crud.repository.JavaIOCategoryRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class CategoryController {
    private static JavaIOCategoryRepositoryImpl category = new JavaIOCategoryRepositoryImpl();

    public List<String> printAll() throws IOException {
        return category.getAll();
    }

    public void createCategory(Category categoryNew) {
        category.create(categoryNew);
    }

    public void deleteCategory(long index) {
        category.delete(index);
    }

    public void updateCategory(Category updateCategory) {
        category.update(updateCategory);
    }

    public Category getValueByIndex(long index) {
        return category.getById(index);
    }

    public Category getIndexByValue(String value) {
        return category.getByValue(value);
    }
}