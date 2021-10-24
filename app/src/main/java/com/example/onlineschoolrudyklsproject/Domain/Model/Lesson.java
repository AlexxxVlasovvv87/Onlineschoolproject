package com.example.onlineschoolrudyklsproject.Domain.Model;

import java.util.UUID;


public class Lesson{

    private String id;
    private String name;
    private int grade;
    private String description;

    public Lesson() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
