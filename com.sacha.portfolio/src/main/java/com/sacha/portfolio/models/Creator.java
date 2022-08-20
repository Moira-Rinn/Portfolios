//package com.sacha.portfolio.models;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name="creators")
//public class Creator extends User {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//    
//    @NotBlank(message="Please Enter An Address")
//	private String address;
//	
//    @NotBlank(message="Please Enter Valid Phone Number")
//	private String phone;
//    
//
////    @OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
////    private List<Project> projects;
//    private String projects;
//    private String social;
//    
//    private String homePage;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
////	public List<Project> getProjects() {
////		return projects;
////	}
////
////	public void setProjects(List<Project> projects) {
////		this.projects = projects;
////	}
//	
//
//	public String getSocial() {
//		return social;
//	}
//
//	public String getProjects() {
//		return projects;
//	}
//
//	public void setProjects(String projects) {
//		this.projects = projects;
//	}
//
//	public void setSocial(String social) {
//		this.social = social;
//	}
//
//	public String getHomePage() {
//		return homePage;
//	}
//
//	public void setHomePage(String homePage) {
//		this.homePage = homePage;
//	}
//   
//	
//}