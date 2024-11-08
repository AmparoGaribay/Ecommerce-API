package org.generation.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.generation.ecommerce.dto.ChangePassword;
import org.generation.ecommerce.model.Useer;
import org.generation.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public final UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	public List<Useer> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	public Useer getUser(Long idUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(idUser).orElseThrow(
				()-> new IllegalArgumentException("El usuario  con el id ["+
						idUser+"] no existe")
						);
	}


	public Useer addNewUser(Useer useer) {
		Optional<Useer> userTemporal=userRepository.findByEmail(useer.getEmail());
		if(userTemporal.isEmpty()) {
			useer.setPassword(passwordEncoder.encode(useer.getPassword()));
			return userRepository.save(useer);
		}else {
			System.out.println("ya existe el producto con el nombre["
					+ useer.getEmail() + "]");
			return null;
		}
	}


	public Useer deleteUser(Long idUser) {

		Useer useerTempora=null;
		if(userRepository.existsById(idUser)) {
			useerTempora=userRepository.findById(idUser).get();
			userRepository.deleteById( Long.valueOf(idUser));
		}
		return useerTempora;
	}


	public Useer updateUser2(Long idUser, ChangePassword changePassword) {
		Useer tmpUser=null;
		if(userRepository.existsById(idUser)) {
			tmpUser=userRepository.findById(idUser).get();
			//if(tmpUser.getPassword().equals(changePassword.getPassword())) {
			if(passwordEncoder.matches(changePassword.getPassword(), tmpUser.getPassword())) {
				
				tmpUser.setPassword(passwordEncoder.encode(changePassword.getNpasword()));
				userRepository.save(tmpUser);
			}else {
				System.out.println("UptateUser- el password del usuario ["
						+ tmpUser.getId() +"] no coincide ");
				tmpUser=null;
			}//si es igual
		}//si el usario existe
		return tmpUser;
	}


	public boolean validateUser(Useer user) {
		Optional<Useer> userByEmail =userRepository.findByEmail(user.getEmail());
		if(userByEmail.isPresent()) {
			Useer tmpUser = userByEmail.get();
			//if(user.getPassword().equals(tmpUser.getPassword())){
			if(passwordEncoder.matches(user.getPassword(),tmpUser.getPassword() )) {
				return true;
			}
		}
			return false;	
	}//valita user


	/*public Useer updateUser(Long idUser, String email, String password) {
		Useer user = null;
		if (userRepository.existsById(idUser)) {
			user=userRepository.findById(idUser).get();
			if(email.length()!=0) user.setEmail(email);
			if(password.length()!=0) user.setPassword(password);
			userRepository.save(user);
		}
		return user;
	}
	*/

}
