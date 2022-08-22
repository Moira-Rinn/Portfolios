package com.sacha.portfolio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.sacha.portfolio.models.Rating;
import com.sacha.portfolio.services.ProjectService;
import com.sacha.portfolio.services.RatingService;

@Controller
public class RatingController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private RatingService ratingService;
	
/*********************REGISTRATION / LOGIN ROUTES*************************/
	
//ADD
	@PostMapping("/addRatings/{id}")
	public String addRating(
		@Valid
		@ModelAttribute("newRatings") Rating newRating,
		@PathVariable("id") Long projId,
		BindingResult results,
		Model model
		) {
			model.addAttribute("book", projectService.findById(projId).orElseThrow(RuntimeException::new));
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			ratingService.add(newRating);
			return "redirect:/project/details/" + projId;
	}
//UPDATE
	@PutMapping("/editRating/{id}")
	public String editRating(
		@Valid
		@ModelAttribute("updateRating") Rating updateRating,
		BindingResult results,
		@PathVariable("id") Long id,
		Model model
		) {
			Rating rating = ratingService.findById(id).orElseThrow(RuntimeException::new);
			model.addAttribute("rating", rating);
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			ratingService.update(updateRating, id);
			return "redirect:/project/details/" + rating.getRated().getId();
	}
//DELETE
	@DeleteMapping("/deleteRating/{projId}/{id}")
	public String delete(
		@PathVariable("id" ) Long id, 
		@PathVariable("projId") Long projId
		){
			ratingService.delete(id);
			return "redirect:/project/details/" + projId;
	}
}
