package com.example.android.loginapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("college")
    private String college;

    @SerializedName("department")
    private String department;

    @SerializedName("expected_graduation_year")
    private int expectedGraduationYear;

    @SerializedName("last_grade")
    private String lastGrade;

    public User(String name, int age, String college, String department, int expectedGraduationYear, String lastGrade) {
        this.setName(name);
        this.setAge(age);
        this.setCollege(college);
        this.setDepartment(department);
        this.setExpectedGraduationYear(expectedGraduationYear);
        this.setLastGrade(lastGrade);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExpectedGraduationYear() {
        return expectedGraduationYear;
    }

    public void setExpectedGraduationYear(int expectedGraduationYear) {
        this.expectedGraduationYear = expectedGraduationYear;
    }

    public String getLastGrade() {
        return lastGrade;
    }

    public void setLastGrade(String lastGrade) {
        this.lastGrade = lastGrade;
    }
}
