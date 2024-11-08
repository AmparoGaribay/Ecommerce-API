package org.generation.ecommerce.dto;

public class ChangePassword {
	private String password;
	private String npasword;
	public ChangePassword(String password, String npasword) {
		super();
		this.password = password;
		this.npasword = npasword;
	}
	
	public ChangePassword() {
		// TODO Auto-generated constructor stub
	}//constructor vacio

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpasword() {
		return npasword;
	}

	public void setNpasword(String npasword) {
		this.npasword = npasword;
	}

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npasword=" + npasword + "]";
	}
	
	

}//class
