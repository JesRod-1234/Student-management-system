package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.errors.ExceptionTeacher;
import se.iths.errors.Exceptions;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    TeacherService teacherService;
    SubjectService subjectService;

    @Inject
    public TeacherRest(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Path("new")
    @POST
    public Response createTeacher(Teacher teacher) {

        if (ExceptionTeacher.emailExistsTeacher(teacherService.getAllTeachers(), teacher.getEmail())) {
            Exceptions.sendJsonEMailException(teacher.getEmail());
            return null;
        } else {
            teacherService.createTeacher(teacher);
            return Response.ok(teacher).build();
        }

    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher) {

        if (ExceptionTeacher.emailExistsTeacher(teacherService.getAllTeachers(), teacher.getEmail())) {
            Exceptions.sendJsonEMailException(teacher.getEmail());
            return null;
        } else {
            teacherService.createTeacher(teacher);
            return Response.ok(teacher).build();
        }

    }

    @Path("{id}")
    @GET
    public Response findTeacherById(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);

        ExceptionTeacher.noFoundTeacher(id, foundTeacher);
        return Response.ok(foundTeacher).build();

    }

    @Path("getAll")
    @GET
    public Response getAllTeachers() {
        List<Teacher> foundTeacher = teacherService.getAllTeachers();
        return Response.ok(foundTeacher).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {

        Teacher foundTeacher = teacherService.findTeacherById(id);

        ExceptionTeacher.deleteTeacher(id, foundTeacher);
        teacherService.deleteTeacher(id);

        return Response.noContent().build();
    }

    @Path("{idSubject}")
    @PUT
    public Response addTeacherToSubject(@PathParam("idSubject") Long idSubject, Teacher teacher){

        Teacher findTeacher = teacherService.createTeacher(teacher);
        Subject findSubject = subjectService.findSubjectById(idSubject);

        findTeacher.addSubject(findSubject);
        return Response.ok().entity(findTeacher.toString() + findSubject.toString()).build();

    }


}
