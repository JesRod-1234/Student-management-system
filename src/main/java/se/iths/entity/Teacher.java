package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty // Kan inte skicka in ett tomt namn i databasen. Dock räcker det att en av de två annotationerna körs.
    @Size(min = 2)
    private String teacherName;
    @NotEmpty
    private String email;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Subject> subjects;;

    public void addSubject(Subject subject){ // När man anropar denna metoden, då läggs den till på denna listan.
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public Teacher(long id, String teacherName, String email) {
        this.id = id;
        this.teacherName = teacherName;
        this.email = email;
    }

    public Teacher() {
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
