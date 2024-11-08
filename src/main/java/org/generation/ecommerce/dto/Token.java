package org.generation.ecommerce.dto;

public class Token {
	private final String acessToken;//al ser final solo se puede asginar una sola vez

	public Token(String acessToken) {
		super();
		this.acessToken = acessToken;
	}

	public String getAcessToken() {
		return acessToken;
	}//get acces tokken
	

}
