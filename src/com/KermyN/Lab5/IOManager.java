package com.KermyN.Lab5;

import com.KermyN.Lab5.collections.Color;
import com.KermyN.Lab5.collections.DragonCave;
import com.KermyN.Lab5.collections.DragonCharacter;
import com.KermyN.Lab5.collections.DragonType;

import java.io.*;
import static com.KermyN.Lab5.IsDigit.*;


public class IOManager {
    private final FileWriter FileWriter;
    private final InputStreamReader inputStreamReader;

    public IOManager() throws IOException{
       // try {
            inputStreamReader = new InputStreamReader(System.in);
            FileWriter = new FileWriter("NewData.xml");
        //}
       // catch(IOException e){
           // e.printStackTrace();
         //   System.exit(0);
       // }
    }

    public void write(String s) {
        System.out.println(s);
    }

    public void writeFile(String s){
        try {
            FileWriter.write(s);
            FileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String s) {
        write(s + "\n");
    }

    public int idReader(String question)throws NumberFormatException, IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !IsDigit.isInteger(value)  || !(Integer.parseInt(value) > 0)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Integer.valueOf(value);
    }
    public String readNext() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                if (!inputStreamReader.ready()) break;
                char c = (char)inputStreamReader.read();
                if (c == '\n'){break;}
                if (stringBuilder.length() != 0 && Character.isWhitespace(c)) break;
                stringBuilder.append(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String read() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // создать экземпляр InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // экземпляр класса буферизации
        return bufferedReader.readLine();
    }

    public String StringReader(String question) throws IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty()) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return value;
    }

    /**
     * Метод для чтениния вводимых чисел типа Integer
     */
    public Integer IntegerReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !IsDigit.isInteger(value)  || !(Integer.parseInt(value) > 0)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Integer.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Float
     * @param maxValue максимальное значение, которое может ввести пользователь
     */
    public Float FloatReader(String question, Float maxValue) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value) || (Float.parseFloat(value) > maxValue)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Float.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Float
     */
    public Float FloatReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Float.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Double
     */
    public Double DoubleReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isDouble(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Double.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Long
     */
    public Long LongReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value) || !(Long.parseLong(value) > 0)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Long.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых данных типа Color
     */
    public Color ColorReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("ORANGE") && !value.equals("RED") && !value.equals("YELLOW"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Color.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых данных типа DragonCharacter
     */
    public DragonCharacter CharacterReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("FICKLE") && !value.equals("GOOD") && !value.equals("CUNNING"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return DragonCharacter.valueOf(value);
    }
    /**
     * Метод для чтениния вводимых данных типа Color
     */
    public DragonType TypeReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("WATER") && !value.equals("UNDERGROUND") && !value.equals("FIRE")&& !value.equals("AIR"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return DragonType.valueOf(value);
    }

}

