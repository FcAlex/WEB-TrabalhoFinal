package ufc.crateus.web.traballho_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ufc.crateus.web.traballho_final.model.Pet;
import ufc.crateus.web.traballho_final.service.PetService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/pets")
public class PetController {
	 
		@Autowired
	    PetService petService;
	 
	    @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Pet>> getPets() {
	        return new ResponseEntity<List<Pet>>(petService.getPets(), HttpStatus.OK);
	    }
	 
	    @RequestMapping(method = RequestMethod.GET, value = "{id}")
	    public ResponseEntity<Pet> getPet(@PathVariable("id") Integer id) {
	        return new ResponseEntity<Pet>(petService.getPet(id), HttpStatus.OK);
	    }
	    
//	    @RequestMapping(method = RequestMethod.GET, value = "/search")
//	    public ResponseEntity<Pet> getPetByLogin(@RequestParam("login") String login) {
//	        return new ResponseEntity<Pet>(petService.getPetByLogin(login), HttpStatus.OK);
//	    }
//	 
	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
	        return new ResponseEntity<Pet>(petService.addPet(pet.getNome(), pet.getRaca(),pet.getPorte(), pet.getSexo(), 
	        		pet.getCaracteristicas(), pet.getHistoria(), pet.getUser()), HttpStatus.OK);
	    } 
	  
	    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
	    public ResponseEntity<Pet> updatePet(@PathVariable("id") Integer id, @RequestBody Pet pet) {
	        return new ResponseEntity<Pet>(petService.updatePet(id, pet.getNome(), pet.getRaca(),pet.getPorte(), pet.getSexo(), 
	        		pet.getCaracteristicas(), pet.getHistoria(), pet.getUser()), HttpStatus.OK);
	    }
//	 
	    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	    public ResponseEntity<Void> deletePet(@PathVariable("id") Integer id) {
	        if (petService.removePet(id)) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        }
	 
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
}
