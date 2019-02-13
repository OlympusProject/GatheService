package com.gathe.auth.util.validator;

import com.gathe.auth.service.OAuthClientDetailsService;
import com.gathe.auth.util.validator.annotation.UniqueClientId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueClientIdValidator implements ConstraintValidator<UniqueClientId, String> {

    private final OAuthClientDetailsService service;

    public UniqueClientIdValidator(final OAuthClientDetailsService service) {
        this.service = service;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s != null && !s.isEmpty()) {
            boolean exists = service.clientIdExists(s);
            return !exists;
        }

        return true;
    }

    @Override
    public void initialize(UniqueClientId constraintAnnotation) {
    }
}
