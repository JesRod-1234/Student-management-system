package se.iths.util;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entitymanager;

//    @PostConstruct
//    public void generateData(){
//        Teacher teacher1 = new Teacher ( 1, "Jessica", " jessica@hotmail.com" );
//        Teacher teacher2 = new Teacher (2, "Sara", " Sara@hotmail.com" );
//        Teacher teacher3 = new Teacher ( 3, "Felicia", " Felicia@hotmail.com" );
//
//        Subject subject1 = new Subject( );
//        Subject subject2 = new Subject(2, "Science");
//        Subject subject3 = new Subject(3, "Science");
//    }
}
