package ufc.crateus.web.traballho_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.crateus.web.traballho_final.model.Pet;
import ufc.crateus.web.traballho_final.model.User;
import ufc.crateus.web.traballho_final.repository.PetRepository;

@Service
public class PetService {

	 @Autowired
	 PetRepository petRepo;
	    
	 public Pet addPet(String nome, String raca, String porte, String sexo, String caracteristicas, String historia, int id_user) {
	      Pet pet = new Pet(nome, raca, porte, sexo, caracteristicas, historia, id_user);
	      return petRepo.save(pet);
	 } 
	    
     public boolean removePet(Integer id) {
    	 if(petRepo.existsById(id)) {
	          petRepo.deleteById(id);
	          return true;
        }

    	 return false;
	 }
	    
	 public List<Pet> getPets() {
	     return petRepo.findAll();
	 }
	 
	 public Pet getPet(Integer id) {
	        return petRepo.findById(id).get();
	 }
	    
	
	 public Pet updatePet(int id, String nome, String raca, String porte, String sexo, String caracteristicas, String historia,
			int id_user) {
	     Pet petAux = petRepo.findById(id).get();
	        
	     if(petAux != null) {
	         petAux.setNome(nome);
	         petAux.setRaca(raca);
	         petAux.setPorte(porte);
	         petAux.setSexo(sexo);
	         petAux.setCaracteristicas(caracteristicas);
	         petAux.setHistoria(historia);
	         petAux.setId_user(id_user); //Tirar? 
	         petRepo.save(petAux);         
	     }
	        
	     return petAux;
	 }
	 
	 public List<Pet> getById_user(int id_user){
		 return petRepo.findById_user(id_user);
	 }

	public List<Pet> getPetByRaca(String nome) {
		return petRepo.findByRaca(nome);
	}
}
