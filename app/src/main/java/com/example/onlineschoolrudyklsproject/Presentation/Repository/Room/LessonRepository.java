package com.example.onlineschoolrudyklsproject.Presentation.Repository.Room;

import android.app.Application;
import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onlineschoolrudyklsproject.Domain.Model.Lesson;
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

    public void addLesson(Lesson Lesson) {
        LessonDTO dto = LessonDTO.convertFromLesson(Lesson);

        LessonRoomDatabase.databaseWriteExecutor.execute(() -> {
            okLessonDAO.addLesson(dto);
        });
    }

    public void deleteLesson(Lesson Lesson) {
        LessonDTO dto = LessonDTO.convertFromLesson(Lesson);

        LessonRoomDatabase.databaseWriteExecutor.execute(() -> {
            okLessonDAO.deleteLesson(dto);
        });
    }
}
