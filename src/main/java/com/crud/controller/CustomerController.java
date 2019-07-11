package main.java.com.crud.controller;

import main.java.com.crud.model.Customer;
import main.java.com.crud.repository.CustomersRepository;
import main.java.com.crud.repository.JavaIOCustomersRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class CustomerController {
    private static CustomersRepository customers = new JavaIOCustomersRepositoryImpl();

    public List<String> printAll() throws IOException {
        return customers.getAll();
    }

    public void createCategory(Customer categoryNew) {
        customers.create(categoryNew);
    }

    public void deleteCategory(long index) {
        customers.delete(index);
    }

    public void updateCategory(Customer updateCategory) {
        try {
            customers.update(updateCategory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getValueByIndex(long index) {
        return customers.getById(index);
    }

    public Customer getIndexByValue(String value) {
        return customers.getByValue(value);
    }
}