package com.vf.business.business.validator;

import com.vf.business.business.dto.user.StudentDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentValidator implements ConstraintValidator<ValidStudent, StudentDTO> {

    private ValidationMode mode;

    @Override
    public void initialize(ValidStudent constraintAnnotation) {
        mode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(StudentDTO student, ConstraintValidatorContext constraintContext) {
        boolean isValid = true;
        if ( student == null ) {
            isValid = false;
        }

        switch(mode) {
            case CREATE:
            case REQUIRED_FIELDS:
                isValid = hasRequiredFields(student);
                break;
            default:
                isValid = false;
        }

        if ( !isValid ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(
                    "{validator.student.message}"
            )
                    .addConstraintViolation();
        }

        return isValid;
    }

    private boolean hasRequiredFields(StudentDTO s) {
        return s.getFirstName() != null && s.getLastName() != null &&
                s.getEmail() != null;
    }
}
