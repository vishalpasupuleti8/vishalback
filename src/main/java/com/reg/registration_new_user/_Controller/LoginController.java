package com.reg.registration_new_user._Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reg.registration_new_user._Model.RegisterUser;
import com.reg.registration_new_user._Model.User;
import com.reg.registration_new_user._Repository.RegisterUserRepository;
@RestController
@RequestMapping("/User/login")
public class LoginController {
	
	@Autowired
	RegisterUserRepository registeruserrepo;
	
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@PostMapping
	public ResponseEntity<?> login(@RequestBody() User user) {
		Optional<RegisterUser> userOptional = registeruserrepo.findByEmail(user.getEmail());	
		if(userOptional.isPresent()) {
			RegisterUser user1 = userOptional.get();
			if(user1.getEmail().equalsIgnoreCase(user.getEmail())&&user1.getPassword().equalsIgnoreCase(user.getPassword())) {
				return ResponseEntity.ok("Login Successful");
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	

}
