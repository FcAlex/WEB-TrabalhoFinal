package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.PetDbDAO;
import model.Pet;

@WebServlet("/api/pets/*") // caminho
public class PetService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);
		if(pathInfo != null) {
			String[] params = pathInfo.split("/");
			
			if(params.length > 0) {
			
				Pet pet = PetDbDAO.getPet(Integer.parseInt(params[1])); // depos do api/user/
				System.out.println(params[1]);
				if(pet != null) {
					JSONObject jsonObject = new JSONObject(); // cria um objeto json
					
					jsonObject.put("id", pet.getId());
					jsonObject.put("nome", pet.getNome());
					jsonObject.put("raca", pet.getRaca());
					jsonObject.put("porte", pet.getPorte());
					jsonObject.put("sexo", pet.getSexo());
					jsonObject.put("caracteristicas", pet.getCaracteristicas());
					jsonObject.put("historia", pet.getHistoria());
					jsonObject.put("id_user", pet.getId_User());
					
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
				jsonObject.put("id_user", pet.getId_User());
				
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

		StringBuilder jb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null) jb.append(line);
		} catch (Exception e) {
		}
		
		Pet pet = null;
		JSONObject jsonObject = null;
		
		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			System.out.println(jb.toString());
			System.out.println(jsonObject.getInt("id_user"));
			pet = PetDbDAO.addPet(jsonObject.getString("nome"), 
					jsonObject.getString("raca"), jsonObject.getString("porte"), 
					jsonObject.getString("sexo"), jsonObject.getString("caracteristicas"),
					jsonObject.getString("historia"), jsonObject.getInt("id_user"));
			System.out.println();
			// Response
			jsonObject.put("id", pet.getId());
			jsonObject.put("nome", pet.getNome());
			jsonObject.put("raca", pet.getRaca());
			jsonObject.put("porte", pet.getPorte());
			jsonObject.put("sexo", pet.getSexo());
			jsonObject.put("caracteristicas", pet.getCaracteristicas());
			jsonObject.put("historia", pet.getHistoria());
			jsonObject.put("id_user", pet.getId_User());
			
		} catch (Exception e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); // informando o mime
		response.setCharacterEncoding("UTF-8"); // informando a codificacao
		response.getWriter().print(jsonObject.toString()); // com o toString tenho a string formatado no json
		response.getWriter().flush();
	
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		if(pathInfo != null) {
			String[] params = pathInfo.split("/");
			StringBuilder jb = new StringBuilder();
			String line = null;
			
			try {
				BufferedReader reader = request.getReader();
				while((line = reader.readLine()) != null) jb.append(line);
			} catch (Exception e) {
			}
			
			Pet pet = null;
			JSONObject jsonObject = null;
			
			try {
				// Request
				jsonObject = new JSONObject(jb.toString());
				pet = PetDbDAO.updatePet(Integer.parseInt(params[1]), jsonObject.getString("nome"),jsonObject.getString("caracteristicas"));
				
				// Response
				jsonObject.put("id", pet.getId());
				jsonObject.put("nome", pet.getNome());
				jsonObject.put("raca", pet.getRaca());
				jsonObject.put("porte", pet.getPorte());
				jsonObject.put("sexo", pet.getSexo());
				jsonObject.put("caracteristicas", pet.getCaracteristicas());
				jsonObject.put("historia", pet.getHistoria());
				jsonObject.put("id_user", pet.getId_User());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			response.setContentType("application/json"); // informando o mime
			response.setCharacterEncoding("UTF-8"); // informando a codificacao
			response.getWriter().print(jsonObject.toString()); // com o toString tenho a string formatado no json
			response.getWriter().flush();
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		if(pathInfo != null) {
			String[] params = pathInfo.split("/");
			
			if(params.length > 0) {
				PetDbDAO.deletePet(Integer.parseInt(params[1]));
				response.setContentType("application/json"); // informando o mime
				response.setCharacterEncoding("UTF-8"); // informando a codificacao
				response.getWriter().flush();
			}
		}
	}
	
}


