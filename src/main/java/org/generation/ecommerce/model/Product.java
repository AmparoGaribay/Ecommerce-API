package org.generation.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//pojo plan old java object 
@Entity//para definir ques una entidad. java. persistence
@Table(name = "producto")//para nombrar la tabla en la base de datos TEN CUIDADO EN EL NOMBRE DE TABLA. ASI ES  COMO SE VERA LA ENTIDAD EN LA

public class Product {
	@Id//define como un id en la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY)///indica que es unico y auto incremental
	@Column(name="id", unique = true, nullable = false )//indica que es unico y nullo 
	private Long id; //para agregar el id ponlo long para que no de eerror
	@Column(nullable = false )//permite hacer cambios a la columna
	private String name;
	@Column(nullable = false )
	private	String description;
	private	String url_imagen;
	private	double price;

	//private static int total=0;// para
	
//debellevar
	//constructror using fields
		//constructor 1.1 vacio o emty<- se relaciona con el metodo post 
		//getters and setters
		//to string:

	public Product(String name, String descripcion, String url_imagen, double price) {
		super();
		this.name = name;
		this.description = descripcion;
		this.url_imagen = url_imagen;
		this.price = price;
		//ya no debe estar cuando conectemos para base de datos
		//Product.total++;
		//id=Product.total;
	}//constructor
	public Product() {

		//Product.total++;
		//id=Product.total;
	} //constructor vacio
	
	/*
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}*/
	public Long getId() {//ponlelong
		return id;
	}

	public String getName() {
		return name;
	}//get
	public void setName(String name) {
		this.name = name;
	}//set

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}
	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}
	public double getPrice() {
		return price;
	}//get
	public void setPrice(double price) {
		this.price = price;
	}//set
	@Override
	public String toString() {
		return "Product [name=" + name + ", descripcion=" + description + ", url_imagen=" + url_imagen + ", price="
				+ price + ", id=" + id + "]";
	}

	
	
	
	
	
		
		
	
}
