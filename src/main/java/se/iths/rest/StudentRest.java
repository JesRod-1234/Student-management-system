package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    StudentService studentService;

    @Inject
    public StudentRest(StudentService studentService) {
        this.studentService = studentService;
    }

    @Path("new")
    @POST
    public Response createStudent(Student student) {

        List<Student> foundStudents = studentService.getAllStudents();

        String emailValue = student.getEmail();

        if (Exception.findStudentByEmail(foundStudents, emailValue)) {
            Exception.sendEmailException();
        }
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

//    @Path("new")
//    @POST
//    public Response createStudent(Student student) {
//
//        List<Student> foundStudents = studentService.getAllStudents();
//
//        String emailValue = student.getEmail();
//
//        if (Exception.findStudentByEmail(foundStudents, emailValue)){
//            Exception.sendEmailException();
//        }
//
//        studentService.createStudent(student);
//        return Response.ok(student).build();
//    }


    @Path("update")
    @PUT
    public Response updateStudent(Student student) {


        List<Student> foundStudents = studentService.getAllStudents();
        String emailValue = student.getEmail();

        if (Exception.findStudentByEmail(foundStudents, emailValue)){
            Exception.sendEmailException();
        }

        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);

        Exception.noFoundStudent(id, foundStudent);
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

        Exception.noFoundStudent(id, foundStudent);
        studentService.deleteStudent(id);

        return Response.noContent().build();
    }

    @Path("findbylastname")
    @GET
    public List<Student> findByLastname(@QueryParam("findbylastname") String lastName) {

        List<Student> foundStudent = studentService.checkStudentEmail(lastName);

        if (foundStudent.size() == 0) {
            Exception.findByLastname(lastName);

        }
        return foundStudent;

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
