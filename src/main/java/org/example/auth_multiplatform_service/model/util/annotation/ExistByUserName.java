package org.example.auth_multiplatform_service.model.util.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistByUserNameImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface ExistByUserName {
    String message() default "This user name exist, select other";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
