package main.java.com.crud.view;

import main.java.com.crud.controller.CategoryController;
import main.java.com.crud.model.Category;

import java.io.IOException;
import java.util.Scanner;

public class CategoryView {
    public static void run() throws IOException {
        CategoryController categContrl = new CategoryController();
        String welcome = "Список всех категорий:";
        System.out.println(welcome);
        for (String item : categContrl.printAll()) {
            System.out.println(item);
        }

        String message = "Введите действие:\n" +
                "1.Создать новую категорию\n" +
                "2.Изменить категорию\n" +
                "3.Удалить категорию\n" +
                "4.Получить наименование категории по индексу\n" +
                "5.Получить индекс категории по наименованию\n";
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        String enter = scanner.next();
        switch (enter) {
            case "1":
                System.out.println("Введите имя новой категории:");
                String name = scanner.next();
                Category categoryNew = new Category(name);
                categContrl.createCategory(categoryNew);
                break;
            case "2":
                System.out.println("Введите индекс категории для ее изменения:");
                long index = Long.parseLong(scanner.next());
                System.out.println("Введите новое название категории:");
                String newname = scanner.next();
                Category updateCategory = new Category(index, newname);
                categContrl.updateCategory(updateCategory);
                break;
            case "3":
                System.out.println("Введите индекс категории для ее удаления:");
                long indexForDelete = Long.parseLong(scanner.next());
                categContrl.deleteCategory(indexForDelete);
                break;
            case "4":
                System.out.println("Введите индекс категории для получения именования:");
                long id = Long.parseLong(scanner.next());
                System.out.println(categContrl.getValueByIndex(id).toString());
                break;
            case "5":
                System.out.println("Введите значение категории для получения индекса:");
                String value = scanner.next();
                System.out.println(categContrl.getIndexByValue(value).toString());
                break;
        }
    }
}