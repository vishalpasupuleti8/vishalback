package com.reg.registration_new_user._Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "reg_user_demo")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "gellAll",procedureName = "gellAll"),
@NamedStoredProcedureQuery(name = "getBlogsByTitle", procedureName = "getBlogsByTitle", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "tblogTitle",type=String.class)} )})
public class UserModel {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String full_name;
	
	@Column
	private String email;
	
	@Column
	private int mob_no;
	
	@Column
	private String password;
	
	@Column
	private String work_status;
	
	public UserModel() {}

	public UserModel(long id, String full_name, String email, int mob_no, String password, String work_status) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.email = email;
		this.mob_no = mob_no;
		this.password = password;
		this.work_status = work_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMob_no() {
		return mob_no;
	}

	public void setMob_no(int mob_no) {
		this.mob_no = mob_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	
	

}
