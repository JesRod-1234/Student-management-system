package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.errors.ExceptionStudent;
import se.iths.errors.Exceptions;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static se.iths.errors.ExceptionStudent.emailExists;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    static StudentService studentService;
    SubjectService subjectService;

    @Inject
    public StudentRest(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @Path("new")
    @POST
    public Response createStudent(Student student) {

        if (emailExists(studentService.getAllStudents(), student.getEmail())) {
            Exceptions.sendJsonEMailException(student.getEmail());
            return null;
        } else {
            studentService.createStudent(student);
            return Response.ok(student).build();
        }

    }


    @Path("update")
    @PUT
    public Response updateStudent(Student student) {


        if (emailExists(studentService.getAllStudents(), student.getEmail())) {
           Exceptions.sendJsonEMailException(student.getEmail());
            return null;
        } else {
            studentService.updateStudent(student);
            return Response.ok(student).build();
        }
    }


    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);

        ExceptionStudent.noFoundStudent(id, foundStudent);
        return Response.ok(foundStudent).build();

    }

    @Path("getall")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {

        Student foundStudent = studentService.findStudentById(id);

        ExceptionStudent.deleteStudent(id, foundStudent);
        studentService.deleteStudent(id);

        return Response.noContent().build();
    }

    @Path("findbylastname")
    @GET
    public List<Student> findByLastname(@QueryParam("findbylastname") String lastName) {

        List<Student> foundStudent = studentService.checkStudentEmail(lastName);

        if (foundStudent.size() == 0) {
            ExceptionStudent.findByLastname(lastName);

        }
        return foundStudent;

    }

    @Path("addStudentToSubject/{studentId}/{subjectId}")
    @PUT
    public Response addStudentToSubject(@PathParam("studentId") Long studentId, @PathParam("subjectId") Long subjectId) {

        Student foundStudent = studentService.findStudentById(studentId);
        Subject foundSubject = subjectService.findSubjectById(subjectId);
        foundStudent.addSubject(foundSubject);
        studentService.updateStudent(foundStudent);
        return Response.ok(foundStudent).build();
    }

        @Path("getallwithnamedquery")
        @GET
        public List<Student> getAllWithNamedQuery () {
            return studentService.getAllWithNamedQuery();
        }

        @Path("getallstudentssortedbycategory")
        @GET
        public List<Student> getAllItemSortedbyCategory () {
            return studentService.getAllStudentsSortedByCategory();
        }


    }


