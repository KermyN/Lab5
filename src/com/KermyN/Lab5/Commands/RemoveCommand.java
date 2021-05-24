package com.KermyN.Lab5.Commands;


import com.KermyN.Lab5.*;

public class RemoveCommand extends Command{
    public RemoveCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public String getName() {
        return "remove";
    }
}
