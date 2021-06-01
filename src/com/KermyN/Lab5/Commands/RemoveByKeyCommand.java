package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;

import java.io.IOException;

public class RemoveByKeyCommand extends Command{
    public RemoveByKeyCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws IOException, NumberFormatException{

        int key = ioManager.IntegerReader("Enter key:");
        if(dragons.get(key)==null){
            ioManager.writeLine("Element with entered key was not found.");
        }
        else{
            ioManager.writeLine("Dragon "+ dragons.get(key).getName() +" has been deleted.");
            dragons.remove(key);
        }
    }

    @Override
    public String getDescription() {
        return ":Удалить элемент по ключу";
    }

    @Override
    public String getName() {
        return "remove_key";
    }
}

