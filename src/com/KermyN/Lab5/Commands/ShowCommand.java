package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;

public class ShowCommand extends Command {
    public ShowCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        ioManager.writeLine(dragons.getCollection().toString());
    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
