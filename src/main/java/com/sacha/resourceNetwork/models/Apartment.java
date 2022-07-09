package com.sacha.resourceNetwork.models;

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
@Table(name="apartments")
public class Apartment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 
	@NotBlank
	@Size(min = 2, max = 200, message="Title must be between 2-200!")
	private String title;

	@NotBlank
	@Size(min = 2, max = 255, message="Description must be between 2-255!")
	private String description;
	
	@NotBlank
	private String link;
	@NotBlank
	private Integer size;
	@NotBlank
	private Float price;
	@NotBlank
	private Date dateAvail;
	@NotBlank
	private Date datePosted;
	@NotBlank
	private String location;
	@NotBlank
	private String pets;
	@NotBlank
	private Integer bed;
	@NotBlank
	private Integer bath;
	@NotBlank
	private String contact;
	@NotBlank
	private String accessibility;
	@NotBlank
	private String utilities;
	
	@NotBlank
	@Size(min = 2, max = 200, message="Posted by must be between 2-200!")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User postedBy;
	
	@OneToMany(mappedBy ="apartment", fetch=FetchType.LAZY)
   	private List<Possible> possibles;
//	  
//	@OneToMany(mappedBy ="starred", fetch=FetchType.LAZY)
//	private List<Star> stars;
//	
//	@OneToMany(mappedBy ="book", fetch=FetchType.LAZY)
//	private List<ToRead> bookToRead;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDateAvail() {
		return dateAvail;
	}

	public void setDateAvail(Date dateAvail) {
		this.dateAvail = dateAvail;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}

	public Integer getBed() {
		return bed;
	}

	public void setBed(Integer bed) {
		this.bed = bed;
	}

	public Integer getBath() {
		return bath;
	}

	public void setBath(Integer bath) {
		this.bath = bath;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	public String getUtilities() {
		return utilities;
	}

	public void setUtilities(String utilities) {
		this.utilities = utilities;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public List<Possible> getPossibles() {
		return possibles;
	}

	public void setPossibles(List<Possible> possibles) {
		this.possibles = possibles;
	}
	

	
}