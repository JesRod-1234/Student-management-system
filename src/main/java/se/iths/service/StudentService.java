package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext // Kontextet vi arbetar inom med vår databas. Objekten som finns i våran applikation.
    EntityManager entitymanager;


    public void createStudent(Student student){
        entitymanager.persist(student);
    }

    public void updateStudent(Student student){
        entitymanager.merge(student); //Letar upp de befintliga objekt och uppdatera med nya värdena, alternativt skapar ett helt nytt item.
    }

    public Student findStudentById(Long id){
        return entitymanager.find(Student.class, id);
    }

    // JPQL Query
    public List<Student> getAllStudents(){
        return entitymanager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public void deleteStudent(Long id){
        Student foundStudent = entitymanager.find(Student.class, id);
        entitymanager.remove(foundStudent);
    }

    public List<Student> findByLastname(String lastName){
        String query = "SELECT i FROM Student i WHERE i.lastName = :lastName";
        return entitymanager.createQuery(query, Student.class)
                .setParameter("lastName", lastName).getResultList();
    }

    public List<Student> checkStudentEmail(String studentEmail){

        String query = "SELECT i FROM Student i WHERE i.email = :email";

        List<Student> email = entitymanager.createQuery(query, Student.class)
                .setParameter("email", studentEmail).getResultList();

        if(email.size() == 0){
            return email;
        }else {
            return null;
        }


    }

    // Named query
    public List<Student> getAllWithNamedQuery(){
        return entitymanager
                .createNamedQuery("studentEntity.findAll", Student.class).getResultList();
    }


    public List<Student> getAllStudentsSortedByCategory(){
        String query = "SELECT i FROM Student i ORDER BY i.lastName";
        return entitymanager.createQuery(query, Student.class)
                .setParameter(query, Student.class).getResultList();
    }



}
