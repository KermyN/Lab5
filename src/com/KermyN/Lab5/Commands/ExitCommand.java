package com.KermyN.Lab5.Commands;
import com.KermyN.Lab5.Model;
public class ExitCommand extends Command{
    public ExitCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() {
        model.stop();
    }

    @Override
    public String getDescription() {
        return ":завершить программу (без сохранения в файл)";
    }

    @Override
    public String getName() {
        return "exit";
    }
}
