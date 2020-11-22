package example.test.repository;

import example.test.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourse(String course);

    List<Course> findAll();

    List<Course> findByIdUser(Long idUser);
}
