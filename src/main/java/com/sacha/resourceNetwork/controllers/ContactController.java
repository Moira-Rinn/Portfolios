package com.sacha.resourceNetwork.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sacha.resourceNetwork.models.Contact;
import com.sacha.resourceNetwork.services.ContactService;
import com.sacha.resourceNetwork.services.UserService;

@Controller
public class ContactController {
	
	@Autowired 
	private ContactService contactService;
	@Autowired 
	private UserService userService;
	
// **********************CONTACT ROUTES*************************

//FIND ALL
	@GetMapping("/contacts/user/{id}/contacts")
	public String contacts(
		@PathVariable("id") Long id,
		Model model,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")==null)
				return "redirect:/";
			model.addAttribute("user", userService.findById(id).orElseThrow(RuntimeException::new));
			model.addAttribute("contacts", contactService.findAll()); //Shouldn't need to do this because the contact info should be stored in user above... taking from only the user instance will eliminate the need for conditionals in the JSP file.
			return "userContacts.jsp";
	}
//ADD
	@PostMapping("/contacts/user/addContact/{id}")
	public String add(
		@Valid
		@ModelAttribute("newContact") Contact contactUser,
		BindingResult results,
		@PathVariable("id") Long id,
		Model model
		) {
			model.addAttribute("user", userService.findById(id).orElseThrow(RuntimeException::new));
			if(results.hasErrors()) 
				return "userProfile.jsp";
			contactService.create(contactUser);
			return "redirect:/contacts/";
	}
//DELETE
	@DeleteMapping("/contacts/user/delete-contact/{id}")
	public String delete(@PathVariable("id") Long id){
			contactService.delete(id);
			return "redirect:/contacts";
	}
}
