package br.edu.ifsuldeminas.mch.tarefas.model.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;

public class TaskDAO {

    public boolean save(Task task){
        return true;
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();

        return tasks;
    }

    public void delete(Task task) {

    }

    public void update(Task task) {

    }
}
