package com.sacha.portfolio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="replies")
public class Reply {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 1, max = 255, message="Reply must be between 1-255 characters!")
	private String reply;
	
	private Date dateCreated;
	private Date dateModified;
	
	@OneToMany(mappedBy ="commentingOn", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User postBy;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project repliedTo;

/************** Getters and Setters **************/	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public List<Comment> getUserComment() {
		return userComment;
	}

	public void setUserComment(List<Comment> userComment) {
		this.userComment = userComment;
	}

	public User getPostBy() {
		return postBy;
	}

	public void setPostBy(User postBy) {
		this.postBy = postBy;
	}

	public Project getRepliedTo() {
		return repliedTo;
	}

	public void setRepliedTo(Project repliedTo) {
		this.repliedTo = repliedTo;
	}
}