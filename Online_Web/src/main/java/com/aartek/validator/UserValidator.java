package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartekrepo.RegistrationRepo;

@Component
public class UserValidator implements Validator {

	@Autowired
	private RegistrationRepo registrationRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastname.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "passwords", "error.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "mobiles", "error.mobile.empty");
		if (user.getMobiles().isEmpty() && user.getMobiles()!= "")
		{
			boolean checkMobile = ValidationUtil.validateMobile(user.getMobiles());
			if (user.getMobiles().trim().length() < 10 || user.getMobiles().trim().length()>10)
			{
				  
			    if(!checkMobile)
				errors.rejectValue("mobiles", "error.mobileNo.length");
			}

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
				else if(registrationRepo.findByName(user.getEmailId()).isEmpty());
				errors.rejectValue("emailId","error.eamilId.present" );
			}

		}
		if(!user.getFirstName().isEmpty() && user.getFirstName().trim().length()>0 )
		{
			if((user.getFirstName().trim().length()<6||user.getFirstName().trim().length()>25)&&!user.getFirstName().matches("[A-Za-z]"))
			{
			errors.rejectValue("firstName","error.firstname.rule");
		}
		}
		if(!user.getLastName().isEmpty() && user.getLastName().trim().length()>0 )
		{
			if((user.getLastName().trim().length()<6||user.getLastName().trim().length()>25)&&!user.getLastName().matches("[A-Za-z]"))
			{
			errors.rejectValue("lastName","error.lastname.rule");
		}
		}
		if(!user.getPasswords().isEmpty() && user.getPasswords().trim().length()>0)
		if((user.getPasswords().trim().length()<6||user.getPasswords().trim().length()>20)&&user.getPasswords()==" ")
		{
			errors.rejectValue("passwords","error.password.rule");
		}
		
	}
}
