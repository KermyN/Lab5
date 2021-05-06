package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.IOManager;
import com.KermyN.Lab5.collections.*;
import com.KermyN.Lab5.collections.Dragon;
import javax.xml.bind.JAXBException;
import java.io.IOException;
/**
 * Класс - заготовка для команд, определяет их поведение
 */
public abstract class Command {
    protected final Model model;
    protected final IOManager ioManager;
    protected final Dragons collection;

    public Command(Model model) {
        this.model = model;
        this.ioManager = model.getIOManager();
        this.collection = model.getCollection();
    }
    /**
     * метод, который непорседственно выполняет команду
     */
    public abstract void execute() throws IOException, JAXBException;
    /**
     * метод, возвращающий описание команды
     */
    public abstract String getDescription();
    /**
     * метод, возвращающий имя команды
     */
    public abstract String getName();
}
