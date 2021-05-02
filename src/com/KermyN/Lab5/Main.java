package com.KermyN.Lab5;

import java.io.FileNotFoundException;

/**
* @author Mikhail Minochkin R3140, CYNP, ITMO
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Presenter manipulator = new Presenter(new Model("D:/ITMO/Proga/Lab5/src/Data.xml"), System.in);
    }
}
