package com.glabs.dmaic.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.convert.DataSizeUnit;

import com.glabs.dmaic.dmaic_app.Dmaic;


@Entity
@Table(name = "users")
public class User  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long userId;
	
	
	private String firstName;
	private String lastName;
	private Long phoneNumber;		
	private String email;
	private String password;
	
	//@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	//Set<Dmaic> dmaic = new HashSet<Dmaic>();	 
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Dmaic> dmaic;
	
	
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Dmaic> getDmaic() {
		return dmaic;
	}
	
	public void setDmaic(List<Dmaic> dmaic) {
		this.dmaic = dmaic;
	}


	
	public User() {
		
	}
	
	public Long getId() {
		return userId;
	}
	public void setId(Long id) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	/*
	public Set<Dmaic> getDmaic() {
		return dmaic;
	}

	public void setDmaic(Set<Dmaic> dmaic) {
		this.dmaic = dmaic;
	}
	*/

	@Override
	public String toString() {
		return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + ", dmaic=" + dmaic + "]";
	}

	
}
