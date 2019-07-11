package main.java.com.crud.model;

public class Customer {
    private long id;
    private String nameCustomer;

    public Customer(String nameCustomer) {
        this.id = (int) (Math.random() * 500);
        this.nameCustomer = nameCustomer;
    }

    public Customer(long id, String nameCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
    }

    public long getId() {
        return id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    @Override
    public String toString() {
        return id + " " + nameCustomer;
    }
}