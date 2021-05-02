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
import java.util.Iterator;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Dragons {
    @XmlElement(name = "Dragon")
    public static Hashtable<Integer, Dragon> dragonCollection = new Hashtable<Integer, Dragon>();
    private final ZonedDateTime creationDate;

    public Dragons() {
        creationDate = ZonedDateTime.now();
    }

    public static Hashtable<Integer, Dragon> getCollection() {
        return dragonCollection;
    }

    Dragons dragons;

    public void uploadData(String path){
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
        } finally {
            DataCheck("Data.xml");
            System.out.println(dragonCollection.toString());

        }
    }
    public void DataCheck(String filename){
        for(Dragon dragon: dragonCollection.values()){
            if(!(dragon.getCreationDate() == null) || (dragon.getName() == null) || (dragon.getName() == "") || dragon.getAge() < 0
                    || dragon.getCharacter() == null || dragon.getColor() == null || dragon.getType() == null || dragon.getCoordinates().getX() ==null
                    || dragon.getCoordinates().getY() > 404|| dragon.getCave().getNumberOfTreasures()<0){
                System.out.println("Неккоректные значения в файле");
                System.exit(0);
            }
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