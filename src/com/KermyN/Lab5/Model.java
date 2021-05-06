package com.KermyN.Lab5;

import com.KermyN.Lab5.collections.Dragons;
import com.KermyN.Lab5.Commands.*;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Model {
    private Date initDate;
    protected File currentCollection;
    private final Dragons collection = new Dragons();
    protected static Map<String, Command> commandList = new HashMap<>();
    private boolean stopFlag = false;
    private final IOManager ioManager = new IOManager();
    private final List<String> history = new LinkedList<>();


    Model(String path) throws IOException {
       uploadFile(path);
    }


    public void uploadFile(String path)throws IOException, FileNotFoundException{

        try {
            if (path == null) throw new FileNotFoundException();
            collection.uploadData(path);
            System.out.println(collection.toString());

        } catch (FileNotFoundException ex) {
            System.out.println("Неверный путь");
            System.exit(1);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public IOManager getIOManager() {
        return ioManager;
    }
    public Dragons getCollection() {
        return collection;
    }

    public void help() {
        System.out.println("Тут должна быть справка");
    }
    /**
     * Метод, запускающий цикл исполнения комманд.
     * @param commands массив команд, которые нужно выполнить
     */
    public void run(String[] commands) throws IOException, JAXBException {
        while (!stopFlag) {
            readAndExecuteCommands(commands);
        }
    }
    /**
     * Метод, осуществляющий чтение и исполнение очередной команды.
     */
    public void readAndExecuteCommand() throws IOException, JAXBException{
        Command command = readCommand();
        if (command == null) {
            ioManager.writeLine("Команда с указанным именем не найдена!");
        } else {
            command.execute();
            ioManager.writeLine("");
            history.add(command.getName());
        }
    }
    /**
     * Метод, осуществляющий чтение очередной комманды.
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
     * Метод, осуществляющий чтение и исполнение очередной команды.
     * @param commands массив команд которые нужно выполнить
     */
    public void readAndExecuteCommands(String[] commands) throws IOException, JAXBException{
        for (String s : commands) {
            Command command = getCommandByName(s);
            if (command == null) {
                ioManager.writeLine("Команда с указанным именем не найдена!");
            } else {
                command.execute();
                ioManager.writeLine("");
                history.add(command.getName());
            }
        }
    }
    /**
     * Метод, прекращающий работу программы.
     */
    public void stop() {stopFlag = true; }
    public Collection<Command> getAllCommands() {
        return commandList.values();
    }
    public List<String> getHistory() {
        return history;
    }
}
