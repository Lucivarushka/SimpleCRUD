package main.java.com.crud.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {

    void create(T value);

    void update(T value) throws IOException;

    void delete(ID id);

    List<String> getAll() throws IOException;

}