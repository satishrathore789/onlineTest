package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.model.User;
import com.aartekrepo.RegistrationRepo;
@Component
public class LoginValidator {
	@Autowired
	private RegistrationRepo registrationRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "passwords", "error.password.empty");

		if (!user.getEmailId().isEmpty() && user.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(user.getEmailId());
			if (user.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (user.getEmailId().contains(".com") != true && user.getEmailId().contains(".net") != true
					&& !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		
		}

		if(!user.getPasswords().isEmpty() && user.getPasswords().trim().length()>0)
			if((user.getPasswords().trim().length()<6||user.getPasswords().trim().length()>20)&&user.getPasswords()==" ")
			{
				errors.rejectValue("passwords","error.password.rule");
			}
	
	}

}
