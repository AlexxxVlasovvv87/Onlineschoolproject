package com.example.onlineschoolrudyklsproject.Presentation.Repository.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;
import com.example.onlineschoolrudyklsproject.Presentation.Repository.Room.DAO.LessonDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LessonDTO.class}, version = 1, exportSchema = false)
public abstract class LessonRoomDatabase extends RoomDatabase {

    public abstract LessonDAO lessonDAO();

    private static volatile LessonRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static LessonRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LessonRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LessonRoomDatabase.class, "lesson_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
