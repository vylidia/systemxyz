package example.test.service;

import example.test.model.Task;
import example.test.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task findByTaskNameAndIdThema(Integer taskName, Long idThema) {
        return taskRepository.findByTaskNameAndIdThema(taskName, idThema);
    }

    @Override
    public List<Task> findByIdThema(Long idThema) {
        return taskRepository.findByIdThema(idThema);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
}
