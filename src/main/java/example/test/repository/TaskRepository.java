package example.test.repository;

import example.test.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskNameAndIdThema(Integer taskName, Long idThema);

    Optional<Task> findById(Long id);

    List<Task> findByIdThema(Long idThema);

}
