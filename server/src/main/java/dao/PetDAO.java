package dao;

import java.util.List;

import model.Pet;
import model.User;


public interface PetDAO {
	
	Pet getPet(int id); 
	List<Pet> getAllPets(); 
	Pet addPet(String nome, String raca, String porte, String sexo, String caracteristicas, String historia, User user); //Adicionar um pet precisa de um username/login de um user
	Pet updatePet(int id, String nome, String caracteristicas);
	void deletePet(int id);
	
}
