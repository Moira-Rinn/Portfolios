package com.sacha.portfolio.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
//    @NotBlank
//    @Size(min = 2, max = 200, message="User Name must be between 2-200!")
	private String name;
//	
//    @NotBlank
//    @Size(min = 2, max = 200, message="User Name must be between 2-200!")
	private String description;
    
//    @NotBlank
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
    
    private String linkToProject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getLinkToProject() {
		return linkToProject;
	}

	public void setLinkToProject(String linkToProject) {
		this.linkToProject = linkToProject;
	}
    
    
}