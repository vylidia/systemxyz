package example.test.validator;

import example.test.model.Task;
import example.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TaskValidator implements Validator {
    @Autowired
    private TaskService taskService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Task.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Task task = (Task) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskName", "NotEmpty");
        if (taskService.findByTaskNameAndIdThema(task.getTaskName(), task.getIdThema())!= null) {
            errors.rejectValue("taskName", "Duplicate.taskForm.task");
        }
    }
}
