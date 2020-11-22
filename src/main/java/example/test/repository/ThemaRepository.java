package example.test.repository;

import example.test.model.Thema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemaRepository extends JpaRepository<Thema, Long> {
    Thema findByThema(String thema);

    List<Thema> findByIdCourse(Long idCourse);

    List<Thema> findAll();
}
