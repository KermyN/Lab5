package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;

public class HelpCommand extends Command{
    public HelpCommand(Model model) {
        super(model);
    }
    @Override
    public void execute(){
        for (Command command : model.getAllCommands()) {
            ioManager.write(command.getName() + " ");
            ioManager.writeLine(command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return ":вывести справку по доступным командам";
    }

    @Override
    public String getName() {
        return "help";
    }
}
