package com.KermyN.Lab5;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
* @author Mikhail Minochkin R3140, CYNP, ITMO
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, JAXBException {
        Model manipulator = new Model("D:/ITMO/Proga/Lab5/src/Data.xml");
        manipulator.run();
    }
}
