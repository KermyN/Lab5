package com.KermyN.Lab5;

import com.KermyN.Lab5.collections.Dragons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Model {
    private Date initDate;
    protected File currentCollection;
    private final Dragons collection = new Dragons();
    protected static Map<String, String> commandList = new HashMap<>();

    Model(String path) {
        try {
            if (path == null) throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            System.out.println("Неверный путь");
            System.exit(1);
        }
        {
            collection.uploadData(path);
            // dragonHashtable.putAll(getId,fi);

        }
    }


    public void help() {
        System.out.println("Тут должна быть справка");
    }
}
