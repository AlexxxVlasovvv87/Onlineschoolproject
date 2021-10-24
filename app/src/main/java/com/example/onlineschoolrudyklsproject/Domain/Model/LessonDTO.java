package com.example.onlineschoolrudyklsproject.Domain.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


public class LessonDTO extends Lesson{
    @ColumnInfo
    private String creatorDTO;
    @ColumnInfo
    private String startTimeDTO;
    @ColumnInfo
    private String stopTimeDTO;
    @ColumnInfo
    private String peopleListDTO;
    @ColumnInfo
    private String imagesDTO;
}
