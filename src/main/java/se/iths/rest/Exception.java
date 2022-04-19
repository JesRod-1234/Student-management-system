package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class Exception {

    public static void noFoundStudent(Long id, Student foundStudent) {
        if (foundStudent == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static void deleteStudent(Long id, Student foundStudent) {
        if (foundStudent == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " do not exist!")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }


    public static void findByLastname(String lastname) {

        throw new WebApplicationException(Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Student with this " + lastname + " do not exist!")
                        .type(MediaType.TEXT_PLAIN_TYPE).build());
            }

    public static void sendEmailException() {

        throw new WebApplicationException(Response
                .status(Response.Status.NOT_FOUND)
                .entity("Email already exist!")
                .type(MediaType.TEXT_PLAIN_TYPE).build());
    }

    public static Boolean findStudentByEmail(List<Student> foundStudents, String emailValue) {
        Boolean isPresent = false;

        for (Student student : foundStudents) {
            if (student.getEmail().contains(emailValue)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static Boolean findTeacherByEmail(List<Teacher> foundTeacher, String emailValue) {
        Boolean isPresent = false;

        for (Teacher teacher : foundTeacher) {
            if (teacher.getEmail().contains(emailValue)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static void deleteTeacher(Long id, Teacher foundStudent) {
        if (foundStudent == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Teacher with ID " + id + " do not exist!")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static void noFoundTeacher(Long id, Teacher foundTeacher) {
        if (foundTeacher == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Teacher with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static void noFoundSubject(Long id, Subject foundSubject) {
        if (foundSubject == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Subject with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }
}

