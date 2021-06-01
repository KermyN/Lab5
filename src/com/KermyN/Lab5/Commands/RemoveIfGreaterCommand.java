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
        Dragon currentDragon = dragons.get(ioManager.IntegerReader("Enter key:"));
        dragons.removeGreater(currentDragon.getId());
    }

    @Override
    public String getDescription() {
        return ":Удалить элементы с большим ключем чем у данного";
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }
}