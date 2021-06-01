package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.collections.Color;
import java.io.IOException;

public class CountByColorCommand extends Command{
    public CountByColorCommand(Model model) {
        super(model);
    }
    //count_by_color
    @Override
    public void execute() throws IOException, NumberFormatException{
        Color color = ioManager.ColorReader("Введите цвет:");
        ioManager.writeLine(String.valueOf(dragons.ColorCounter(color)));
    }

    @Override
    public String getDescription() {return ":  вывести количество элементов, значение поля color которых равно заданному"; }

    @Override
    public String getName() {
        return "count_by_color";
    }
}
