package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

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
        List<Subject> foundSubject = subjectService.getAllSubjects();

        Subject subjectResult = subjectService.updateSubject(subject);
//        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response findSubjectById(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);

        Exception.noFoundSubject(id, foundSubject);
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

        Exception.noFoundSubject(id, foundSubject);
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
