package com.sacha.portfolio.controllers;

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

import com.sacha.portfolio.models.Project;
import com.sacha.portfolio.models.Rating;
import com.sacha.portfolio.services.CommentService;
import com.sacha.portfolio.services.ProjectService;
import com.sacha.portfolio.services.RatingService;
import com.sacha.portfolio.services.ReplyService;
import com.sacha.portfolio.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	@Autowired 
	private RatingService ratingService;
	@Autowired
	private  UserService userService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CommentService commentService;
	
// **********************POST ROUTES*************************
	
//MAIN PAGE
	@GetMapping("/")
	public String project(
		Model model,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")==null)
				return "redirect:/";
//			User user=userService.findById((Long)request.getSession().getAttribute("userId")); 
			model.addAttribute("user", userService.findById((Long)request.getSession().getAttribute("userId")));
			model.addAttribute("books", projectService.all());
			model.addAttribute("starred", ratingService.all());
			return "index.jsp";
	}
	
//ADD NEW PROJECT
	
	@GetMapping("/project/new")
	public String newProj(
		@ModelAttribute("newProj") Project proj,
//		@ModelAttribute("newRating") Rating newRating,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")!=null)
				return "editProject.jsp";
			return "redirect:/";
	}
	
//CREATE NEW PROJECT
	
	@PostMapping("/project/create")
	public String addBook(
		@Valid 
		@ModelAttribute("newProj") Project proj, 
		BindingResult results
		) {
			if(results.hasErrors()) 
				return "editProject.jsp";
			projectService.add(proj);
			return "redirect:/project/details/"+ proj.getId();
	}
	
//GET PROJECT DETAILS 
	
	@GetMapping("/project/details/{id}")
	public String projectDetails(
		@Valid
		@PathVariable("id") Long id, 
		@ModelAttribute("newRating") Rating newRating,
//		@ModelAttribute("newReply") Reply newReply,
		Model model, 
		BindingResult res,
		HttpServletRequest request
		) {
			model.addAttribute("project", projectService.findById(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null) 
				return "projectDetails.jsp";
			return "redirect:/";
	}
	
//EDIT / UPDATE PROJECT
	
	@GetMapping("/edit/{id}")
	public String update(
		@PathVariable("id") Long id,
		Model model,
		HttpServletRequest request
		) {
			model.addAttribute("updateProj", projectService.findById(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null)
				return "editProject.jsp";
			return "redirect:/";
	}
	
	@PutMapping("update/{id}")
	public String update(
		@Valid 
		@ModelAttribute("updateProj") Project updateProj, 
		BindingResult result,
		@PathVariable("id") Long id,
		Model model
		) {
			if(result.hasErrors()) {
				model.addAttribute("updateBook", projectService.findById(id).orElseThrow(RuntimeException::new));
				return "editProject.jsp";
			}
			this.projectService.update(updateProj, id);
			return "redirect:/";
	}
	
//DELETE PROJECT AND ASSOCIATED RATINGS
	
	@DeleteMapping("/delete/{id}")
	public String delete(
		@PathVariable("id") Long id
		) {
			List<Rating> allRatings = ratingService.all();
//			projectService.delete(allRatings, id);
			projectService.delete(id);
			return "redirect:/";

	}
}
