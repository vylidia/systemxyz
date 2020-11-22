package example.test.repository;

import example.test.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    List<Statistic> findByIdCourse(Long idCourse);
    List<Statistic> findByIdThema(Long idThema);
}
