package org.generation.ecommerce.controller;

import javax.servlet.ServletException;

import org.generation.ecommerce.config.JwtFilter;
import org.generation.ecommerce.dto.Token;
import org.generation.ecommerce.model.Useer;
import org.generation.ecommerce.repository.UserRepository;
import org.generation.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController//lo vuelve un controlador
@RequestMapping(path = "/api/login/")
public class LoginController {
//controlador para login
	private final UserService service;
	@Autowired
	public LoginController(UserService service) {
		super();
		this.service = service;
	}//constructor
		

	@PostMapping//permite cifrar los datos y que no se vean en la red
	public Token loginUser(@RequestBody Useer user) throws ServletException {//usa la clase tokken de generation
		if (service.validateUser(user)) {// si le poner otro nombre al service no lo hara
			System.out.println("usuario valido" + user.getEmail());
			return new Token (generateToken(user.getEmail()));
		}
		throw new ServletException("Nombre usuario o contraseña incorrectos "+ user.getEmail());
	}
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")//tipo de usuario
		.setIssuedAt(new Date())//crea la fecha 
		.setExpiration(calendar.getTime())//determina la fecha de espiracion
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
	
}//clas login controller
