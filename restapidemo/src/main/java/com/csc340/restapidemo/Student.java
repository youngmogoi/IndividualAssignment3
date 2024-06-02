package com.csc340.restapidemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name="student_major")
    private String major;
    @Column(name="student_gpa")
    private double gpa;


    public Student() {
        // TODO Auto-generated constructor stub
    }


    public Student(String name, String major, double gpa) {
        super();
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [Id=" + id + ", name=" + name + ", major=" + major + ", gpa=" + gpa
                + "]";
    }




}

