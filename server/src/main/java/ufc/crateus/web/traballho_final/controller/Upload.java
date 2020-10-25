package ufc.crateus.web.traballho_final.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ufc.crateus.web.traballho_final.util.FileUtil;

@RestController
@CrossOrigin
@RequestMapping(path = "api/upload")
public class Upload {
	
	@Value("${folder}")
	String folder;
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> uploadFile (String resource, String id, MultipartFile file) throws IOException {
		
		try {
			new FileUtil().uploadFile(file.getInputStream(), folder, resource, id);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> uploadFilePet(String resource, String id, MultipartFile file) {
		try {
			new FileUtil().uploadFile(file.getInputStream(), folder, resource, id);
        } catch (Exception e) {
        	e.printStackTrace();
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

