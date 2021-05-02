package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.Hashtable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.time.ZonedDateTime;
import java.io.File;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Dragons{
@XmlElement(name = "dragon")
    public static Hashtable<Integer, Dragon> dragonCollection = new Hashtable<Integer, Dragon>();
    private final ZonedDateTime creationDate;
    public Dragons() {
        creationDate = ZonedDateTime.now();
    }
    public static Hashtable<Integer, Dragon> getCollection(){return dragonCollection;}
    Dragons dragons;

    public void uploadData(String path) {
        try {
            System.out.println(ZonedDateTime.now());
            File file = new File(path);
            FileInputStream fs = new FileInputStream(file);
            JAXBContext context = JAXBContext.newInstance(Dragons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            dragons = (Dragons) unmarshaller.unmarshal(fs);
        } catch (UnmarshalException e) {
            System.out.println("Invalid file");
            System.exit(0);
        } catch (JAXBException et) {
            et.printStackTrace();
        } catch (FileNotFoundException et) {
            et.printStackTrace();
        }
        finally {
        // CorrectDataReader("Data.xml");
        System.out.println(dragonCollection.toString());
        }
}

    /**
     * Очистка коллекции
     */
    public void clear() {
        dragonCollection.clear();
    }
}



/*@Override
public String toString()
{
    //return
}

 */