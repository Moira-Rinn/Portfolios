package com.sacha.portfolio.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sacha.portfolio.models.User;
import com.sacha.portfolio.repositories.UserRepo;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserRepo uRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {	
		User user=(User) target;
		if(!user.getPasswordConfirmation().equals(user.getPassword())) 
			errors.rejectValue("password","Match","Invalid Registration");
		if(this.uRepo.findByEmail(user.getEmail()) != null)
			errors.rejectValue("email","unique","Email address exists!");
	}
}
