package org.generation.ecommerce.repository;

import java.util.Optional;

import org.generation.ecommerce.model.Useer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Useer, Long>{

	Optional<Useer> findByEmail(String email);
	

}
