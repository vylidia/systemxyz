package example.test.service;

import example.test.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void save(Task task);

    Task findByTaskNameAndIdThema(Integer taskName, Long thema);

    Optional<Task> findById(Long id);

    List<Task> findByIdThema(Long idthema);

}
