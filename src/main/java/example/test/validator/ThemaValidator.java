package example.test.validator;

import example.test.model.Thema;
import example.test.service.ThemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ThemaValidator implements Validator {
    @Autowired
    private ThemaService themaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Thema.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Thema thema = (Thema) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "thema", "NotEmpty");
        if (themaService.findByThema(thema.getThema())!= null) {
            errors.rejectValue("thema", "Duplicate.themaForm.thema");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "themaName", "NotEmpty");
    }
}
