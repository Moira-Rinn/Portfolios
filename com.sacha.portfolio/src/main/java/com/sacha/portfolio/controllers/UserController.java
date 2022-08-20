package com.sacha.portfolio.controllers;

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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.sacha.portfolio.models.Creator;
//import com.sacha.portfolio.models.Contact;
import com.sacha.portfolio.models.User;
//import com.sacha.portfolio.services.CreatorService;
import com.sacha.portfolio.services.UserService;
import com.sacha.portfolio.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private CreatorService creatorService;
	
	@Autowired
	private UserValidator userValidator;
	
// **********************REGISTRATION / LOGIN ROUTES*************************
	
	@GetMapping("/")
	public String index(
			) {
			return "index.jsp";
	}
	@GetMapping("/login-reg")
	public String index(@ModelAttribute("user") User user
			) {
			return "logReg.jsp";
	}
	@GetMapping("/creatorReg/{id}")
	public String creatorReg(
			@PathVariable("id") Long id,
			Model model
			) {
			model.addAttribute("creator", userService.findById(id).orElseThrow(RuntimeException::new));
			return "creator.jsp";
	}
	
//REGISTRATION
	
	@PostMapping("/registration")
	public String registerUser(	
		@Valid 
		@ModelAttribute("user") User user, 
		BindingResult results,
		Model model,
		HttpServletRequest request
		) { 
			userValidator.validate(user, results);
			if(results.hasErrors()) {
				model.addAttribute("user", userService.findById(user.getId()).orElseThrow(RuntimeException::new));
				return "logReg.jsp";}
					this.userService.registerUser(user);			
			request.getSession().setAttribute("userId", user.getId());
			request.getSession().setAttribute("userName", user.getUserName());
			if(user.getIsCreator()) {
				return "redirect:/creatorReg/"+user.getId();
			}
			return "redirect:/";
	}
	
	@PostMapping("/creatorReg/{id}")
	public String creatorReg(
		@RequestParam("address") String address,
		@RequestParam("social") String social,
		@RequestParam("phone") String phone,
		@RequestParam("homePage") String homePage,
		@RequestParam("projects") String projects,
		@RequestParam("password") String password,
		@PathVariable("id") Long id,
		Model model,
		HttpServletRequest request,
		RedirectAttributes redirectAttributes
		) { 
		User creator = userService.findById(id).orElseThrow(RuntimeException::new);
		creator.setAddress(address);
		creator.setHomePage(homePage);
		creator.setPhone(phone);
		creator.setProjects(projects);
		creator.setSocial(social);
		model.addAttribute("creator", creator);
		if(userService.authenticateUser(creator.getEmail(), password)) {
			this.userService.updateUser(creator, id);
			return "redirect:/";
		}
		redirectAttributes.addFlashAttribute("error","Invalid password");
		return "creator.jsp";
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
				return "redirect:/";
			}
			redirectAttributes.addFlashAttribute("error","Invalid user/pass");
			return "logReg.jsp";
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
//			@ModelAttribute("newContact") Contact contact,
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
