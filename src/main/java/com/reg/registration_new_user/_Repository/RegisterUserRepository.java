package com.reg.registration_new_user._Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.reg.registration_new_user._Model.RegisterUser;

public interface  RegisterUserRepository extends JpaRepository<RegisterUser,Long>{
	Optional<RegisterUser> findByEmail(String email);

}
