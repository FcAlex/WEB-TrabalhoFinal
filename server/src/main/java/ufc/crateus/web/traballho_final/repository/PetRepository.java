package ufc.crateus.web.traballho_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ufc.crateus.web.traballho_final.model.Pet;


public interface PetRepository extends JpaRepository<Pet, Integer> {

	@Query(value = "SELECT * FROM pets WHERE id_user=?", nativeQuery = true)
	List<Pet> findById_user(Integer id_user);
	
	@Query(value = "SELECT * FROM pets WHERE raca=?1", nativeQuery = true)
	List<Pet> findByRaca(String raca);
}
