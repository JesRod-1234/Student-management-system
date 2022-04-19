package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {


    @PersistenceContext // Kontextet vi arbetar inom med vår databas. Objekten som finns i våran applikation.
    EntityManager entitymanager;

    public Subject createSubject(Subject subject){
        entitymanager.persist(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject){
        entitymanager.merge(subject); //Letar upp de befintliga objekt och uppdatera med nya värdena, alternativt skapar ett helt nytt item.
        return subject;
    }

    public Subject findSubjectById(Long id){
        return entitymanager.find(Subject.class, id);
    }

    // JPQL Query
    public List<Subject> getAllSubjects(){
        return entitymanager.createQuery("SELECT i from Subject i", Subject.class).getResultList();
    }

    public void deleteSubject(Long id){
        Subject foundSubject = entitymanager.find(Subject.class, id);
        entitymanager.remove(foundSubject);
    }
}
