package com.goldensnake.task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(TaskModel task);

    @Delete
    void deleteTask(TaskModel task);

    @Query("Select * from task")
    List<TaskModel> getAll();

    @Query("select * from task where id = :id")
    TaskModel getOne(int id);
}
