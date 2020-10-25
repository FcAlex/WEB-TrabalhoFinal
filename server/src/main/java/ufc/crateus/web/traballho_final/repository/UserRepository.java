package ufc.crateus.web.traballho_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufc.crateus.web.traballho_final.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM users WHERE email=?1 and senha=?2", nativeQuery = true)
	User findByEmailandPassword(String email, String senha);
}
