package com.example.ss10.model;

public class Student {
    private int codeStudent;
    private String nameStudent;
    private int gender;
    private double point;

    public Student() {
    }

    public Student(int codeStudent, String nameStudent, int gender, double point) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.gender = gender;
        this.point = point;
    }

    public int getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(int codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
