package com.example.tarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tarefas.model.Task;
import com.example.tarefas.model.db.TaskDAO;
import com.example.todolistclass.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentForm = new Intent(
                        MainActivity.this,
                                    FormActivity.class);

                startActivity(intentForm);
            }
        });

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Task task = (Task) todoList.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                intent.putExtra("tarefa", task);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateTasks();
    }

    private void updateTasks() {
        TaskDAO dao = new TaskDAO(this);
        List<Task> taskList = dao.loadTasks();

        ArrayAdapter<Task> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        todoList.setAdapter(arrayAdapter);
    }
}