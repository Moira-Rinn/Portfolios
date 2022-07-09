package com.sacha.resourceNetwork.models;

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

@Entity
@Table(name="contacts")
public class Contact {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String contactName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User connected;
	
//   @OneToMany(mappedBy="contactUser", fetch=FetchType.LAZY)
//    private List<User> contacts;
   
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="connected_id")
	private User connectedUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public User getConnected() {
		return connected;
	}

	public void setConnected(User connected) {
		this.connected = connected;
	}

	public User getConnectedUsers() {
		return connectedUsers;
	}

	public void setConnectedUsers(User connectedUsers) {
		this.connectedUsers = connectedUsers;
	}
	

	
}