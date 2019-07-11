package main.java.com.crud.view;

import main.java.com.crud.controller.CategoryController;
import main.java.com.crud.model.Category;

import java.io.IOException;
import java.util.Scanner;

public class CategoryView {
    public static final String ACTIONS_CATEGORY = "Введите действие:\n" +
            "1.Создать новую категорию\n" +
            "2.Изменить категорию\n" +
            "3.Удалить категорию\n" +
            "4.Получить наименование категории по индексу\n" +
            "5.Получить индекс категории по наименованию\n" +
            "6.Список всех категорий\n";

    CategoryController categContrl = new CategoryController();

    public void createCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя новой категории:");
        String name = scanner.next();
        Category categoryNew = new Category(name);
        categContrl.createCategory(categoryNew);
    }

    public void updateCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс категории для ее изменения:");
        long index = Long.parseLong(scanner.next());
        System.out.println("Введите новое название категории:");
        String newname = scanner.next();
        Category updateCategory = new Category(index, newname);
        categContrl.updateCategory(updateCategory);
    }

    public void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс категории для ее удаления:");
        long indexForDelete = Long.parseLong(scanner.next());
        categContrl.deleteCategory(indexForDelete);
    }

    public void getIdCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс категории для получения именования:");
        long id = Long.parseLong(scanner.next());
        System.out.println(categContrl.getValueByIndex(id).toString());
    }

    public void getIdByValCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение категории для получения индекса:");
        String value = scanner.next();
        System.out.println(categContrl.getIndexByValue(value).toString());
    }

    public void printCategory() throws IOException {
        System.out.println("Список всех категорий:");
        for (String item : categContrl.printAll()) {
            System.out.println(item);
        }
    }
}
