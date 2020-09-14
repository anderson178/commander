package ru.commander;

import ru.commander.input.ConsoleInput;
import ru.commander.input.Input;

public class StartUI {
    private Commander cmd;
    private Input input;
    private boolean work = true;

    public StartUI(Commander cmd, Input input) {
        this.cmd = cmd;
        this.input = input;
    }

    public void stop() {
        this.work = false;
    }

    public void init() {
//        init();
        MenuCommander menu = new MenuCommander(this.input, this.cmd);
        menu.dataLoad();
        menu.fillCommands(this);
        do {
            String key = (input.ask("select command: ", menu.getCommands()));
            menu.select(key);
        } while (this.work);
    }

    public static void main(String[] args) {
        new StartUI( new Commander(), new ConsoleInput()).init();
    }
}
