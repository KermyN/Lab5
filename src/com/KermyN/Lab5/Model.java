package com.KermyN.Lab5;

import com.KermyN.Lab5.collections.Dragons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Model {
    private Date initDate;
    protected File currentCollection;
    Dragons collection = new Dragons();
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

    /*private static com.KermyN.Lab5.collections.Dragon uploadData(String path) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(com.KermyN.Lab5.collections.Dragon.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (com.KermyN.Lab5.collections.Dragon) un.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
     */
    public void help() {
        System.out.println("Тут должна быть справка");
    }
}
