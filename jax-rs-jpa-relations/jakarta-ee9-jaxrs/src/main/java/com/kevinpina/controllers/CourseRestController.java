package com.kevinpina.controllers;

import com.kevinpina.models.Course;
import com.kevinpina.services.CourseServiceRS;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/courses")
//@Produces(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class CourseRestController {

    @Inject
    private CourseServiceRS serviceRS;

    @GET
    public List<Course> findAll() {
        return serviceRS.list();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Course> course = serviceRS.findById(id);
        if (course.isPresent()) {
            return Response.ok(course.get()).build();
            // return Response.ok(course, MediaType.APPLICATION_XML).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    //@Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Course course) {
        try {
            return Response.ok(serviceRS.create(course)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    // @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Course course) {
        Optional<Course> optionalCourse = serviceRS.findById(id);
        if (optionalCourse.isPresent()) {
            try {
                course.setId(optionalCourse.get().getId());
                return Response.ok(serviceRS.create(course)).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Optional<Course> course = serviceRS.findById(id);
        if (course.isPresent()) {
            try {
                serviceRS.deleteById(id);
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
