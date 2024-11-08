package org.generation.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.generation.ecommerce.model.Product;
import org.generation.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//indica al servidor que es un servicio y se crea antes que cualquier controlador 
public class ProductService {
	public final ProductRepository productRepository;
	
	@Autowired//enlaza o auto llega con el servidor
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;//tiene que estar reasingado
	
	}//constructor vacio. 
	
	public List<Product> getAllProducts() { //aqui iba el array list
		// TODO Auto-generated method stub//return list;//tiene que regresar lalista
		return productRepository.findAll();
	}

	public Product getProduct(Long prodId) {
		return productRepository.findById(prodId).orElseThrow(
					()-> new IllegalArgumentException("El producto con el id ["+
							prodId+ "]no existe")//solo se ve en la consola el mensaje
				);//conversion inplicita de un option que lanza una exeption
	}

	public Product deleteProduct(Long prodId) {
		Product tmpProduct=null;
		if(productRepository.existsById(prodId)) {
			tmpProduct= productRepository.findById(prodId).get();//trae el producto
			productRepository.deleteById(Long.valueOf(prodId));
		}// inf
		return  tmpProduct;
	}
	
	public Product addProduct(Product product) {//tienes que tener el constructor vacio para llamarlo
		Optional<Product> tmpProduct= productRepository.findByName(product.getName());
		if(tmpProduct.isEmpty()) {
			return productRepository.save(product);
		}else {
			System.out.println("ya existe el producto con el nombre["
					+ product.getName() + "]");
			return null;
		}
		
	}


	//te permite modificar todos los datos o uno cualquiera
	public Product updateProduct(Long prodId, String name, String description, String uRL_image, Double price) {
		Product product=null;
		if(productRepository.existsById(prodId)) {
			product= productRepository.findById(prodId).get();//trae el producto
			if(name.length()!=0) product.setName(name);				
			if(description.length()!=0) product.setDescription(description);	
			if(uRL_image.length()!=0) product.setUrl_imagen(uRL_image);
			if(price.doubleValue()>0) product.setPrice(price);//menor a cero logintud	
			productRepository.save(product);
		}
		return  product;
	}
	
	
	
}
