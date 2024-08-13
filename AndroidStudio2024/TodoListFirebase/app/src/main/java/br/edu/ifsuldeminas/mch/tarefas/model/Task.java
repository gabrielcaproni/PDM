package br.edu.ifsuldeminas.mch.tarefas.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Task implements Serializable {
    private Integer id;
    private String description;
    private boolean active;
    private Date dateChanged;

    public Task(){
        setActive(true);
    }
    public Task(int id, String description){
        this.id = id;
        setDescription(description);
        setActive(true);
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

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged() {
        // Data e hora atual
        dateChanged = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
