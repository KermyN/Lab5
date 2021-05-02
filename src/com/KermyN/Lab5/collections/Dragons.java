package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.Hashtable;
import java.time.ZonedDateTime;
import java.io.File;
import java.util.Iterator;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.*;

@XmlRootElement(name = "Dragons")
@XmlAccessorType(XmlAccessType.NONE)
public class Dragons {
    @XmlElement(name = "Dragon")
    public static Hashtable<Integer, Dragon> dragonCollection = new Hashtable<Integer, Dragon>();
    private final ZonedDateTime creationDate;

    public Dragons() {
        creationDate = ZonedDateTime.now();
    }

    public Hashtable<Integer, Dragon> getCollection() {
        return dragonCollection;
    }

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
            e.printStackTrace();
            System.exit(0);
        } catch (JAXBException et) {
            //et.printStackTrace();
        } catch (FileNotFoundException et) {
            et.printStackTrace();
        }
        try {
            System.out.println(dragonCollection.toString());
            DataCheck();
            System.out.println(dragonCollection.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void DataCheck() {
        for (Dragon dragon : dragonCollection.values()) {
            if (!(dragon.getCreationDate() == null) || (dragon.getName() == null) || (dragon.getName() == "") || dragon.getAge() < 0
                    || dragon.getCharacter() == null || dragon.getColor() == null || dragon.getType() == null || dragon.getCoordinates().getX() == null
                    || dragon.getCoordinates().getY() > 404 || dragon.getCave().getNumberOfTreasures() < 0) {
                System.out.println("Неккоректные значения в файле");
                System.exit(0);
            }
            System.out.println(dragon.toString());
        }
    }

    /**
     * Очистка коллекции
     */
    public void clear() {
        dragonCollection.clear();
    }
    /**
     * Добавляет объект в коллекцию
     */
    public void add(Dragon element) {
        dragonCollection.put(element.getId(),element);
    }

    /**
     * Сохраняет коллекцию в xml файл
     */
    public void save(){
        StringWriter sw = new StringWriter();
        try {
            Dragons people = new Dragons();
            JAXBContext context = JAXBContext.newInstance(Dragons.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(people, new File("NewData.xml"));
            jaxbMarshaller.marshal(people, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * удаляет объект из коллекции по его id
     */
    public void remove(long key) {
        Dragon element = get(key);
        dragonCollection.remove(element);
    }

    /**
     * получает человека по его id
     */
    public Dragon get(long id) {
        for (Dragon element : dragonCollection.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        for (Dragon dragon : dragonCollection.values()) {
            /*return "Dragon{" +
                    "id=" + dragon.getId() +
                    ", name='" + dragon.getName() + '\'' +
                    ", age=" + dragon.getAge() +
                    ", coordinates='" + dragon.getCoordinates() + '\'' +
                    ", color='" + dragon.getColor() + '\'' +
                    ", type='" + dragon.getType() + '\'' +
                    ", character='" + dragon.getCharacter() + '\'' +
                    ", cave='" + dragon.getCave() + '\'' +
                    ", creationDate='" + dragon.getCreationDate() + '\'' +
                    '}'; */
        }

        return getCollection().toString();
    }
}



/*@Override
public String toString()
{
    //return
}

 */