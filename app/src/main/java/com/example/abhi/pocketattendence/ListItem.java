package com.example.abhi.pocketattendence;

public class ListItem {
    private String studentName;
    private long rollNumber;

    public ListItem(long rollNumber,String studentName)
    {
        this.rollNumber=rollNumber;
        this.studentName=studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public long getRollNumber()
    {
        return rollNumber;
    }
}
