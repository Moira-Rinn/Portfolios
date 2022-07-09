package com.sacha.resourceNetwork.models;

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
	
	@Email
    private String email;
    
    @NotBlank
    @Size(min = 8, max = 200, message="Password must be at leat 8 characters!")
    private String password;
    
    @NotBlank
    @Transient
    private String passwordConfirmation;
    
    @OneToMany(mappedBy="poster", fetch=FetchType.LAZY)
    private List<Apartment> apartments;

    @OneToMany(mappedBy ="user", fetch=FetchType.LAZY)
   	private List<Possible> possibles;
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public List<Possible> getPossibles() {
		return possibles;
	}

	public void setPossibles(List<Possible> possibles) {
		this.possibles = possibles;
	}
	
    
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