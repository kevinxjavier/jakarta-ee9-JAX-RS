package com.kevinpina.repositories;

import com.kevinpina.models.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();
    Course save(Course course);
    Course findById(Long id);
    void deleteById(Long id);

}
