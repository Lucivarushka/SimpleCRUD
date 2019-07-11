package main.java.com.crud.view;

import main.java.com.crud.controller.CustomerController;
import main.java.com.crud.model.Customer;

import java.io.IOException;
import java.util.Scanner;

public class CustomerView {
    public static final String ACTIONS_CUSTOMER = "Введите действие:\n" +
            "1.Создать нового покупателя\n" +
            "2.Изменить имя покупателя\n" +
            "3.Удалить покупателя\n" +
            "4.Получить имя покупателя по индексу\n" +
            "5.Получить индекс покупателя по имени\n" +
            "6.Список всех покупателей\n";

    CustomerController custCont = new CustomerController();

    public void createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя нового покупателя:");
        String name = scanner.next();
        Customer customerNew = new Customer(name);
        custCont.createCategory(customerNew);
    }

    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс покупателя для изменения его имени:");
        long index = Long.parseLong(scanner.next());
        System.out.println("Введите новое название категории:");
        String newname = scanner.next();
        Customer updateCategory = new Customer(index, newname);
        custCont.updateCategory(updateCategory);
    }

    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс покупателя для его удаления:");
        long indexForDelete = Long.parseLong(scanner.next());
        custCont.deleteCategory(indexForDelete);
    }

    public void getIdCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс покупателя для получения его имени:");
        long id = Long.parseLong(scanner.next());
        System.out.println(custCont.getValueByIndex(id).toString());
    }

    public void getIdByValCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя или часть имени покупателя для получения индекса:");
        String value = scanner.next();
        System.out.println(custCont.getIndexByValue(value).toString());
    }

    public void printCustomers() throws IOException {
        System.out.println("Список всех покупателей:");
        for (String item : custCont.printAll()) {
            System.out.println(item);
        }
    }
}
