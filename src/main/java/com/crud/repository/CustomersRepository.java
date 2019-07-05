package main.java.com.crud.repository;

import main.java.com.crud.model.Customer;

public interface CustomersRepository extends GenericRepository<Customer, Long> {

    Customer getById(Long id);

    Customer getByValue(String value);
}