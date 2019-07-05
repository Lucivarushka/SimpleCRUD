package main.java.com.crud.view;

import main.java.com.crud.controller.ProjectController;
import main.java.com.crud.model.ProjectStatus;

import java.io.IOException;
import java.util.Scanner;

public class ProjectsView {
    public static void run() throws IOException {
        ProjectController projContr = new ProjectController();
        String welcome = "Список всех проектов:";
        System.out.println(welcome);
        for (String item : projContr.printAll()) {
            System.out.println(item);
        }

        String message = "Введите действие:\n" +
                "1.Создать новый проект\n" +
                "2.Изменить проект\n" +
                "3.Удалить проект\n" +
                "4.Получить имя покупателя по индексу\n" +
                "5.Получить индекс покупателя по имени";
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        String enter = scanner.next();
        switch (enter) {
            case "1":
                System.out.println("Введите название нового проекта:");
                String name = scanner.next();
                System.out.println("Введите id покупателя для нового проекта:");
                String customer = scanner.next();
                scanner.nextLine();
                System.out.println("Введите id категорий для нового проекта через ЗАПЯТУЮ:");
                String categories = scanner.nextLine();
                projContr.createProject(name, customer, categories);
                break;
            case "2":
                System.out.println("Введите индекс проекта для его изменения:");
                long indexUp = Long.parseLong(scanner.next());
                System.out.println("Введите имя проекта:");
                String namePrUp = scanner.next();
                System.out.println("Введите статус проекта:\n" +
                        "1.Активен\n" +
                        "2.Завершить\n" +
                        "3.Удалить");
                String pRjUp = scanner.next();
                ProjectStatus prsUp = null;
                switch (pRjUp) {
                    case "1":
                        prsUp = ProjectStatus.ACTIVE;
                        break;
                    case "2":
                        prsUp = ProjectStatus.FINISHED;
                        break;
                    case "3":
                        prsUp = ProjectStatus.DELETED;
                        break;
                }
                System.out.println("Введите id покупателя для измененного проекта:");
                String customerUp = scanner.next();
                scanner.nextLine();
                System.out.println("Введите id категорий для измененного проекта через пробел:");
                String categoriesUp = scanner.nextLine();
                projContr.updateProject(indexUp, namePrUp, prsUp, customerUp, categoriesUp);
                break;
            case "3":
                System.out.println("Введите индекс проекта для его удаления:");
                long indexForDelete = Long.parseLong(scanner.next());
                projContr.deleteProject(indexForDelete);
                break;
            case "4":
                System.out.println("Введите индекс проекта для получения всей информации:");
                long id = Long.parseLong(scanner.next());
                System.out.println(projContr.getValueByIndex(id).toString());
                break;
            case "5":
                System.out.println("Введите любую известную информацию или часть информации для получения индекса:");
                String value = scanner.next();
                System.out.println(projContr.getIndexByValue(value).toString());
                break;
        }
    }
}