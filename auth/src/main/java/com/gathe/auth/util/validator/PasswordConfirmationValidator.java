package com.gathe.auth.util.validator;

import com.gathe.auth.domain.oauth.client.Account;
import com.gathe.auth.util.validator.annotation.ConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmationValidator implements ConstraintValidator<ConfirmPassword, Account> {

    protected String passwordField;
    protected String confirmPasswordField;
    protected String message;

    @Override
    public boolean isValid(Account account, ConstraintValidatorContext context) {

        String password = account.getPassword();
        String confirmPassword = account.getConfirmPassword();

        boolean valid = (confirmPassword == null && password == null)
                || confirmPassword != null && confirmPassword.equals(password);

        if (!valid) {
            addViolationToContext(context, message, confirmPasswordField);
            return false;
        }

        return true;
    }

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {
        message = constraintAnnotation.message();
        passwordField = constraintAnnotation.password();
        confirmPasswordField = constraintAnnotation.confirmPassword();
    }

    protected void addViolationToContext(ConstraintValidatorContext context, String message, String fieldName) {
        context
                .buildConstraintViolationWithTemplate(message)
                .addPropertyNode(fieldName)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }


}
