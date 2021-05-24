package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.collections.*;

import java.io.IOException;

public class UpdateCommand extends Command {

    public UpdateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws IOException {
        int id = ioManager.IntegerReader("Enter id:");
        Dragon element = collectionWork.get(id);
        if (element == null) {
            ioManager.writeLine("Элемент с данным ключём не найден.");
        } else {
            collectionWork.remove(id);
            InsertCommand addCommand = new InsertCommand(model);
            addCommand.execute();
        }
    }

    @Override
    public String getDescription() {
        return ":обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}