package com.goldensnake.task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class TaskDetailActivity extends AppCompatActivity {
    private EditText edTitle;
    private EditText edContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edTitle = findViewById(R.id.editText);
        edContent = findViewById(R.id.editText2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskModel task = new TaskModel(edTitle.getText().toString(),edContent.getText().toString(),Calendar.getInstance().getTimeInMillis(),Calendar.getInstance().getTimeInMillis());
                AppDatabase.getAppDatabase(view.getContext()).taskDao().insertTask(task);
                Snackbar.make(view, "Task save", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

}
