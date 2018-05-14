package com.goldensnake.task;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskListHolder> {
    private List<TaskModel> tasks;

    public TaskListAdapter(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public void updateData(List<TaskModel> tasks){
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListHolder holder, int position) {
        TaskModel task = tasks.get(position);
        holder.showTask(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskListHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewContent;

        TaskListHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textView_title);
            textViewContent = itemView.findViewById(R.id.textView_text);

        }

        public void showTask (TaskModel task){
            textViewTitle.setText(task.getTitle());
            textViewContent.setText(task.getContent());
        }
    }
}
