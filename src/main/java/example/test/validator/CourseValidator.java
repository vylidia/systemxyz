package example.test.validator;

import example.test.model.Course;
import example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {
    @Autowired
    private CourseService courseService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Course.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Course course = (Course) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "course", "NotEmpty");
        if (courseService.findByCourse(course.getCourse())!= null) {
            errors.rejectValue("course", "Duplicate.courseForm.course");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseName", "NotEmpty");
    }
}
