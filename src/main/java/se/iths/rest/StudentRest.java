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
    @POST // POST för att skapa något alldeles nytt. Alltså inte uppdatera något som redan finns
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id){
        Student foundStudent = studentService.findStudentById(id);

        if(foundStudent == null){
            throw new WebApplicationException(Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Item with ID " + id + " was not found in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
        return Response.ok(foundStudent).build();
    }

    @Path("getall")
    @GET
    public Response getAllStudents(){
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

    @Path("sortedbylastname")
    @GET
    public List<Student> sortedByLastname(@QueryParam("sortedbylastname") String lastName){
        return studentService.sortedByLastname(lastName);
    }

    @Path("getallwithnamedquery")
    @GET

    public List<Student> getAllWithNamedQuery(){
        return studentService.getAllWithNamedQuery();
    }

    @Path("getallstudentssortedbycategory")
    @GET
    public List<Student> getAllItemSortedbyCategory(){
        return  studentService.getAllStudentsSortedByCategory();
    }


}