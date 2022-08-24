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

import com.sacha.portfolio.models.Comment;
import com.sacha.portfolio.models.Portfolio;
import com.sacha.portfolio.models.Project;
import com.sacha.portfolio.models.Rating;
import com.sacha.portfolio.models.Reply;
import com.sacha.portfolio.services.CommentService;
import com.sacha.portfolio.services.PortfolioService;
import com.sacha.portfolio.services.ProjectService;
import com.sacha.portfolio.services.ReplyService;
import com.sacha.portfolio.services.UserService;

@Controller
public class PortfolioController {
	
	@Autowired 
	private PortfolioService portfolioService;
	@Autowired 
	private ProjectService projectService;
//	@Autowired 
//	private RatingService ratingService;
	@Autowired
	private  UserService userService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CommentService commentService;
	
// **********************POST ROUTES*************************
	
//MAIN PAGE
	@GetMapping("/portfolio")
	public String portfolio(
		Model model,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")==null)
				return "redirect:/";
//			User user=userService.findById((Long)request.getSession().getAttribute("userId")); 
			model.addAttribute("user", userService.findById((Long)request.getSession().getAttribute("userId")));
			model.addAttribute("portfolios", portfolioService.all());
//			model.addAttribute("ratings", ratingService.all());
			return "index.jsp";
	}
	
//ADD NEW PROJECT
	
	@GetMapping("/portfolio/new")
	public String newProj(
		@ModelAttribute("newProj") Project proj,
//		@ModelAttribute("newRating") Rating newRating,
		HttpServletRequest request
		) {
			if(request.getSession().getAttribute("userId")!=null)
				return "editProject.jsp";
			return "redirect:/";
	}
	
//CREATE NEW PORTFOLIO
	
	@PostMapping("/portfolio/create")
	public String addPortfolio(
		@Valid 
		@ModelAttribute("newPort") Portfolio port, 
		BindingResult results
		) {
			if(results.hasErrors()) 
				return "editProject.jsp";
			portfolioService.add(port);
			return "redirect:/portfolio/details/"+ port.getId();
	}
	
//GET PORTFOLIO DETAILS 
	
	@GetMapping("/portfolio/details/{id}")
	public String portfolioDetails(
		@Valid
		@PathVariable("id") Long id, 
//		@ModelAttribute("newRating") Rating newRating,
		@ModelAttribute("newReply") Reply newReply,
		@ModelAttribute("newComment") Comment newComment,
		Model model, 
		BindingResult res,
		HttpServletRequest request
		) {
			model.addAttribute("portfolio", portfolioService.findById(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null) 
				return "portfolioDetails.jsp";
			return "redirect:/";
	}
	
//EDIT / UPDATE PROJECT
	
	@GetMapping("/portfolio/edit/{id}")
	public String portfolioUpdate(
		@PathVariable("id") Long id,
		Model model,
		HttpServletRequest request
		) {
			model.addAttribute("updatePort", portfolioService.findById(id).orElseThrow(RuntimeException::new));
			if(request.getSession().getAttribute("userId")!=null)
				return "editPortfolio.jsp";
			return "redirect:/";
	}
	
	@PutMapping("/portfolio/update/{id}")
	public String portfolioUpdate(
		@Valid 
		@ModelAttribute("updatePort") Portfolio updatePort, 
		BindingResult result,
		@PathVariable("id") Long id,
		Model model
		) {
			if(result.hasErrors()) {
				model.addAttribute("updateBook", portfolioService.findById(id).orElseThrow(RuntimeException::new));
				return "editProject.jsp";
			}
			this.portfolioService.update(updatePort, id);
			return "redirect:/";
	}
	
//DELETE PROJECT AND ASSOCIATED RATINGS
	
	@DeleteMapping("/portfolio/delete/{id}")
	public String portfolioDelete(
		@PathVariable("id") Long id
		) {
//			List<Rating> allRatings = ratingService.all();
//			projectService.delete(allRatings, id);
			portfolioService.delete(id);
			return "redirect:/";

	}
}
