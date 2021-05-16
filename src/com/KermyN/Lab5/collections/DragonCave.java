package com.KermyN.Lab5.collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
/*
 * Представляет пещеру дракона с сокровищами
 */
@XmlRootElement
public class DragonCave {
    @XmlElement
    private double numberOfTreasures; //Значение поля должно быть больше 0
    DragonCave() {}
public DragonCave(double numberOfTreasures){
    this.numberOfTreasures=numberOfTreasures;
}

@Override
public String toString(){
        return "Количество сокровищ = "+ numberOfTreasures;
}
    public double getNumberOfTreasures() {
        return numberOfTreasures;
    }
}

