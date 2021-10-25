package com.example.onlineschoolrudyklsproject.Presentation.View;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineschoolrudyklsproject.Domain.Model.LessonDTO;
import com.example.onlineschoolrudyklsproject.R;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonHolder> {
    private List<LessonDTO> lessons = new ArrayList<>();

    @NonNull
    @Override
    public LessonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lesson_activity, parent, false);
        return new LessonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonHolder holder, int position) {
        LessonDTO currentLesson = lessons.get(position);
        holder.name.setText(currentLesson.getName());
        holder.grade.setText(currentLesson.getGrade());
        holder.description.setText(currentLesson.getDescription());
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setOrders(List<LessonDTO> Lessones){
        this.lessons = Lessones;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void rewrite(){
        notifyDataSetChanged();
    }

    public List<LessonDTO> getData() {
        return lessons;
    }

    static class LessonHolder extends RecyclerView.ViewHolder{
        private final TextView name, grade, description;

        public LessonHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lesson_name);
            grade = itemView.findViewById(R.id.grade);
            description = itemView.findViewById(R.id.lesson_description);

        }
    }
}
