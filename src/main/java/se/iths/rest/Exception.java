package se.iths.rest;

import se.iths.entity.Student;

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


}

