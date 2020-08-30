package ru.commander.actions;

public abstract class BaseActions implements Actions {
    private String info;

    @Override
    public String info() {
        return String.format("%s ",this.info);
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
