package com.reg.registration_new_user._Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reg.registration_new_user._Model.Product;
import com.reg.registration_new_user._Repository.ProductRepository;
import com.reg.registration_new_user._service.BlobStorageService;
import com.reg.registration_new_user.exception.ResourceNotFoundException;

 @RestController
@RequestMapping("/Products/Data/")
public class ProductAPI {
	 
	 @Autowired
	    BlobStorageService blobStorageService;
	@Autowired
	private ProductRepository productrepository;
	
	//Get All Products
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@GetMapping("/products")
	public List<Product> getAllproducts(){
		return productrepository.findAll();
	}
	//Add Product
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@PostMapping( "/products")
	public Product createproduct(@RequestBody Product product) {
		return productrepository.save(product);
	}
	//Get product by Id 
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		
		Product product = productrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Does not Exist with Id :" + id));
		return ResponseEntity.ok(product);
	}
	//Update Product
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Does not Exist with Id :" + id));
		product.setProductname(productDetails.getProductname());
		product.setQuantity(productDetails.getQuantity());
		product.setDescription(productDetails.getDescription());
		Product updateProduct = productrepository.save(product);
		return ResponseEntity.ok(updateProduct);
	}
	//Delete Product
	//@CrossOrigin("http://localhost:4200/")
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@DeleteMapping("/products/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Does not Exist with Id :" + id));
		productrepository.delete(product);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
    //To Upload Images
	@CrossOrigin("https://vishalfe.azurewebsites.net")
	@PostMapping("/upload")
    public void uploadFiles(@RequestParam("file") MultipartFile file) throws IOException {
       blobStorageService.uploadFiles(file);

    }
}
