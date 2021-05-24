package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;

import java.io.IOException;

public class RemoveByKeyCommand extends Command{
    public RemoveByKeyCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws IOException, NumberFormatException{

        int key = ioManager.IntegerReader("Введите ключ:");
        if(collectionWork.get(key)==null){
            ioManager.writeLine("Элемент с данным ключём не найден.");
        }
        else{
            ioManager.writeLine("Объект "+ collectionWork.get(key).getName() +"удален.");
            collectionWork.remove(key);
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

