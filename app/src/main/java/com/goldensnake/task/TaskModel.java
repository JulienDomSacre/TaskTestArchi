package com.goldensnake.task;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "task")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String content;
    private long createdAt;
    private long updateAt;


    public TaskModel(String title, String content, long createdAt, long updateAt) {
        id = 0;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }


    public void setId(int id) {
        this.id = id;
    }
}
