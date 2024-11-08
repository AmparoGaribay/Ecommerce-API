package org.generation.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")

public class Useer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false )
	private String email;
	@Column(nullable = false )
	private String password;


	public Useer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Useer() {
		// TODO Auto-generated constructor stub
	}//CONSTRUCTROR VACIO

	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

	
	
	
}
