package com.example.onlineschoolrudyklsproject.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;

import java.util.List;

@Dao
public interface LessonDAO {
    @Insert
    void addLesson(LessonDTO lesson);

    @Delete
    void deleteLesson(LessonDTO lesson);

    @Query("SELECT * FROM Lesson_table")
    LiveData<List<LessonDTO>> getAllLessons();
}
