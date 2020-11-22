package example.test.service;

import example.test.model.Thema;
import example.test.repository.ThemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ThemaServiceImpl implements ThemaService {
    @Autowired
    private ThemaRepository themaRepository;

    @Override
    public void save(Thema thema) {
        themaRepository.save(thema);
    }

    @Override
    public Thema findByThema(String thema) {
        return themaRepository.findByThema(thema);
    }

    @Override
    public List<Thema> findByIdCourse(Long idCourse) {
        return themaRepository.findByIdCourse(idCourse);
    }

    @Override
    public List<Thema> findAll() {
        return themaRepository.findAll();
    }
}
