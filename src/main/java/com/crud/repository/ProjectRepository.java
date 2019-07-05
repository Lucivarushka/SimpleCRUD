package main.java.com.crud.repository;

import main.java.com.crud.model.Project;

public interface ProjectRepository extends GenericRepository<Project, Long> {

    String getById(Long id);

    String getByValue(String value);
}