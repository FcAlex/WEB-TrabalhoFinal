package ufc.crateus.web.traballho_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufc.crateus.web.traballho_final.model.Pet;
import ufc.crateus.web.traballho_final.model.User;
import ufc.crateus.web.traballho_final.repository.PetRepository;
import ufc.crateus.web.traballho_final.repository.UserRepository;

@Service
public class UserService {
	
	//@Autowired
	UserRepository userRepo;
	PetRepository petRepo;
	
	@Transactional
	public User addUser(User user) {
		// verify user
		
//		for(int i=0;i<user.getPets().size();i++) {
//			System.out.println(user.getPets().get(i).getId());
//			Pet savedPet = petRepo.save(user.getPets().get(i));
//			if(!petRepo.findById(savedPet.getId()).isPresent()) {
//				System.out.println("error");
//				return null;
//			}
				
	//	}
		User savedUser =  userRepo.save(user);
		if(userRepo.findById(savedUser.getId()).isPresent()) {
			System.out.println("Aqui");
			return savedUser;
		}else {
			System.out.println("aqui n");
			return null;
		}
			
			
	}
	
	public UserService(UserRepository userRepo, PetRepository petRepo) {
		super();
		this.userRepo = userRepo;
		this.petRepo = petRepo;
	}

	public boolean removeUser(Integer id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	public User getUser(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) return user.get();
		return null;
	}
	
	@Transactional
	public User updateUser(Integer id, User user) {
		Optional<User> aux = userRepo.findById(id);
		
		if(aux.isPresent()) {
			User res = aux.get();
			res.setAll(user);
//			for(int i=0;i<res.getPets().size();i++) { 
//				Pet savedPet = petRepo.save(res.getPets().get(i));
//				if(!petRepo.findById(savedPet.getId()).isPresent()) {
//					System.out.println("error");
//					return null;
//				}
//					
			//}
			
			return userRepo.save(res);
		}
		
		return null;
	}

	public User getByEmailandPassword(String email, String senha) {
		if(email == null || senha == null) {
			return null;
		}
		return userRepo.findByEmailandPassword(email, senha);
	}
}
