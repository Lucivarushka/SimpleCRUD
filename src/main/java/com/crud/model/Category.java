package main.java.com.crud.model;

public class Category implements Comparable<Category> {
    private long id;
    private String nameCategory;
    private int max = 1000;

    public Category(String nameCategory) {
        this.id = (int) (Math.random() * ++max);
        this.nameCategory = nameCategory;
    }

    public Category(long id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" + id + " " + nameCategory;
    }

    @Override
    public int compareTo(Category o) {
        return (int) (this.getId() - o.getId());
    }
}