package ru.mitzury;

public class Study {

    private final String course;

    Study(String course){
        this.course = course;
    }

    public String printCourse() {
        return this.course;
    }
}
