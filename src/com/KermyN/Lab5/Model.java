package com.KermyN.Lab5;

import com.KermyN.Lab5.collections.CollectionWork;
import com.KermyN.Lab5.collections.Dragons;
import com.KermyN.Lab5.Commands.*;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Model {
    private Dragons parsing = new Dragons();
    protected static Map<String, Command> commandList = new HashMap<>();
    private boolean stopFlag = false;
    private final IOManager ioManager = new IOManager();
    private final List<String> history = new LinkedList<>();
    private CollectionWork collectionWork = new CollectionWork();

    Model(String path) throws IOException {
        parsing = uploadFile(path);
        collectionWork = parsing.getCollectionWorker();

        registerCommand(new HelpCommand(this));
        registerCommand(new InfoCommand(this));
        registerCommand(new SaveCommand(this));
        registerCommand(new InsertCommand(this));
        registerCommand(new HistoryCommand(this));
        registerCommand(new ExecuteScriptCommand(this));
        registerCommand(new ClearCommand(this));
        registerCommand(new ExitCommand(this));
        registerCommand(new RemoveByKeyCommand(this));
        registerCommand(new UpdateCommand(this));
        registerCommand(new RemoveIfGreaterCommand(this));
        registerCommand(new MinByCaveCommand(this));
    }

    /**
     * Метод, запускающий цикл исполнения комманд, которые будут введены пользователем.
     */
    public void run() throws IOException, JAXBException{
        while (!stopFlag) {
            readAndExecuteCommand();
        }
    }

    public Dragons uploadFile(String path)throws IOException, FileNotFoundException{
        try {
            if (path == null) throw new FileNotFoundException();
            return parsing.uploadData(path);
        } catch (FileNotFoundException ex) {
            System.out.println("Неверный путь");
            System.exit(1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
return null;
    }

    public IOManager getIOManager() {
        return ioManager;
    }
    public CollectionWork getCollectionWork() {
        return collectionWork;
    }
    public Dragons getParser(){return parsing;}

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
     * Метод, регистрирующий комманду.
     * @param command Ссылка на экземпляр комманды.
     */
    private void registerCommand(Command command) {
        commandList.put(command.getName(), command);
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
                ioManager.writeLine("Команда с указанным именем не найдена");
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
