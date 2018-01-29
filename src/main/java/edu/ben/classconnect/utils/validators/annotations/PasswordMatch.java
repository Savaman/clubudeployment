package edu.ben.classconnect.utils.validators.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import edu.ben.classconnect.utils.validators.PasswordMatchValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ TYPE, ANNOTATION_TYPE })
public @interface PasswordMatch {
	String message() default "Passwords don't match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
