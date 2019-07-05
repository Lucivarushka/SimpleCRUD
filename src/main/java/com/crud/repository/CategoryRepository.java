package main.java.com.crud.repository;

import main.java.com.crud.model.Category;

public interface CategoryRepository extends GenericRepository<Category, Long> {

    Category getById(Long id);

    Category getByValue(String value);
}