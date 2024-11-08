package org.generation.ecommerce.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.generation.ecommerce.model.Product;
import org.generation.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que es un controlador pregunta de examen
@RequestMapping(path= "/api/products/")// cuando entre a localhost:8080/api/products es cuando te deja etrar
public class ProductController {
// 1er get
	//GET
	
	private final ProductService productService;//variable de product service
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;// instancia para traer
	}
	
	@GetMapping//inicializa un get, trae una lista de productos
	
	//	public ArrayList<Product> getProducts()
	public List<Product> getProducts() {
		return productService.getAllProducts();//tre todos ls productos proviene de productservice
	}//getproducts
	
	//GET para uno solo primer producto
	@GetMapping (path = "{prodId}")//local8080/api/products/1
	public Product getProduct(@PathVariable("prodId") Long prodId) {
		
		//cada uno de mis productos tiene un id;
		return productService.getProduct(prodId);
		
	}
	
	//post
	@PostMapping
	public Product addProduct(@RequestBody Product product) {//para el metodo post
		return productService.addProduct(product);//agrega un producto
		
	}
	
	//delete
	
	//GET para uno solo primer producto
	@DeleteMapping(path = "{prodId}")//local8080/api/products/1
	public Product deleteProduct(@PathVariable("prodId")Long prodId) {
		
		//cada uno de mis productos tiene un id;
		return productService.deleteProduct(prodId);
		
	}
	//PUT para productos actualizar
	/*
	@PutMapping(path="{prodId}")//localhost:8080/api/products/12?=price=70.20
	public Product updateProduct(@PathVariable("prodId")int prodId, 
			@RequestParam (required = false)String name,
			@RequestParam (required = false) String description,
			@RequestParam (required = false)String URL_image,
			@RequestParam (required = false) Double price) {
		
		return productService.updateProduct(prodId, name, description, URL_image, price);
	}
	*/
	//localhost:8080/api/products/12?=price=70.20
	@PutMapping(path="{prodId}")//update para actualizar un servicio     
	public Product updateProduct(@PathVariable("prodId")Long prodId, //aqui usas el bod es para las contraseñas
			@RequestBody Product product) {
		
		return productService.updateProduct(prodId, product.getName(),
				product.getDescription(), product.getUrl_imagen(),
				Double.valueOf(product.getPrice()));
	}
	
}//
