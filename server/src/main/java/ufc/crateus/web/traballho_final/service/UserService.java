package ufc.crateus.web.traballho_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.crateus.web.traballho_final.model.User;
import ufc.crateus.web.traballho_final.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User addUser(User user) {
		// verify user
		return userRepo.save(user);
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
	
	public User updateUser(Integer id, User user) {
		Optional<User> aux = userRepo.findById(id);
		
		if(aux.isPresent()) {
			User res = aux.get();
			res.setAll(user);
			userRepo.save(res);
			return res;
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
