package com.reg.registration_new_user._Controller;


import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.reg.registration_new_user._Model.RegisterUser;

import com.reg.registration_new_user._Model.Product;
import com.reg.registration_new_user._Model.UserModel;




import com.reg.registration_new_user._Repository.RegisterUserRepository;
import com.reg.registration_new_user._Repository.UserRepository;
import com.reg.registration_new_user._service.UserService;



@RestController

@RequestMapping("/User/data")
public class UserAPI {
	
	@Autowired
	private UserRepository userrepo;
	
	
	@Autowired
	private  RegisterUserRepository registeruserrepo;
	
	
	
	
	
	@Autowired
	private UserService userservice;
	 @CrossOrigin("https://vishalfe.azurewebsites.net")
	//@CrossOrigin("http://localhost:4200/")
	@GetMapping("/new_register")
	public List<RegisterUser> getAllUser(){
		return registeruserrepo.findAll();
	}
	
	
	
	//user register
	 	@CrossOrigin("https://vishalfe.azurewebsites.net")
		//@CrossOrigin("http://localhost:4200/")
		@PostMapping( "/new_register")
		public RegisterUser createproduct(@RequestBody RegisterUser registeruser) {
			return registeruserrepo.save(registeruser);
		}
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/post")
	public UserModel createuser(@RequestBody UserModel usermodel) {
		return userrepo.save(usermodel);
	}
	
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	//@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getall")
	public List<UserModel> gett(){
		return userservice.getTotalBlogs();
}
	
	
	 private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    UserAPI(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    @GetMapping("/call")
	    public Object get() {
	        final Map<String, Object> call = jdbcTemplate.call(connection -> {
	            CallableStatement cs = connection.prepareCall("{call fetch_sample_logs (?)}");
	            cs.setString(1, "%wel%");
	            return cs;
	        }, Collections.singletonList(new SqlParameter(Types.VARCHAR)));
	        return Optional.of(call.getOrDefault("#result-set-1", Collections.emptyList()));
	    }
	}
	
	
	
	

