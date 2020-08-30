package ru.commander.input;

import ru.commander.actions.Actions;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scaner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return this.scaner.nextLine();
    }

    @Override
    public String ask(String question, Map<String, Actions> commands) {
        String key = this.ask(question).toUpperCase();
        if (commands.get(key) != null) {
            return key;
        } else {
            System.out.println("Command not found");
            return ask(question, commands);
        }
    }
}
