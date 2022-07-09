package com.sacha.resourceNetwork.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sacha.resourceNetwork.models.User;
import com.sacha.resourceNetwork.repositories.UserRepo;

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
		System.out.println("here 4...");
		User user=(User) target;
		System.out.println("here 5...");
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			System.out.println("here 6...");
			errors.rejectValue("password","Match","Invalid login");
		}
			
		if(this.uRepo.findByEmail(user.getEmail()) != null) { 
			System.out.println("here 7...");
			errors.rejectValue("email","unique","Email address exists!");
		}
	}
}
