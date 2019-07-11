package main.java.com.crud.view;

import java.io.IOException;
import java.util.Scanner;

import static main.java.com.crud.view.CategoryView.ACTIONS_CATEGORY;
import static main.java.com.crud.view.CustomerView.ACTIONS_CUSTOMER;
import static main.java.com.crud.view.ProjectsView.ACTIONS_PROJECT;

public class ConsoleHelper {
    private static final String WELCOME_MESSAGE = "Добро пожаловать!\n" +
            "Выберите раздел:\n" +
            "1.Проекты\n" +
            "2.Покупатели\n" +
            "3.Категории\n";

    public void run() throws IOException {
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        switch (line) {
            case "1":
                ProjectsView projectsView = new ProjectsView();
                System.out.println(ACTIONS_PROJECT);
                String actionProject = scanner.next();
                switch (actionProject) {
                    case "1":
                        projectsView.createProject();
                        break;
                    case "2":
                        projectsView.updateProject();
                        break;
                    case "3":
                        projectsView.deleteProject();
                        break;
                    case "4":
                        projectsView.getIdProject();
                        break;
                    case "5":
                        projectsView.getIdByValProject();
                        break;
                    case "6":
                        projectsView.printProject();
                        break;
                }
                break;
            case "2":
                CustomerView customerView = new CustomerView();
                System.out.println(ACTIONS_CUSTOMER);
                String actionCustomer = scanner.next();
                switch (actionCustomer) {
                    case "1":
                        customerView.createCustomer();
                        break;
                    case "2":
                        customerView.updateCustomer();
                        break;
                    case "3":
                        customerView.deleteCustomer();
                        break;
                    case "4":
                        customerView.getIdCustomer();
                        break;
                    case "5":
                        customerView.getIdByValCustomer();
                        break;
                    case "6":
                        customerView.printCustomers();
                        break;
                }
                break;
            case "3":
                CategoryView categoryView = new CategoryView();
                System.out.println(ACTIONS_CATEGORY);
                String actionCategory = scanner.next();
                switch (actionCategory) {
                    case "1":
                        categoryView.createCategory();
                        break;
                    case "2":
                        categoryView.updateCategory();
                        break;
                    case "3":
                        categoryView.deleteCategory();
                        break;
                    case "4":
                        categoryView.getIdCategory();
                        break;
                    case "5":
                        categoryView.getIdByValCategory();
                        break;
                    case "6":
                        categoryView.printCategory();
                        break;
                }
                break;
        }
    }
}
