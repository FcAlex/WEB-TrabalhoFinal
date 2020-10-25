package ufc.crateus.web.traballho_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufc.crateus.web.traballho_final.model.Pet;


public interface PetRepository extends JpaRepository<Pet, Integer> {

}
