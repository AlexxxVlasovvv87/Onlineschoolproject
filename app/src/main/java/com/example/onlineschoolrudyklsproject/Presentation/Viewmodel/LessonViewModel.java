package com.example.onlineschoolrudyklsproject.Presentation.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;
import com.example.onlineschoolrudyklsproject.Presentation.Repository.Room.LessonRepository;

import java.util.List;

public class LessonViewModel extends AndroidViewModel {

    private final LiveData<List<LessonDTO>> AllLessons;

    private final LessonRepository lessonRepository;

    public LessonViewModel(@NonNull Application application) {
        super(application);
        lessonRepository = new LessonRepository(application);
        AllLessons = lessonRepository.getAllLessons();
    }

    public LiveData<List<LessonDTO>> getAllLessons() {
        return AllLessons;
    }

    public void addLesson(LessonDTO lesson) {
        lessonRepository.addLesson(lesson);
    }

    public void deleteLesson(LessonDTO lesson) {
        lessonRepository.deleteLesson(lesson);
    }
}