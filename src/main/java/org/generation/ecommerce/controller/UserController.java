package org.generation.ecommerce.controller;

import java.util.List;import org.apache.catalina.User;
import org.generation.ecommerce.dto.ChangePassword;
import org.generation.ecommerce.model.Useer;
import org.generation.ecommerce.service.ProductService;
import org.generation.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/api/users/")
public class UserController {
	// NOTA SUPER IMPORTANTE, SI NO TIENES TU SERVICIO DE MYSQL CORRIENDO TE LANZARA UN ERROR DE JDVC
	private final UserService service;
	@Autowired
	
	public UserController(UserService service ) {
		this.service=service;
	}
	
	@GetMapping
	public List<Useer> getUser(){
		return service.getAllUsers();
	}
	
	@GetMapping (path = "{idUser}")
	public Useer  getUser(@PathVariable ("idUser") Long idUser) {
		return service.getUser(idUser);
	}
	
	@PostMapping
	public Useer addNewUser(@RequestBody Useer useer) {
		return service.addNewUser(useer);
	}
	
	@DeleteMapping (path = "{idUser}")
	public Useer deleteUser(@PathVariable("idUser")Long idUser ){
		return service.deleteUser(idUser);
	}
	
	//especial para usuarios params es parametros url y body entodo
	
	@PutMapping(path = "{idUser}")
	public Useer updateUser(@PathVariable ("idUser")Long idUser,
			@RequestBody ChangePassword changePassword) {
		return service.updateUser2(idUser, changePassword);
		
	}
	
	

}
