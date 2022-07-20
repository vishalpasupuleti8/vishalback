package com.reg.registration_new_user._service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reg.registration_new_user._Model.UserModel;
import com.reg.registration_new_user._Repository.UserRepository;




@Service
public class UserService {
	
	@Autowired
	   private UserRepository userRepo;
	
	
	
	   @Autowired
	   @PersistenceContext
	   private EntityManager em;
	   
	public List<UserModel>  getTotalBlogs(){
	       return em.createNamedStoredProcedureQuery("gellAll").getResultList();
	   }
	   
	public List<UserModel>  getBlogsByTitle(String title) {
	       return em.createNamedStoredProcedureQuery("getBlogsByTitle").setParameter("tblogTitle",title).getResultList();
	   }
	
}

