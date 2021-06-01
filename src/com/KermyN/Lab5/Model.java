package com.KermyN.Lab5;


import com.KermyN.Lab5.collections.Dragons;
import com.KermyN.Lab5.Commands.*;
import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.util.*;

public class Model {
    private Dragons dragons=new Dragons();
    protected static Map<String, Command> commandList = new HashMap<>();
    private boolean stopFlag = false;
    private final IOManager ioManager = new IOManager();

   public Model() throws IOException {
        registerCommand(new HelpCommand(this));
        registerCommand(new InfoCommand(this));
        registerCommand(new SaveCommand(this));
        registerCommand(new InsertCommand(this));
        registerCommand(new ExecuteScriptCommand(this));
        registerCommand(new ClearCommand(this));
        registerCommand(new ExitCommand(this));
        registerCommand(new RemoveByKeyCommand(this));
        registerCommand(new UpdateCommand(this));
        registerCommand(new RemoveIfGreaterCommand(this));
        registerCommand(new MinByCaveCommand(this));
        registerCommand(new CountByColorCommand(this));
        registerCommand(new ShowCommand(this));
        registerCommand(new FilterContainsNameCommand(this));
        registerCommand(new RemoveLowerCommand(this));
        registerCommand(new ShowCommand(this));
        registerCommand(new ReplaceIfLowerCommand(this));
    }

    /**
     * Method runs executing process
     */
    public void run() throws IOException, JAXBException{
        while (!stopFlag) {
            readAndExecuteCommand();
        }
    }
    /**
     * Method upload data from xml and put dragons into collection
     */
    public void uploadFile(String path){
           this.dragons.uploadData(path);
           this.dragons.dataUpdate();
    }

    public IOManager getIOManager() {
        return ioManager;
    }

    public Dragons getDragons(){return dragons;}

    /**
     * Method launch command executing
     * @param commands Array of commands.
     */
    public void run(String[] commands) throws IOException, JAXBException {
        while (!stopFlag) {
            readAndExecuteCommands(commands);
        }
    }
    /**
     * Method register command
     * @param command Command link
     */
    private void registerCommand(Command command) {
        commandList.put(command.getName(), command);
    }
    /**
     * Method reads and executes current command.
     */
    public void readAndExecuteCommand() throws IOException, JAXBException{
        Command command = readCommand();
        if (command == null) {
            ioManager.writeLine("Command not found");
        } else {
            command.execute();
            ioManager.writeLine("");
        }
    }
    /**
     * Method reads command
     */
    private Command readCommand() {
        String name;
        do {
            name = ioManager.readNext().trim();
        } while (name.isEmpty());
        return getCommandByName(name);
    }

    public Command getCommandByName(String name) {
        return commandList.get(name.trim());
    }
    /**
     * Method reads and execute array of commands
     * @param commands Array of commands.
     */
    public void readAndExecuteCommands(String[] commands) throws IOException, JAXBException{
        for (String s : commands) {
            Command command = getCommandByName(s);
            if (command == null) {
                ioManager.writeLine("Command not found");
            } else {
                command.execute();
                ioManager.writeLine("");
            }
        }
    }
    /**
     * Method exit program
     */
    public void stop() {stopFlag = true; }
    /**
     * Method return all commands
     */
    public Collection<Command> getAllCommands() {
        return commandList.values();
    }

}
