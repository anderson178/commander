package ru.shell;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mironenko on 12.11.2020
 */
public class Shell {

    private final static String DEFAULT_ROOT = "/";
    private String path = "";
    private Map<String, Action> commands;

    public Shell() {
        commands = new HashMap<>();
        commands.put("/", new Root());
        commands.put("put", new Put());
        commands.put("..", new Back());
    }

    public void cd(String line) {
        for (String val : line.split("/")) {
            if (commands.get(val) != null) {
                commands.get(val).apply(val);
            } else {
                commands.get("put").apply(val);
            }
        }
    }

    public String pwd() {
        return path.isEmpty() ? DEFAULT_ROOT : path;
    }

    interface Action {
        void apply(String item);
    }

    class Put implements Action {
        @Override
        public void apply(String item) {
            path = path.concat("/").concat(item);
        }
    }

    class Back implements Action {
        @Override
        public void apply(String item) {
            path = path.substring(0, path.lastIndexOf("/"));
            path = path.isEmpty() ? DEFAULT_ROOT : path;
        }
    }

    class Root implements Action {
        @Override
        public void apply(String item) {
            path = DEFAULT_ROOT;
        }
    }
}