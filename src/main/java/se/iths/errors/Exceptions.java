package se.iths.errors;

import org.json.simple.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Exceptions {

    public static void sendJsonEMailException(String email) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "Email already exists");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
    }

    public static void sendJsonEMailExceptionDelete(String email) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
    }

    public static void sendJsonIdException(Long id) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message", "There is no such id!");
        String s = jsonObject.toJSONString();

        throw new javax.ws.rs.WebApplicationException(Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .entity(s)
                .type(MediaType.APPLICATION_JSON).build());
    }
}
