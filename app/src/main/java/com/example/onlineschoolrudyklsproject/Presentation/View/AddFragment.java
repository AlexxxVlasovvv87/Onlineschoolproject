package com.example.onlineschoolrudyklsproject.Presentation.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;
import com.example.onlineschoolrudyklsproject.Presentation.Viewmodel.LessonViewModel;
import com.example.onlineschoolrudyklsproject.R;

public class AddFragment extends AppCompatActivity {
    
    EditText lessonName, lessonGrade, lessonDescription;
    Button lessonSave;
    private LessonViewModel lessonViewModel;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_lesson_activity);

        lessonName = findViewById(R.id.lesson_name1);
        lessonGrade = findViewById(R.id.lesson_grade1);
        lessonDescription = findViewById(R.id.lesson_description1);
        lessonSave = findViewById(R.id.button_save);


        lessonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lessonName.getText().toString().isEmpty()) {
                    String Name = lessonName.getText().toString();
                    String Description = lessonDescription.getText().toString();
                    String Grade = lessonGrade.getText().toString();

                    lessonViewModel = new LessonViewModel(getApplication());
                    LessonDTO lesson = new LessonDTO(Name, Grade, Description);
                    lessonViewModel.addLesson(lesson);
                    finish();
                } else {
                    Toast.makeText(AddFragment.this, "Попробуйте ещё раз", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}