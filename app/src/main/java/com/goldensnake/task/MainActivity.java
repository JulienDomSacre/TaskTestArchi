package com.goldensnake.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TaskListAdapter taskListAdapter;
    private TaskDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTask);

        dao = AppDatabase.getAppDatabase(getApplicationContext()).taskDao();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        taskListAdapter = new TaskListAdapter(dao.getAll());
        recyclerView.setAdapter(taskListAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TaskDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        taskListAdapter.updateData(dao.getAll());
        taskListAdapter.notifyDataSetChanged();
    }
}
