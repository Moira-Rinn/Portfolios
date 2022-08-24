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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 50, message="Project name must be between 2-50 characters!")
	private String name;
	
    @NotBlank
    @Size(min = 2, max = 255, message="Project description must be between 2-255 characters!")
	private String description;
    
    private String version;
    
    private String language;
    
    private String tags;
    
    private String repoLink;
    
    private String websiteLink;
    
    private Date dateCreated;
    
    private Date dateModified;
    
    private String selectedImg;
    
    private String images;
    
    @OneToMany(mappedBy ="project", fetch=FetchType.LAZY)
    private List<Portfolio> portfolios;
    
    @OneToMany(mappedBy ="repliedTo", fetch=FetchType.LAZY)
    private List<Reply> replies;
    
    @OneToMany(mappedBy ="rated", fetch=FetchType.LAZY)
	private List<Rating> rating;

    @NotBlank
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="createdBy_id")
    private User createdBy;
    
/************** Getters and Setters **************/
    
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getRepoLink() {
		return repoLink;
	}

	public void setRepoLink(String repoLink) {
		this.repoLink = repoLink;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public float getAvgRating() {
		float sum=0;
		for (Rating rated : rating) sum+=rated.getRating();
		
		if(sum!=0) {
			sum=sum/this.rating.size();
			return sum;
		}else {
			float x=0.0f;
			return x;
		}	
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

	public String getSelectedImg() {
		return selectedImg;
	}

	public void setSelectedImg(String selectedImg) {
		this.selectedImg = selectedImg;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
}