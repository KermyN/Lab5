package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
/*
 * Представляет пещеру дракона с сокровищами
 */

public class DragonCave {
    private double numberOfTreasures; //Значение поля должно быть больше 0


    public double getNumberOfTreasures() {
        return numberOfTreasures;
    }
}

