package com.kevinpina.repositories.impl;

import com.kevinpina.models.Course;
import com.kevinpina.repositories.CourseRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CourseRepositoryImpl implements CourseRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course save(Course course) {
        if (course.getId() != null && course.getId() > 0) {
            em.merge(course);
        } else {
            em.persist(course);
        }
        return course;
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

}
