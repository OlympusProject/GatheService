package com.gathe.auth.util.validator.annotation;

import com.gathe.auth.util.validator.PasswordConfirmationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmationValidator.class)
@Documented
public @interface ConfirmPassword {

    String password() default "password";
    String confirmPassword() default "confirmPassword";
    String message() default  "Confirm Password doesn't match with Password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[]  payload() default {};
}
