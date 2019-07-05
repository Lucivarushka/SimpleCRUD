package main.java.com.crud.model;

public class Customer {
    private long id;
    private String nameCustomer;
    private int max = 1000;

    public Customer(String nameCustomer) {
        this.id = (int) (Math.random() * ++ max);
        this.nameCustomer = nameCustomer;
    }

    public Customer(long id, String nameCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + nameCustomer;
    }
}