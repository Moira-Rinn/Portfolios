package com.sacha.resourceNetwork.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sacha.resourceNetwork.models.Possible;
import com.sacha.resourceNetwork.services.ApartmentService;
import com.sacha.resourceNetwork.services.PossibleService;
import com.sacha.resourceNetwork.services.UserService;

@Controller
public class PossibleController {
	
	@Autowired 
	private PossibleService possibleService;
	@Autowired 
	private UserService userService;
	@Autowired 
	private ApartmentService apartmentService;
	
// **********************FAVORITE ROUTES*************************
	
//ADD
	@PostMapping("/apartments/addPossible/{id}")
	public String add(
		@Valid
		@ModelAttribute("newPossible") Possible possible,
		BindingResult results,
		@PathVariable("id") Long id,
		Model model
		) {
			model.addAttribute("apartment", apartmentService.findOne(id).orElseThrow(RuntimeException::new));
			if(results.hasErrors()) 
				return "apartmentDetails.jsp";
			possibleService.create(possible);
			return "redirect:/apartments/"+ id +"/profile";
	}
//DELETE
	@DeleteMapping("/apartments/user/{userId}delete-possible/{id}")
	public String delete(
		@PathVariable("id" ) Long id, 
		@PathVariable("userId" ) Long userId
		){
			possibleService.delete(id);
			return "redirect:/apartments/"+ userId +"/profile";
	}
}
