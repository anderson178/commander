package ru.commander;

import ru.commander.model.User;

import java.util.ArrayList;
import java.util.List;

public class Commander {
    private List<User> users;

    public Commander() {
        this.users = new ArrayList<User>();
    }

    public void add (User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
