package com.api.tasks.tasks;

public class todo {

    private int id;
    private String tasks;
    private String mark;

    public todo()
    {

    }

    public todo(int id, String tasks, String mark) {
        this.id = id;
        this.tasks = tasks;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
