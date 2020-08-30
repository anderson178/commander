package ru.commander;

import ru.commander.actions.Actions;
import ru.commander.actions.BaseActions;
import ru.commander.input.Input;
import ru.commander.model.User;

import java.util.HashMap;
import java.util.Map;

public class MenuCommander {
    private Input input;
    private Commander cmd;
    private Map<String, Actions> commands = new HashMap<>();

    public MenuCommander(Input input, Commander cmd) {
        this.input = input;
        this.cmd = cmd;
    }

    public Map<String, Actions> getCommands() {
        return commands;
    }

    public void fillCommands(StartUI ui) {
        commands.put("ADD", new AddUser());
        commands.put("EXIT", new Exit(ui));
        commands.put("HELP", new Help());
        commands.put("SHOW", new Show());
    }

    public void dataLoad() {
        //download data from file input.txt
    }


    public void select(String key) {
        this.commands.get(key).execute(this.input, this.cmd);
    }

    private class Show extends BaseActions {

        public Show() {
            super.setInfo("help info");
        }

        @Override
        public void execute(Input input, Commander cmd) {
            cmd.getUsers().forEach(System.out::println);
        }
    }

    private class Help extends BaseActions {

        public Help() {
            super.setInfo("help info");
        }

        @Override
        public void execute(Input input, Commander cmd) {
            commands.keySet().forEach(key -> System.out.println(key + " - " + commands.get(key).info()));
        }
    }

    private class AddUser extends BaseActions {

        public AddUser() {
            super.setInfo("add user for temp list");
        }

        @Override
        public void execute(Input input, Commander cmd) {
            System.out.println("You selection ADD");
            String name = input.ask("Please enter the user name: ");
            int age = Integer.parseInt(input.ask("Please enter the age: "));
            cmd.add(new User(name, age));
            System.out.println("Item create");
        }
    }

    private class Exit extends BaseActions {
        private final StartUI ui;

        public Exit(StartUI ui) {
            this.ui = ui;
            super.setInfo("exit the program");
        }

        public void execute(Input input, Commander cmd) {
            System.out.println("You selection EXIT");
            System.out.println("Goode bye");
            this.ui.stop();
        }
    }
}
