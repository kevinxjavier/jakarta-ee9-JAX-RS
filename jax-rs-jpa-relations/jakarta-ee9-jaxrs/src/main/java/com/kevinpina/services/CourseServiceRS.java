package com.kevinpina.services;

import com.kevinpina.models.Course;
import jakarta.ejb.Local;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@Local  // When the @Stateless class implements this interface by Default is an EJB Local, so no necessary to specify it.
public interface CourseServiceRS {

    String inform(String message);
    List<Course> list();
    Course create(Course course);
    Optional<Course> findById(Long id);
    void deleteById(Long id);

}
