package com.sacha.resourceNetwork.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.sacha.resourceNetwork.models.Apartment;
import com.sacha.resourceNetwork.models.Possible;
import com.sacha.resourceNetwork.services.ApartmentService;
import com.sacha.resourceNetwork.services.PossibleService;
import com.sacha.resourceNetwork.services.UserService;

@Controller
public class ApartmentController {
	
	@Autowired 
	private ApartmentService apartmentService;
	@Autowired 
	private PossibleService possibleService;
	@Autowired
	private  UserService userService;
	
// **********************POST ROUTES*************************
	
//MAIN PAGE
	@GetMapping("/apartments")
	public String apartments(
		Model model,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")==null)
				return "redirect:/"; 
			model.addAttribute("user", userService.findById((Long)request.getSession().getAttribute("userId")));
			model.addAttribute("apartments", apartmentService.all());
			model.addAttribute("starred", possibleService.findAll());
			return "apartmentList.jsp";
	}
//ADD NEW POST
	@GetMapping("/apartments/new")
	public String newApartment(
		@ModelAttribute("newApartment") Apartment apartment,
//		@ModelAttribute("newStar") Star stars,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")!=null)
				return "addEditApartment.jsp";
			return "redirect:/";
	}
//CREATE NEW POST 
	@PostMapping("/apartments/create")
	public String addApartment(
		@Valid 
		@ModelAttribute("newApartment") Apartment apartment, 
		BindingResult results
		) {
			if(results.hasErrors()) 
				return "addEditApartment.jsp";
			apartmentService.add(apartment);
			return "redirect:/apartments/details/"+apartment.getId();
	}
//GET POST DETAILS 
	@GetMapping("/apartments/details/{id}")
	public String apartmentDetails(
		@Valid
		@PathVariable("id") Long id, 
		@ModelAttribute("newStars") Possible newPossible,
//		@ModelAttribute("newResponse") Response response,
		Model model, 
		BindingResult res,
		HttpServletRequest request
		) {
			model.addAttribute("apartment", apartmentService.findOne(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null) 
				return "apartmentDetails.jsp";
			return "redirect:/";
	}
//EDIT POST
	@GetMapping("/apartments/edit/{id}")
	public String update(
		@PathVariable("id") Long id,
		Model model,
		HttpServletRequest request
		) {
			model.addAttribute("updateApartment", apartmentService.findOne(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null)
				return "addEditApartment.jsp";
			return "redirect:/";
	}
//UPDATE POST
	@PutMapping("books/update/{id}")
	public String update(
		@Valid 
		@ModelAttribute("updateApartment") Apartment updateApartment, 
		BindingResult result,
		@PathVariable("id") Long id,
		Model model
		) {
			if(result.hasErrors()) {
				model.addAttribute("updateApartment", apartmentService.findOne(id).orElseThrow(RuntimeException::new));
				return "addEditApartment.jsp";
			}
			this.apartmentService.update(updateApartment, id);
			return "redirect:/apartments";
	}
//DELETE POST AND ASSOCIATED STARS
	@DeleteMapping("/apartments/delete/{id}")
	public String deleteApartment(
		@PathVariable("id") Long id
		) {
			List<Possible> allPossibles = possibleService.findAll();
			apartmentService.delete(allPossibles, id);
			apartmentService.delete(id);
			return "redirect:/apartments";

	}
}
