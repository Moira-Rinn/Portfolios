package com.sacha.portfolio.models;

//import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
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
    
	private Boolean isCreator = false;
	
    @NotBlank
    @Size(min = 8, max = 200, message="Password must be at leat 8 characters!")
    private String password;
    
    @NotBlank
    @Transient
    private String passwordConfirmation;
    
    //If isCreator = true:
    
    @NotBlank(message="Please Enter An Address")
	private String address;
	
    @NotBlank(message="Please Enter Valid Phone Number")
	private String phone;
    

//    @OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
//    private List<Project> projects;
    private String projects;
    private String social;
    private String homePage;
    
//    @OneToMany(mappedBy="poster", fetch=FetchType.LAZY)
//    private List<Apartment> apartments;
//
//    @OneToMany(mappedBy ="user", fetch=FetchType.LAZY)
//   	private List<Possible> possibles;
    
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

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
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

//	public List<Apartment> getApartments() {
//		return apartments;
//	}
//
//	public void setApartments(List<Apartment> apartments) {
//		this.apartments = apartments;
//	}
//
//	public List<Possible> getPossibles() {
//		return possibles;
//	}
//
//	public void setPossibles(List<Possible> possibles) {
//		this.possibles = possibles;
//	}
	
    
//    @OneToMany(mappedBy ="readBy", fetch=FetchType.LAZY)
//	private List<Star> stars;
//    
//    @OneToMany(mappedBy="responseBy", fetch=FetchType.LAZY)
//    private List<Response> responses;
    
//    @OneToMany(mappedBy="connected", fetch=FetchType.LAZY)
//    private List<Contact> user;
    
//    @ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="contact_id")
//	private User contactUser;
    
//    @OneToMany(mappedBy="connectedUsers", fetch=FetchType.LAZY)
//    private List<Contact> connections;
//
//	@OneToMany(mappedBy ="reader", fetch=FetchType.LAZY)
//   	private List<ToRead> toBeRead;
//    
//    @OneToMany(mappedBy ="reader", fetch=FetchType.LAZY)
//   	private List<Favorite> favorites;
	
}