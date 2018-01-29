package edu.ben.classconnect.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.ben.classconnect.entities.dtos.UserDTO;
import edu.ben.classconnect.utils.validators.annotations.PasswordMatch;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

	@Override
	public boolean isValid(Object objPass, ConstraintValidatorContext arg1) {
		UserDTO user = (UserDTO) objPass;
		return user.getPassword().equals(user.getConfirmPassword());
	}

	@Override
	public void initialize(PasswordMatch arg0) {

	}

}
