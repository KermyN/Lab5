package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.IOManager;
import com.KermyN.Lab5.collections.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
/**
 * Abstract class defining behavior of commands
 */
public abstract class Command {
    protected final Model model;
    protected final IOManager ioManager;
    protected final Dragons dragons;

    public Command(Model model) {
        this.model = model;
        this.ioManager = model.getIOManager();
        this.dragons =model.getDragons();
    }
    /**
     * Method executing command
     */
    public abstract void execute() throws IOException, JAXBException;
    /**
     * Return description of command
     */
    public abstract String getDescription();
    /**
     * Return name of command
     */
    public abstract String getName();
}
