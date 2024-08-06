package com.example.tarefas.model;

import java.io.Serializable;

public class Task implements Serializable {
    private Integer id;
    private String description;
    private boolean active;

    public Task(int id, String description){
        this.id = id;
        setDescription(description);
        setActive(true);
    }

    public Task() {

    }

    public Integer getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
