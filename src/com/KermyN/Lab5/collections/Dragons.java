package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.Hashtable;
import java.time.ZonedDateTime;
import java.io.File;
import javax.xml.bind.*;
import java.io.StringWriter;
import java.util.*;

@XmlRootElement(name = "Dragons")
@XmlAccessorType(XmlAccessType.NONE)
public class Dragons{
    @XmlElement(name = "Dragon")
    public static LinkedList<Dragon> InputCollection = new LinkedList<>();


    public Dragons uploadData(String path) {
        try {
            File file = new File(path);
            FileInputStream inputFile = new FileInputStream(file);
            JAXBContext context = JAXBContext.newInstance(Dragons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Dragons dragons = (Dragons) unmarshaller.unmarshal(inputFile);
            DataCheck();
            return dragons;
        } catch (UnmarshalException e) {
            System.out.println("Invalid file");
            e.printStackTrace();
            System.exit(0);
        } catch (JAXBException et) {
            et.printStackTrace();
        } catch (FileNotFoundException et) {
            et.printStackTrace();
        }
        try {
            System.out.println(InputCollection.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CollectionWork getCollectionWorker(){
        CollectionWork collectionWork = new CollectionWork();
        collectionWork.dataUpdate(InputCollection);
        return collectionWork;
    }
    public void DataCheck() {
        for (Dragon dragon : InputCollection) {
            if ((dragon.getName() == null) || (dragon.getName() == "") || dragon.getAge() < 0
                    || dragon.getCharacter() == null || dragon.getColor() == null || dragon.getType() == null || dragon.getCoordinates().getX() == null
                    || dragon.getCoordinates().getY() > 404 || dragon.getCave().getNumberOfTreasures() < 0) {
                System.out.println("Неккоректные значения в файле");
                System.exit(0);
            }
            dragon.setId();
            System.out.println(dragon.toString());
        }
    }

    /**
     * Сохраняет коллекцию в xml файл
     */
    public void save(){
        StringWriter sw = new StringWriter();
        InputCollection =getCollectionWorker().dataOutdate();
        System.out.println(InputCollection);
        try {
            Dragons dragons = new Dragons();
            JAXBContext context = JAXBContext.newInstance(Dragons.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(dragons, new File("NewData.xml"));
            jaxbMarshaller.marshal(dragons, sw);
        } catch (JAXBException e){e.printStackTrace();}

    }




}