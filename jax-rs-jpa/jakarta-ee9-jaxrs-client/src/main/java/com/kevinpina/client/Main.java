package com.kevinpina.client;

import com.kevinpina.client.model.Course;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget rootUri = client.target("http://localhost:8080/jakarta-ee9-jaxrs/api").path("/courses");

        System.out.println("-------------------- GET /{id} ");

        //Course course = rootUri.path("/1").request(MediaType.APPLICATION_XML).get(Course.class);
        Course course1 = rootUri.path("/1").request(MediaType.APPLICATION_JSON)
                //.accept(MediaType.APPLICATION_JSON)
                //.header("ACCESS", "KEVIN")
                .get(Course.class);

        System.out.println(course1);

        Response response = rootUri.path("/1").request(MediaType.APPLICATION_JSON).get();
        Course course2 = response.readEntity(Course.class);

        System.out.println(course2);

        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("-------------------- GET /");

        List<Course> courses1 = rootUri.request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Course>>(){});

        courses1.forEach(System.out::println);

        response = rootUri.request(MediaType.APPLICATION_JSON)
                .get();
        List<Course> courses2 = response.readEntity(new GenericType<List<Course>>(){});

        courses2.forEach(System.out::println);

        System.out.println("-------------------- POST /");

        Course newCourse = Course.builder().name("Cobol").description("Learning Cobol").duration(1D).instructor("kevin pina").build();

        Entity<Course> courseEntity = Entity.entity(newCourse, MediaType.APPLICATION_JSON);

        Course postCourseResponse1 = rootUri.request(MediaType.APPLICATION_JSON).post(courseEntity, Course.class);

        System.out.println(postCourseResponse1);

        System.out.println("-------------------- PUT /");

        Course editCourse = newCourse;
        editCourse.setName("SpringBoot2");
        editCourse.setDescription("Microservices Essentials");

        courseEntity = Entity.entity(editCourse, MediaType.APPLICATION_JSON);

        editCourse = rootUri.path("/" + postCourseResponse1.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(courseEntity, Course.class);

        System.out.println(editCourse);

        System.out.println("-------------------- DELETE /{id}");

        rootUri.path("/" + postCourseResponse1.getId())
                .request()
                .delete();

    }

}
