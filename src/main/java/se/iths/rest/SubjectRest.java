package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.errors.ExceptionSubject;
import se.iths.errors.Exceptions;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    SubjectService subjectService;

    @Inject
    public SubjectRest(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {

        Subject subjectResult = subjectService.createSubject(subject);
        return Response.ok(subjectResult).build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {

        if (ExceptionSubject.subjectExistsAlready(subjectService.getAllSubjects(), subject.getSubjectName())) {
            Exceptions.sendJsonEMailException(subject.getSubjectName());
            return null;
        } else {
            subjectService.updateSubject(subject);
            return Response.ok(subject).build();
        }
    }

    @Path("{id}")
    @GET
    public Response findSubjectById(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);

        ExceptionSubject.noFoundSubjectJson(id, foundSubject);
        return Response.ok(foundSubject).build();

    }

    @Path("getAll")
    @GET
    public Response getAllSubjects() {
        List<Subject> foundSubject = subjectService.getAllSubjects();
        return Response.ok(foundSubject).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) {

        Subject foundSubject = subjectService.findSubjectById(id);

        ExceptionSubject.deleteSubject(id, foundSubject);
        subjectService.deleteSubject(id);

        return Response.noContent().build();
    }

    @Path("addStudentToSubject")
    @GET
    public Response addStudentToSubject(){
        subjectService.getAllSubjects();
        return Response.ok().build();
    }
}
