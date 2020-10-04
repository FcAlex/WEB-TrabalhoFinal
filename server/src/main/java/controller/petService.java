package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.PetDbDAO;
import model.Pet;

public class petService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();
		
		if(pathInfo != null) {
			String[] params = pathInfo.split("/");
			
			if(params.length > 0) {
			
				Pet pet = PetDbDAO.getPet(Integer.parseInt(params[1])); // depos do api/user/
								
				if(pet != null) {
					JSONObject jsonObject = new JSONObject(); // cria um objeto json
					
					jsonObject.put("id", pet.getId());
					jsonObject.put("nome", pet.getNome());
					jsonObject.put("raca", pet.getRaca());
					jsonObject.put("porte", pet.getPorte());
					jsonObject.put("sexo", pet.getSexo());
					jsonObject.put("caracteristicas", pet.getCaracteristicas());
					jsonObject.put("historia", pet.getHistoria());
					jsonObject.put("Dono", pet.getUser());
					
					response.setContentType("application/json"); // informando o mime
					response.setCharacterEncoding("UTF-8"); // informando a codificacao
					response.getWriter().print(jsonObject.toString()); // com o toString tenho a string formatado no json
					response.getWriter().flush();
				}
				return;
			}
		}
	
		
		// GET ALL
		List<Pet> list = PetDbDAO.getAllPets(); // recuperar todos os elementos
		
		try {
			JSONArray jArray = new JSONArray(); // criar uma array de json
			
			for (Pet pet: list) {
				JSONObject jsonObject = new JSONObject(); // cria um objeto json
				

				jsonObject.put("id", pet.getId());
				jsonObject.put("nome", pet.getNome());
				jsonObject.put("raca", pet.getRaca());
				jsonObject.put("porte", pet.getPorte());
				jsonObject.put("sexo", pet.getSexo());
				jsonObject.put("caracteristicas", pet.getCaracteristicas());
				jsonObject.put("historia", pet.getHistoria());
				jsonObject.put("Dono", pet.getUser());
				
				// pode usar o gson para simplificar isso: https://github.com/google/gson/blob/master/UserGuide.md
				
				jArray.put(jsonObject); // adiciona no array de json's
			}
			
			response.setContentType("application/json"); // informando o mime
			response.setCharacterEncoding("UTF-8"); // informando a codificacao
			response.getWriter().print(jArray.toString()); // com o toString tenho a string formatado no json
			response.getWriter().flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}
	
}
