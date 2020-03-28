package com.vf.business.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = StudentValidator.class)
public @interface ValidStudent {

    String message() default "{com.vf.business.dto.user.validator.ValidStudent." + "message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    ValidationMode value() default ValidationMode.REQUIRED_FIELDS;

    @Target({ TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidStudent[] value();
    }
}
