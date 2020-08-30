package ru.commander.actions;

import ru.commander.Commander;
import ru.commander.input.Input;

public interface Actions {
    void execute(Input input, Commander cmd);
    String info();
}
