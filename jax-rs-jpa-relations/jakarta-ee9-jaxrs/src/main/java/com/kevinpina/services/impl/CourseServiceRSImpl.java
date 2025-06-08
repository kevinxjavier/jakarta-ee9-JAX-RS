package com.kevinpina.services.impl;

import com.kevinpina.models.Course;
import com.kevinpina.repositories.CourseRepository;
import com.kevinpina.services.CourseServiceRS;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@Stateless
public class CourseServiceRSImpl implements CourseServiceRS {

    private int count;  // Will increase the count because behave Stateless so (this) below will show the same every call, e.g.: com.kevinpina.services.impl.CourseServiceWSImpl@b413483

    @Inject // To use @Inject the class have to be of type CDI so we marked it with @Stateless
    private CourseRepository courseRepository;

    @WebMethod
    @Override
    public String inform(String message) {
        System.out.println("Person [" + count++ + "]. Printing inside WS implementation with instance: " + this);
        return "Service to create courses.";
    }

    @WebMethod
    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @WebMethod
    @Override
    public Course create(Course course) {
        System.out.println("Course " + course.getName() + " saved successful!");
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(courseRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

}
