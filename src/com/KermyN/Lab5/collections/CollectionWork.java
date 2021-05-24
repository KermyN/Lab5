package com.KermyN.Lab5.collections;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class CollectionWork {
    protected Hashtable<Integer, Dragon> dragonHashtable = new Hashtable<>();
    private final ZonedDateTime creationDate;
    public CollectionWork() {
        creationDate = ZonedDateTime.now();
    }

    public Hashtable<Integer, Dragon> getCollection() { return dragonHashtable; }

    CollectionWork collectionWork;

    public void dataUpdate(LinkedList<Dragon> InputCollection){
        for (Dragon dragon: InputCollection){
            dragon.setId();
            dragon.setCreationDate();
            dragonHashtable.put(dragon.setId(), dragon);
        }
        System.out.println(dragonHashtable);
    }

    public LinkedList dataOutdate(){
        LinkedList outList = new LinkedList();
        for (Dragon dragon: dragonHashtable.values()){
            outList.add(dragon);
        }
        return outList;
    }
    /**
     * Очистка коллекции
     */
    public void clear() { dragonHashtable.clear();}

    /**
     * возвращает дракона с максимальным именем
     */
    public Dragon MaxName(){
        String minString = "";
        Dragon p = new Dragon();
        for (Dragon person : dragonHashtable.values()) {
            if(person.getName().compareToIgnoreCase(minString) > 0){
                minString = person.getName();
                p = person;
            }
        }
        return p;
    }

    /**
     * Добавляет объект в коллекцию
     */
    public void add(Dragon element) { dragonHashtable.put(element.getId(),element);}
    /**
     * удаляет объект из коллекции по его id
     */
    public void remove(int key) {
       // HashMap<Integer, Dragon> temp = new HashMap(dragonHashtable);
        //Dragon element = getToRemove(key, temp);
        //temp.remove(element.getId());
        dragonHashtable.remove(key);
        //dragonHashtable.putAll(temp);
    }

    /**
     * получение дракона по его id
     */
    public Dragon get(int id) {
        for (Dragon element : dragonHashtable.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }
    public Dragon getToRemove(int id, Hashtable<Integer, Dragon> temp) {
        for (Dragon element : temp.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        for (Dragon dragon : dragonHashtable.values()) {
            return "Dragon{" +
                    "id=" + dragon.getId() +
                    ", name='" + dragon.getName() + '\'' +
                    ", age=" + dragon.getAge() +
                    ", coordinates='" + dragon.getCoordinates() + '\'' +
                    ", color='" + dragon.getColor() + '\'' +
                    ", type='" + dragon.getType() + '\'' +
                    ", character='" + dragon.getCharacter() + '\'' +
                    ", cave='" + dragon.getCave() + '\'' +
                    ", creationDate='" + dragon.getCreationDate() + '\'' +
                    '}';
        }

        return null;//getCollection().toString();
    }

    public ZonedDateTime getInitializationDate() {
        return creationDate;
    }

    /**
     * Возвращает размер коллекции
     */
    public int getSize() {
        return dragonHashtable.size();
    }

    /**
     * Возвращает дракона с минимальным количеством сокровищ
     */

    public Dragon minCave(){
        Double  cave= Double.MAX_VALUE;
        Dragon minCave = null;
        for(Dragon dragon : dragonHashtable.values()) {
        if(dragon.getCave().getNumberOfTreasures()<cave) {cave = dragon.getCave().getNumberOfTreasures();minCave=dragon;}
        }
        if(cave== Double.MAX_VALUE){System.out.println("коллекция пустая"); return null;}
        else return minCave;
    }
}
