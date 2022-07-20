package com.reg.registration_new_user._Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.reg.registration_new_user._Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

	@Procedure
	int gellAll(String users);
}
