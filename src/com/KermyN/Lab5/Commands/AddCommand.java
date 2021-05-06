package com.KermyN.Lab5.Commands;

import com.KermyN.Lab5.Model;
import com.KermyN.Lab5.collections.*;
import java.io.IOException;
import java.time.ZonedDateTime;

public class AddCommand extends Command{
    public AddCommand(Model engine) {
        super(engine);
    }

    @Override
    public void execute() throws IOException, NumberFormatException {
        int id = (int)(System.currentTimeMillis() % Integer.MAX_VALUE);

        String name = ioManager.StringReader("Введите имя:");

        Integer age = ioManager.IntegerReader("Введите возраст");
        Integer x = ioManager.IntegerReader("Введите координату x(>0):");
        long y = ioManager.LongReader("Введите координату y(>0)");

        ZonedDateTime creationDate = ZonedDateTime.now();

        Color сolor = ioManager.ColorReader("Введите цвет дракона: {GREEN, " + "RED, " + "BLACK, " + "YELLOW, " + "BROWN;}");
        DragonCharacter character = ioManager.CharacterReader("Введите характер дракона: {CUNNING," + "GOOD," + "FICKLE;}");
        DragonType type = ioManager.TypeReader("Введите тип дракона: {UNDERGROUND," + "AIR," + "WATER," +"FIRE;}");

        double treasures = ioManager.DoubleReader("Введите количество сокровищ(>0):");
        DragonCave cave = new DragonCave(treasures);

        Coordinates coordinates = new Coordinates(x,y);
        Dragon p = new Dragon(id,name, coordinates,creationDate,age,сolor,type,character,cave);
        collection.add(p);
        ioManager.writeLine("Object was added: " + p.toString());
    }

    @Override
    public String getDescription() {
        return ":добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "add";
    }
}