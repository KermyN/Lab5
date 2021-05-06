package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;

public class SaveCommand extends Command{
    public SaveCommand(Model model) {
        super(model);
    }
    @Override
    public void execute(){
        collection.save();
        ioManager.writeLine("Коллекция успешно сохранена");
    }

    @Override
    public String getDescription() {
        return ":сохранить коллекцию в файл";
    }

    @Override
    public String getName() {
        return "save";
    }
}
