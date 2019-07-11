package main.java.com.crud;

import main.java.com.crud.view.CategoryView;
import main.java.com.crud.view.ConsoleHelper;
import main.java.com.crud.view.CustomerView;
import main.java.com.crud.view.ProjectsView;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.run();
    }
}