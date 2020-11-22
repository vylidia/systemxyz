package example.test.service;

import example.test.model.Statistic;
import example.test.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public void save(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    @Override
    public List<Statistic> findByIdThema(Long idThema) {
        return statisticRepository.findByIdThema(idThema);
    }

    @Override
    public List<Statistic> findByIdCourse(Long idCourse) {
        return statisticRepository.findByIdCourse(idCourse);
    }
}
