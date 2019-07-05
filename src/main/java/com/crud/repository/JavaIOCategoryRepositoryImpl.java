package main.java.com.crud.repository;

import main.java.com.crud.model.Category;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JavaIOCategoryRepositoryImpl implements CategoryRepository {
    private static String FILE = "src\\main\\java\\com\\storage\\categories.txt";

    @Override
    public void update(Category value) {
        List<String> linesForUpdate = null;
        try {
            linesForUpdate = Files.readAllLines(Paths.get(FILE));
            String id = String.valueOf(value.getId());

            for (int i = 0; i < linesForUpdate.size(); i++) {
                String line = linesForUpdate.get(i).substring(0, linesForUpdate.get(i).indexOf(' '));
                if (line.equals(id)) {
                    linesForUpdate.set(i, value.toString());
                }
            }
            Files.write(Paths.get(FILE), linesForUpdate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long aLong) {
        List<String> linesForDelete = null;
        try {
            linesForDelete = Files.readAllLines(Paths.get(FILE));
            String id = String.valueOf(aLong);

            for (int i = 0; i < linesForDelete.size(); i++) {
                String line = linesForDelete.get(i).substring(0, linesForDelete.get(i).indexOf(' '));
                if (line.equals(id)) {
                    linesForDelete.remove(i);
                }
            }
            Files.write(Paths.get(FILE), linesForDelete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Category value) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
            printWriter.println(value);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Category getById(Long aLong) {
        List<String> linesForDelete = null;
        try {
            linesForDelete = Files.readAllLines(Paths.get(FILE));
            String id = String.valueOf(aLong);
            String name = null;

            for (int i = 0; i < linesForDelete.size(); i++) {
                String line = linesForDelete.get(i).substring(0, linesForDelete.get(i).indexOf(' '));
                if (line.equals(id)) {
                    name = linesForDelete.get(i).substring(linesForDelete.get(i).indexOf(' ') + 1, linesForDelete.get(i).length());
                    break;
                }
            }
            return new Category(aLong, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category getByValue(String value) {
        List<String> linesForDelete = null;
        try {
            linesForDelete = Files.readAllLines(Paths.get(FILE));

            Long id = null;
            String name = null;

            for (int i = 0; i < linesForDelete.size(); i++) {
                if (linesForDelete.get(i).indexOf(value) != -1) {
                    id = Long.parseLong(linesForDelete.get(i).substring(0, linesForDelete.get(i).indexOf(' ')));
                    name = linesForDelete.get(i).substring(linesForDelete.get(i).indexOf(' ') + 1, linesForDelete.get(i).length());
                }
            }
            return new Category(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getAll() throws IOException {
        List<String> category = Files.readAllLines(Paths.get(FILE), Charset.defaultCharset());
        return category;
    }
}