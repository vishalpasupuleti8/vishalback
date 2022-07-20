package com.reg.registration_new_user._service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.reg.registration_new_user._Model.UserModel;

import com.reg.registration_new_user._Repository.UserRepository;

public class UserDataservice {
	
	
	   @Autowired
	   @PersistenceContext
	   private EntityManager em;
	   
}
