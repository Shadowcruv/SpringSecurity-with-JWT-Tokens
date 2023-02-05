package com.eonAcademy.demy2.Entity;

public class Student {
    private String name;
    private String height;

    public Student(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
