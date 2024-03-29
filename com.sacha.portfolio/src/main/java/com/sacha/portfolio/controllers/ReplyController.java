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
import com.sacha.portfolio.models.Reply;
import com.sacha.portfolio.services.CommentService;
import com.sacha.portfolio.services.ProjectService;
import com.sacha.portfolio.services.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CommentService commentService;
	
	
	
/*********************REGISTRATION / LOGIN ROUTES*************************/
	
//ADD
	
	@PostMapping("/addReply/{id}")
	public String addReply(
		@Valid
		@ModelAttribute("newReply") Reply newReply,
		@PathVariable("id") Long projId,
		BindingResult results,
		Model model
		) {
			model.addAttribute("project", projectService.findById(projId).orElseThrow(RuntimeException::new));
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			replyService.add(newReply);
			return "redirect:/project/details/" + projId;
	}
//UPDATE
	
	@PutMapping("/editReply/{id}")
	public String editReply(
		@Valid
		@ModelAttribute("updateRating") Reply updateReply,
		BindingResult results,
		@PathVariable("id") Long id,
		Model model
		) {
			Reply reply = replyService.findById(id).orElseThrow(RuntimeException::new);
			model.addAttribute("reply", reply);
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			replyService.update(updateReply, id);
			return "redirect:/project/details/" + reply.getRepliedTo().getId();
	}
//DELETE
	
	@DeleteMapping("/deleteReply/{projId}/{id}")
	public String delete(
		@PathVariable("id" ) Long id, 
		@PathVariable("projId") Long projId
		){
			replyService.delete(id);
			return "redirect:/project/details/" + projId;
	}
}
