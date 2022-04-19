package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher createTeacher(Teacher teacher){

        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
        return teacher;
    }

    public Teacher findTeacherById(Long id){
        return entityManager.find(Teacher.class, id);
    }

    // JPQL Query
    public List<Teacher> getAllTeachers(){
        return entityManager.createQuery("SELECT i from Teacher i", Teacher.class).getResultList();
    }

    public void deleteTeacher(Long id){
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(foundTeacher);
    }

    public void addStudentToSubject(Long subjectId, Long studentId){
        Subject foundSubject = entityManager.find(Subject.class,subjectId);
        Student foundStudent = entityManager.find(Student.class, studentId);
        foundSubject.getStudents().add(foundStudent);
        foundStudent.getSubjects().add(foundSubject);
    }

}
