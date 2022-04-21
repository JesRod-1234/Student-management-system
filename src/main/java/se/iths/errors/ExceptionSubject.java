package se.iths.errors;

import org.json.simple.JSONObject;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ExceptionSubject {

    public static void noFoundSubject(Long id, Subject foundSubject) {
        if (foundSubject == null) {
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Subject with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    public static void deleteSubject(Long id, Subject subject) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
    }

    public static void noFoundSubjectJson(Long id, Subject subject) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
    }

    public static boolean subjectExistsAlready(List<Subject> foundSubject, String subjectName) {

        boolean isPresent = false;

        for (Subject subject : foundSubject) {
            if (subject.getSubjectName().contains(subjectName)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;

    }
}
