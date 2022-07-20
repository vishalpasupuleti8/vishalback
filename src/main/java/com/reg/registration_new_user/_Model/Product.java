package com.reg.registration_new_user._Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ProductData")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "productname")
	private String productname;
	@Column(name = "Quantity")
	private int Quantity;
	@Column(name = "Description")
	private String Description;
	public Product() {
	
	}
	public Product( String Productname, int Quantity, String Description,int Price,String Warehousename ) {
		super();
		
		this.productname = Productname;
		this.Quantity = Quantity;
		this.Description = Description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	

	
}
