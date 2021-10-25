package com.example.onlineschoolrudyklsproject.Presentation.Repository.Room;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;
import com.example.onlineschoolrudyklsproject.Presentation.Repository.Room.DAO.LessonDAO;

import java.util.List;

public class LessonRepository {
    private final LessonDAO okLessonDAO;
    private final LiveData<List<LessonDTO>> mAllParties;

    public LessonRepository(Application application) {
        LessonRoomDatabase db = LessonRoomDatabase.getDatabase(application);
        okLessonDAO = db.lessonDAO();
        mAllParties = okLessonDAO.getAllLessons();
    }

    public LiveData<List<LessonDTO>> getAllLessons() {
        return mAllParties;
    }

    public void addLesson(LessonDTO lesson) {

        LessonRoomDatabase.databaseWriteExecutor.execute(() -> {
            okLessonDAO.addLesson(lesson);
        });
    }

    public void deleteLesson(LessonDTO lesson) {
        LessonRoomDatabase.databaseWriteExecutor.execute(() -> {
            okLessonDAO.deleteLesson(lesson);
        });
    }
}
