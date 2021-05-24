package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.collections.*;
import java.io.IOException;

public class RemoveIfGreaterCommand extends Command{
    public RemoveIfGreaterCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws IOException, NumberFormatException{

        Dragon dragon  = collectionWork.get(ioManager.IntegerReader("Введите ключ:"));
        while(dragon==null){dragon = collectionWork.get(ioManager.IntegerReader("Такого элемента нет. Введите ключ:"));}
        for(Dragon dragons : collectionWork.getCollection().values())
        {if (dragons.getId() > dragon.getId()) System.out.println(dragons.getName()+" удален");collectionWork.remove(dragons.getId());}

    }

    @Override
    public String getDescription() {
        return ":Удалить элементы с большим ключем чем у заданного";
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }
}