package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.collections.Dragon;

import java.io.IOException;

public class ReplaceIfLowerCommand extends Command{
    public ReplaceIfLowerCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws IOException {
        int id = ioManager.IntegerReader("Введите id:");
        Dragon element = dragons.get(id);
        Dragon newElement = new Dragon();
        while(element==null)element = dragons.get(ioManager.IntegerReader("Такого элемента нет. Введите id:"));
        if(newElement.getId()<element.getId()) {
            dragons.remove(id);
            InsertCommand addCommand = new InsertCommand(model);
            addCommand.execute();
        }
    }

    @Override
    public String getDescription() {
        return ":заменить значение по ключу, если новое значение меньше старого";
    }

    @Override
    public String getName() {
        return "replace_if_low";
    }
}