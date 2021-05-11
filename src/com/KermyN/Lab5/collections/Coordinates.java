package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PROPERTY)

/*
 * Класс для координат дракона
 */
@XmlRootElement
public class Coordinates {
    @XmlElement
    private Integer x; //Поле не может быть null
    @XmlElement
    private long y;

    Coordinates() {}
    public Coordinates(Integer x, long y) {
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