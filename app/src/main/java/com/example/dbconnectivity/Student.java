package com.example.dbconnectivity;

public class Student {
    private int sid;
    private String name;
    public Student(int sid,String name) {
        this.sid = sid;
        this.name = name;
    }
    public int getId() {
        return sid;
    }
    public String getName() {
        return name;
    }
    public void setId(int sid) {
        this.sid = sid;
    }
    public void setName(String name) {
        this.name = name;
    }
}