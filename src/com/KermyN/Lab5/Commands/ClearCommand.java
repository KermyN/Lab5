package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;
public class ClearCommand extends Command{
    public ClearCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        collection.clear();
        ioManager.writeLine("Коллекция очищена.");
    }

    @Override
    public String getDescription() {
        return ":очистить коллекцию";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
