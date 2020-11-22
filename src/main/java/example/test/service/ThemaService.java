package example.test.service;

import example.test.model.Thema;

import java.util.List;

public interface ThemaService {
    void save(Thema thema);

    Thema findByThema(String thema);

    List<Thema> findByIdCourse(Long idCourse);

    List<Thema> findAll();
}
