package ufc.crateus.web.traballho_final.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ufc.crateus.web.traballho_final.model.User;
import ufc.crateus.web.traballho_final.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<User> getUser(@Valid @PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable("id") Integer id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteUser(@Valid @PathVariable("id") Integer id) {
        if (userService.removeUser(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<User> loginUser(String email, String senha) {
    	
    	System.out.println("--> " + email + " --> " + senha);
    	
    	User user = userService.getByEmailandPassword(email, senha);
    	
    	if(user == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	if(user.getSenha().equals(senha)) {
    		return new ResponseEntity<User>(user, HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
