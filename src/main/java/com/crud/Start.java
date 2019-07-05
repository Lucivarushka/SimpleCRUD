package main.java.com.crud;

import main.java.com.crud.view.CategoryView;
import main.java.com.crud.view.CustomerView;
import main.java.com.crud.view.ProjectsView;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать!\n" +
                "Выберите раздел:\n" +
                "1.Проекты\n" +
                "2.Покупатели\n" +
                "3.Категории\n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        switch (line) {
            case "1":
                ProjectsView projectsView = new ProjectsView();
                projectsView.run();
                break;
            case "2":
                CustomerView customerView = new CustomerView();
                customerView.run();
                break;
            case "3":
                CategoryView categoryView = new CategoryView();
                categoryView.run();
                break;
        }
    }
}