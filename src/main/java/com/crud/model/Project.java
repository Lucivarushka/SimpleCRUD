package main.java.com.crud.model;

import java.util.Iterator;
import java.util.Set;

public class Project {
    private static long id;
    private String nameProjects;
    private ProjectStatus projectStatus;
    private Set<Category> categories;
    private Customer customer;

    public Project(String nameProjects, ProjectStatus projectStatus, Customer customer, Set<Category> categories) {
        this.id = (int) (Math.random() * 500);
        this.nameProjects = nameProjects;
        this.projectStatus = projectStatus;
        this.customer = customer;
        this.categories = categories;
    }

    public Project(long id, String nameProjects, ProjectStatus projectStatus, Customer customer, Set<Category> categories) {
        this.id = id;
        this.nameProjects = nameProjects;
        this.projectStatus = projectStatus;
        this.customer = customer;
        this.categories = categories;
    }

    public static void setId(long id) {
        Project.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNameProjects() {
        return nameProjects;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getIdCategories(){
        String categToStr = "";
        Iterator<Category> iter = categories.iterator();
        while (iter.hasNext()) {
            categToStr += "[" + iter.next().getId() + "]";
        }
        return categToStr;
    }

    @Override
    public String toString() {
        String categToStr = "";
        Iterator<Category> iter = categories.iterator();
        while (iter.hasNext()) {
            categToStr += "[" + iter.next() + "]";
        }
        return id + " " + nameProjects + "/" + projectStatus + "/" + customer.getId() + "/" + categToStr;
    }
}