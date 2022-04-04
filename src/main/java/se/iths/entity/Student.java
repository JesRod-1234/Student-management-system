package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NamedQuery(name = "studentEntity.findAll", query = "SELECT i FROM Student i")
@Entity //Markerat så att detta är en tabell i våran databas sedan. Detta är alltså en tabell i en databas. Hör ihop med @Id nedan
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Id kommer automatiskt att genereras av databasen. De inom paratens är att man förklara hur det ska genereras.
    private Long id;
    @NotEmpty // Kan inte skicka in ett tomt namn i databasen. Dock räcker det att en av de två annotationerna körs.
    @Size(min = 2)
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Column(unique=true)
    private String email;
    private String phoneNumber;

    //    @NotEmpty //  @Column(unique=true)

    public Student(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
