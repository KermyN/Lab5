package com.KermyN.Lab5;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
* @author Mikhail Minochkin R3140, CYNP, ITMO
 */

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        Model manipulator = new Model();
        try {
            manipulator.uploadFile(String.valueOf(args[0]));
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Incorrect launch");
            System.exit(0);
        }
        manipulator.run();
    }
}
