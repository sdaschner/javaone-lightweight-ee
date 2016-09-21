package com.sebastian_daschner.javaone;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CloudNotTakenValidator implements ConstraintValidator<CloudNotTaken, String> {

    @Inject
    Oracle oracle;

    public void initialize(CloudNotTaken constraint) {
    }

    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !oracle.isCloudTaken(name);
    }

}
