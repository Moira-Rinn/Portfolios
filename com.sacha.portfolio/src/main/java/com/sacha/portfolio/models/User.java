package com.sacha.portfolio.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 200, message="User Name must be between 2-200!")
	private String userName;
	
    @NotBlank
    @Size(min = 2, max = 200, message="User Name must be between 2-200!")
	private String fName;
    
    @NotBlank
    @Size(min = 2, max = 200, message="User Name must be between 2-200!")
	private String lName;
    
	@Email
    private String email;
	
	private List<String> imgs;
    
	private Boolean isCreator = false;
	
    @NotBlank
    @Size(min = 8, max = 200, message="Password must be at leat 8 characters!")
    private String password;
    
    @NotBlank
    @Transient
    private String passwordConfirmation;
    
//    @NotBlank(message="Please Enter An Address")
	private String address;
	
//    @NotBlank(message="Please Enter Valid Phone Number")
	private String phone;
    
    private String social;
    
    private String homePage;
    
    @OneToMany(mappedBy="createdBy", fetch=FetchType.LAZY)
    private List<Project> projects; 
    
    @OneToMany(mappedBy ="creator", fetch=FetchType.LAZY)
    private List<Portfolio> portfolios;
    
    @OneToMany(mappedBy ="ratedBy", fetch=FetchType.LAZY)
    private List<Rating> ratings;
    
    @OneToMany(mappedBy="postBy", fetch=FetchType.LAZY)
    private List<Reply> userReplies;
    
    @OneToMany(mappedBy="commenter", fetch=FetchType.LAZY)
    private List<Comment> userComments;
    
/************** Getters and Setters **************/    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public Boolean getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(Boolean isCreator) {
		this.isCreator = isCreator;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Reply> getUserReplies() {
		return userReplies;
	}

	public void setUserReplies(List<Reply> userReplies) {
		this.userReplies = userReplies;
	}

	public List<Comment> getUserComments() {
		return userComments;
	}

	public void setUserComments(List<Comment> userComments) {
		this.userComments = userComments;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}	
}