package com.bank.api.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static java.util.regex.Pattern.compile;


public class UuidValidator implements ConstraintValidator<Uuid, Object> {

    private static final Pattern UUID_PATTERN =
            compile("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");

    @Override
    public void initialize(Uuid constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return isNull(value) ||
                ((value instanceof String && isValidUUID((String) value)) ||
                        (value instanceof UUID && isValidUUID(value.toString())));
    }

    private static boolean isValidUUID(String uuid) {
        return UUID_PATTERN.matcher(uuid).matches();
    }
}
