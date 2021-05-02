package com.KermyN.Lab5;

import java.io.*;
import java.util.*;

public class Presenter {
    private String  currentString;
    private String lastCommand;
    private InputStream inputStream;
    Model model = new Model("D:/ITMO/Proga/Lab5/src/Data.xml");

    Presenter(Model model, InputStream InputStream) {
        this.model = model;
        lastCommand = "";
        this.inputStream = InputStream;
        this.start();
    }

    public void start() {
        Scanner scan = new Scanner(this.inputStream);
        do {
            try {
                currentString = scan.nextLine().trim();
            } catch (NoSuchElementException ex) {
                scan.close();
            }
            if (currentString.isEmpty()) {
                System.out.println("Введите команду");
                currentString = "";
                continue;
            }
            Scanner stringScanner = new Scanner(lastCommand);
            lastCommand = stringScanner.next();
            switch (lastCommand) {
                case "help":
                    model.help();
                default:
                    System.out.println("Неизвестная команда");
            }
        } while (!currentString.equals("exit"));
    }
}