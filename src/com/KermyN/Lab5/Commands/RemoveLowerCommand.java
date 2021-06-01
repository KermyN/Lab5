package com.KermyN.Lab5.Commands;


import com.KermyN.Lab5.*;
import com.KermyN.Lab5.collections.Dragon;

import java.io.IOException;

public class RemoveLowerCommand extends Command{
    public RemoveLowerCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws IOException, NumberFormatException{
        Dragon currentDragon = dragons.get(ioManager.IntegerReader("Введите ключ:"));
        while(currentDragon==null){currentDragon = dragons.get(ioManager.IntegerReader("Такого элемента нет. Введите ключ:"));}
        dragons.removeLower(currentDragon.getId());
    }


    @Override
    public String getDescription() {
        return ":удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}
