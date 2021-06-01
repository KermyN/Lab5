package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;

import java.io.IOException;

public class FilterContainsNameCommand extends Command{

    public FilterContainsNameCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws IOException {
        ioManager.writeLine("Введите подстроку:");
        String substring = ioManager.read();
        ioManager.writeLine(dragons.subStringSearcher(substring));
    }

    @Override
    public String getDescription() {return ":вывести элементы, значение поля name которых содержит заданную подстроку"; }

    @Override
    public String getName() {
        return "filter_contains_name";
    }
}
