package org.generation.ecommerce.repository;

import java.util.Optional;

import org.generation.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//dice que es un repositorio
public interface ProductRepository extends JpaRepository<Product,Long>{//herda de jpara repository la t es el tipo de tabla product, id es el tipo de dato primitivo lñong

	Optional<Product> findByName(String name);
	
}
