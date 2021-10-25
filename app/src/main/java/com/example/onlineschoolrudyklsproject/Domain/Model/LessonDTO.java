package com.example.onlineschoolrudyklsproject.Domain.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Lesson_table")
public class LessonDTO{

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "LessonName")
    private String name;
    @ColumnInfo(name = "LessonGrade")
    private String grade;
    @ColumnInfo(name = "LessonDescription")
    private String description;

    public LessonDTO() {
    }


    public LessonDTO(@NonNull String lessonName, String lessonDescription, String lessonGrade) {
        name = lessonName;
        grade = lessonGrade;
        description = lessonDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
