package main.java.com.crud.controller;

import main.java.com.crud.model.Category;
import main.java.com.crud.model.Customer;
import main.java.com.crud.model.Project;
import main.java.com.crud.model.ProjectStatus;
import main.java.com.crud.repository.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ProjectController {
    private static ProjectRepository projects = new JavaIOProjectRepositoryImpl();
    private Customer customerProj;
    private static CustomersRepository customers = new JavaIOCustomersRepositoryImpl();
    private static CategoryRepository category = new JavaIOCategoryRepositoryImpl();
    private Set<Category> categoryProject = new TreeSet<>();

    public List<String> printAll() throws IOException {
        return projects.getAll();
    }

    public void createProject(String name, String customer, String categories) {
        customerProj = customers.getByValue(customer);
        long[] numArr = Arrays.stream(categories.split("[ ]")).mapToLong(Long::parseLong).toArray();

        for (int i = 0; i < numArr.length; i++) {
            categoryProject.add(category.getById(numArr[i]));
        }

        projects.create(new Project(name, ProjectStatus.ACTIVE, customerProj, categoryProject));
    }

    public void updateProject(long id, String name, ProjectStatus ps, String customer, String categories) {
        customerProj = customers.getByValue(customer);
        long[] numArr = Arrays.stream(categories.split("[ ]")).mapToLong(Long::parseLong).toArray();

        for (int i = 0; i < numArr.length; i++) {
            categoryProject.add(category.getById(numArr[i]));
        }

        Project prj = new Project(id, name, ps, customerProj, categoryProject);
        try {
            projects.update(prj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(long index) {
        projects.delete(index);
    }

    public String getValueByIndex(long index) {
        return projects.getById(index);
    }

    public String getIndexByValue(String value) {
        return projects.getByValue(value);
    }
}
