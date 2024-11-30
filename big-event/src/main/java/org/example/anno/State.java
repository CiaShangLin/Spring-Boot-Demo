package org.example.anno;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.validation.StateValidation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StateValidation.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  State {

    String message() default "State的值只能是草稿或是已發布";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
