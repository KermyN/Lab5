package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

/*
 * Класс для координат дракона
 */

public class Coordinates {
    private Integer x; //Поле не может быть null
    private long y;

    Coordinates() {}
    Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    @Override
    public String toString() {
        return "coordinates: " + getX() + " " + getY();
    }

    @Override
    public int hashCode() {
        return getX() + (int) getY();
    }
}