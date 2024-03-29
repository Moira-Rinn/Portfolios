package com.sacha.resourceNetwork.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sacha.resourceNetwork.models.Contact;
import com.sacha.resourceNetwork.models.User;
import com.sacha.resourceNetwork.services.UserService;
import com.sacha.resourceNetwork.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
// **********************REGISTRATION / LOGIN ROUTES*************************
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("user") User user) {
				return "index.jsp";
	}	
//REGISTRATION
	@PostMapping("/registration")
	public String registerUser(
		@Valid 
		@ModelAttribute("user") User user, 
		BindingResult results, 
		HttpServletRequest request
		) { 
			userValidator.validate(user, results);
			if(results.hasErrors()) {
				return "index.jsp";}
			User newUser=userService.registerUser(user);			
			request.getSession().setAttribute("userId", newUser.getId());
			request.getSession().setAttribute("userName", newUser.getUserName());
			return "redirect:/resources";
	}
//LOGIN
	@PostMapping("/login")
	public String loginUser(
		@RequestParam("email") String email, 
		@RequestParam("password") String password, 
		HttpServletRequest request,
		RedirectAttributes redirectAttributes
		) {
			if(userService.authenticateUser(email, password)) {
				User user=userService.findByEmail(email);
				request.getSession().setAttribute("userId", user.getId());
				request.getSession().setAttribute("userName", user.getUserName());
				return "redirect:/resources";
			}
			redirectAttributes.addFlashAttribute("error","Invalid user/pass");
			return "redirect:/";
	}
//LOGOUT
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
// **********************User Profile*************************
	
	@GetMapping("/resources/{id}/profile")
	public String profile(
			@ModelAttribute("newContact") Contact contact,
			@PathVariable("id") Long id,
			Model model,
			HttpServletRequest request
			){
				if(request.getSession().getAttribute("userId")==null)
					return "redirect:/";
				model.addAttribute("user", userService.findById((id)).orElseThrow(RuntimeException::new));
				return "userProfile.jsp";
				}
}
