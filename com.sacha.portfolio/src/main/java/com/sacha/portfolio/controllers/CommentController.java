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

import com.sacha.portfolio.models.Comment;
import com.sacha.portfolio.models.Reply;
import com.sacha.portfolio.services.CommentService;
import com.sacha.portfolio.services.ProjectService;
import com.sacha.portfolio.services.ReplyService;

@Controller
public class CommentController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CommentService commentService;
	
	
	
/*********************REGISTRATION / LOGIN ROUTES*************************/
	
//ADD
	
	@PostMapping("/addComment/{id}")
	public String addComment(
		@Valid
		@ModelAttribute("newReply") Comment newComment,
		@PathVariable("id") Long projId,
		BindingResult results,
		Model model
		) {
			model.addAttribute("project", projectService.findById(projId).orElseThrow(RuntimeException::new));
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			commentService.add(newComment);
			return "redirect:/project/details/" + projId;
	}
//UPDATE
	
	@PutMapping("/editComment/{id}")
	public String editComment(
		@Valid
		@ModelAttribute("updateComment") Comment updateComment,
		BindingResult results,
		@PathVariable("id") Long id,
		Model model
		) {
			Comment comment = commentService.findById(id).orElseThrow(RuntimeException::new);
			model.addAttribute("comment", comment);
			if(results.hasErrors()) 
				return "projectDetails.jsp";
			commentService.update(updateComment, id);
			return "redirect:/project/details/" + comment.getCommentingOn().getRepliedTo().getId();
	}
//DELETE
	
	@DeleteMapping("/deleteReply/{projId}/{id}")
	public String delete(
		@PathVariable("id" ) Long id, 
		@PathVariable("projId") Long projId
		){
			commentService.delete(id);
			return "redirect:/project/details/" + projId;
	}
}
