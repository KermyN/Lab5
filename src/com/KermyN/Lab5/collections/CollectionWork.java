package com.KermyN.Lab5.collections;

import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.LinkedList;

public class CollectionWork {
    public static Hashtable<Integer, Dragon> dragonHashtable = new Hashtable<>();
    private final ZonedDateTime creationDate;

    public CollectionWork() {
        creationDate = ZonedDateTime.now();
    }
    public Hashtable<Integer, Dragon> getCollection() { return dragonHashtable; }

    CollectionWork collectionWork;

    protected void dataUpdate(LinkedList<Dragon> InputCollection){
        for (Dragon dragon: InputCollection){
            dragon.setId();
            dragon.setCreationDate();
            dragonHashtable.put(dragon.setId(), dragon);
        }
        System.out.println(dragonHashtable);
    }

    protected LinkedList dataOutdate(){
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
     * Добавляет объект в коллекцию
     */
    public void add(Dragon element) { dragonHashtable.put(element.getId(),element);}
    /**
     * удаляет объект из коллекции по его id
     */
    public void remove(long key) {
        Dragon element = get(key);
        dragonHashtable.remove(element);
    }

    /**
     * получение дракона по его id
     */
    public Dragon get(long id) {
        for (Dragon element : dragonHashtable.values()) {
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

}
