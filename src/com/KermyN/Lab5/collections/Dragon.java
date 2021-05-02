package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;
import java.time.ZonedDateTime;

@XmlRootElement(name = "Dragon")
@XmlAccessorType(XmlAccessType.FIELD)

public class Dragon {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "creationDate")
    private String dateTimeString;
    @XmlTransient
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически\
    private Coordinates coordinates; //Поле не может быть null
    private int age; //Значение поля должно быть больше 0
    private Color color; //Поле может быть null
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonCave cave; //Поле не может быть null

    public Dragon() {
    }

    public Dragon(int id,String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int age, Color Color, DragonType type, DragonCharacter character, DragonCave cave) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.color = Color;
        this.type = type;
        this.character = character;
        this.cave = cave;
        this.creationDate = creationDate;
    }

    private int getRandNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getAge() {
        return age;
    }

    public Color getColor() {
        return color;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCave getCave() {
        return cave;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return ZonedDateTime.now();
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
        this.dateTimeString = creationDate.toString();
    }

    @Override
    public String toString() {
        return "com.KermyN.Lab5.collections.Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", coordinates='" + coordinates + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", character='" + character + '\'' +
                ", cave='" + cave + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}