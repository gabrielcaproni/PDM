package com.example.todolistclass.model;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String description;
    private boolean active;

    public Task(){
        this.active = true;
    }
    public Task(int id, String desc, boolean act){
        this.id = id;
        this.description = desc;
        this.active = act;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
