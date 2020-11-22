package example.test.service;

import example.test.model.Statistic;

import java.util.List;
import java.util.Optional;

public interface StatisticService {
    void save(Statistic statistic);

    List<Statistic> findByIdThema(Long idThema);

    List<Statistic> findByIdCourse(Long idCourse);

}
