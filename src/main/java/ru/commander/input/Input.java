package ru.commander.input;

import ru.commander.actions.Actions;

import java.util.Map;

public interface Input {
    String ask(String question);
    String ask(String question, Map<String, Actions> commands);
}
