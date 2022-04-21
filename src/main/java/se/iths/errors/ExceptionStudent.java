package se.iths.errors;

import org.json.simple.JSONObject;
import se.iths.entity.Student;
import se.iths.entity.Teacher;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ExceptionStudent {

    public static void noFoundStudent(Long id, Student foundStudent) {

        if (foundStudent == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static void deleteStudent(Long id, Student foundStudent) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

            throw new javax.ws.rs.WebApplicationException(Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity(s)
                    .type(MediaType.APPLICATION_JSON).build());
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

    public static void deleteTeacher(Long id, Teacher foundStudent) {
        if (foundStudent == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Teacher with ID " + id + " do not exist!")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static boolean emailExists(List<Student> foundStudents, String emailValue) {

        boolean isPresent = false;
        for (Student student : foundStudents) {
            if (student.getEmail().contains(emailValue)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

}

