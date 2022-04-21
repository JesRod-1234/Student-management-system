package se.iths.errors;

import org.json.simple.JSONObject;
import se.iths.entity.Student;
import se.iths.entity.Teacher;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ExceptionTeacher {

    public static void deleteTeacher(Long id, Teacher teacher) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
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

    public static void noFoundTeacher(Long id, Teacher foundTeacher) {

        if (foundTeacher == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Teacher with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());


        }
    }

    public static boolean emailExistsTeacher(List<Teacher> foundTeacher, String email) {

        boolean isPresent = false;

        for (Teacher teacher : foundTeacher) {
            if (teacher.getEmail().contains(email)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;

    }
}
