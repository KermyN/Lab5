package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;
public class InfoCommand extends Command{
    public InfoCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() {
        ioManager.writeLine("Тип коллекции: " + collectionWork.getClass());
        ioManager.writeLine("Дата инициализации: " + collectionWork.getInitializationDate());
        ioManager.writeLine("Количество элементов: " + collectionWork.getSize());
    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public String getName() {
        return "info";
    }
}
