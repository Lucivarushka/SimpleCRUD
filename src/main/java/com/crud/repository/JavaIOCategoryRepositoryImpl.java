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
    private static String FILE = "src\\main\\resources\\categories.txt";

    @Override
    public void update(Category value) {
        List<String> linesForUpdate;
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
        List<String> linesForDelete;
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
        String lineForSave = value.getId() + " " + value.getNameCategory();
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
            printWriter.println(lineForSave);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Category getById(Long aLong) {
        List<String> linesForId;
        try {
            linesForId = Files.readAllLines(Paths.get(FILE));
            String id = String.valueOf(aLong);
            String name = null;

            for (int i = 0; i < linesForId.size(); i++) {
                String line = linesForId.get(i).substring(0, linesForId.get(i).indexOf(' '));
                if (line.equals(id)) {
                    name = linesForId.get(i).substring(linesForId.get(i).indexOf(' ') + 1, linesForId.get(i).length());
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
        List<String> linesForVal;
        try {
            linesForVal = Files.readAllLines(Paths.get(FILE));

            Long id = null;
            String name = null;

            for (int i = 0; i < linesForVal.size(); i++) {
                if (linesForVal.get(i).indexOf(value) != -1) {
                    id = Long.parseLong(linesForVal.get(i).substring(0, linesForVal.get(i).indexOf(' ')));
                    name = linesForVal.get(i).substring(linesForVal.get(i).indexOf(' ') + 1, linesForVal.get(i).length());
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