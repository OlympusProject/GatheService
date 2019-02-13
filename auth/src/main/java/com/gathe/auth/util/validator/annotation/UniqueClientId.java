package com.gathe.auth.util.validator.annotation;

import com.gathe.auth.util.validator.UniqueClientIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueClientIdValidator.class)
public @interface UniqueClientId {

    String message() default  "This Client Id already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[]  payload() default {};
}
