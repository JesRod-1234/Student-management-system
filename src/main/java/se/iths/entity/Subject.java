package se.iths.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private long id;
    private String subjectName;
    private String teacherOfSubject;


    public Subject(long id, String subjectName, String teacherOfSubject) {
        this.id = id;
        this.subjectName = subjectName;
        this.teacherOfSubject = teacherOfSubject;
    }

    public Subject() {
    }

    public String getTeacherOfSubject() {
        return teacherOfSubject;
    }

    public void setTeacherOfSubject(String teacherOfSubject) {
        this.teacherOfSubject = teacherOfSubject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
