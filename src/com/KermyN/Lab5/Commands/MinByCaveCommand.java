package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;

public class MinByCaveCommand extends Command{
    public MinByCaveCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws NumberFormatException{
      ioManager.write(dragons.minCave().toString());
    }

    @Override
    public String getDescription() {
        return ":Вывести элемент с минимальным количеством сокровищ";
    }

    @Override
    public String getName() {
        return "min_by_cave";
    }
}
