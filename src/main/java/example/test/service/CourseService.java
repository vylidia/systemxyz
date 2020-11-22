package example.test.service;

import example.test.model.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);

    Course findByCourse(String course);

    List<Course> findByIdUser(Long idUser);

    List<Course> findAll();
}
