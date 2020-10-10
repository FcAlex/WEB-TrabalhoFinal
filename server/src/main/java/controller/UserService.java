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

import dao.UserDbDAO;
import model.User;

@WebServlet("/api/users/*") // caminho
public class UserService extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();
		
		if(pathInfo != null) {
			String[] params = pathInfo.split("/");
			
			if(params.length > 0) {
			
				User user = UserDbDAO.getUser(Integer.parseInt(params[1])); // depos do api/user/
								
				if(user != null) {
					JSONObject jsonObject = new JSONObject(); // cria um objeto json
					
					jsonObject.put("id", user.getId());
					jsonObject.put("email", user.getEmail());
					jsonObject.put("senha", user.getSenha());
					jsonObject.put("firstName", user.getFirstName());
					jsonObject.put("lastName", user.getLastName());
					jsonObject.put("telefone", user.getTelefone());
					jsonObject.put("endereco", user.getEndereco());
					jsonObject.put("complemento", user.getComplemento());
					jsonObject.put("cidade", user.getCidade());
					jsonObject.put("estado", user.getEstado());
					jsonObject.put("cep", user.getCep());
					
					response.setContentType("application/json"); // informando o mime
					response.setCharacterEncoding("UTF-8"); // informando a codificacao
					response.getWriter().print(jsonObject.toString()); // com o toString tenho a string formatado no json
					response.getWriter().flush();
				}
				return;
			}
		}
		
		//GET BY NAME
		if(request.getParameter("login") != null) {
			User user = UserDbDAO.getUserByEmail(request.getParameter("login"));
			
			if(user != null) {
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("id", user.getId());
				jsonObject.put("email", user.getEmail());
				jsonObject.put("senha", user.getSenha());
				jsonObject.put("firstName", user.getFirstName());
				jsonObject.put("lastName", user.getLastName());
				jsonObject.put("telefone", user.getTelefone());
				jsonObject.put("endereco", user.getEndereco());
				jsonObject.put("complemento", user.getComplemento());
				jsonObject.put("cidade", user.getCidade());
				jsonObject.put("estado", user.getEstado());
				jsonObject.put("cep", user.getCep());
				
				response.setContentType("application/json"); // informando o mime
				response.setCharacterEncoding("UTF-8"); // informando a codificacao
				response.getWriter().print(jsonObject.toString()); // com o toString tenho a string formatado no json
				response.getWriter().flush();
			}
			return;
		}
		
		
		// GET ALL
		List<User> list = UserDbDAO.getAllUsers(); // recuperar todos os elementos
		
		try {
			JSONArray jArray = new JSONArray(); // criar uma array de json
			
			for (User user : list) {
				JSONObject jsonObject = new JSONObject(); // cria um objeto json
				
				jsonObject.put("id", user.getId());
				jsonObject.put("email", user.getEmail());
				jsonObject.put("senha", user.getSenha());
				jsonObject.put("firstName", user.getFirstName());
				jsonObject.put("lastName", user.getLastName());
				jsonObject.put("telefone", user.getTelefone());
				jsonObject.put("endereco", user.getEndereco());
				jsonObject.put("complemento", user.getComplemento());
				jsonObject.put("cidade", user.getCidade());
				jsonObject.put("estado", user.getEstado());
				jsonObject.put("cep", user.getCep());
				
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
		
		User user = null;
		JSONObject jsonObject = null;
		
		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			user = UserDbDAO.addUser(jsonObject.getString("email"), 
					jsonObject.getString("senha"), jsonObject.getString("firstName"), 
					jsonObject.getString("lastName"), jsonObject.getString("telefone"),
					jsonObject.getString("endereco"), jsonObject.getString("complemento"), 
					jsonObject.getString("cidade"), jsonObject.getString("estado"), 
					jsonObject.getString("cep"));
			
			// Response
			jsonObject.put("id", user.getId());
			jsonObject.put("email", user.getEmail());
			jsonObject.put("senha", user.getSenha());
			jsonObject.put("firstName", user.getFirstName());
			jsonObject.put("lastName", user.getLastName());
			jsonObject.put("telefone", user.getTelefone());
			jsonObject.put("endereco", user.getEndereco());
			jsonObject.put("complemento", user.getComplemento());
			jsonObject.put("cidade", user.getCidade());
			jsonObject.put("estado", user.getEstado());
			jsonObject.put("cep", user.getCep());
			
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
			
			User user = null;
			JSONObject jsonObject = null;
			
			try {
				// Request
				jsonObject = new JSONObject(jb.toString());
				user = UserDbDAO.updateUser(Integer.parseInt(params[1]),jsonObject.getString("login"), jsonObject.getString("senha"));
				
				// Response
				jsonObject.put("id", user.getId());
				jsonObject.put("email", user.getEmail());
				jsonObject.put("senha", user.getSenha());
				jsonObject.put("firstName", user.getFirstName());
				jsonObject.put("lastName", user.getLastName());
				jsonObject.put("telefone", user.getTelefone());
				jsonObject.put("endereco", user.getEndereco());
				jsonObject.put("complemento", user.getComplemento());
				jsonObject.put("cidade", user.getCidade());
				jsonObject.put("estado", user.getEstado());
				jsonObject.put("cep", user.getCep());
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
				UserDbDAO.deleteUser(Integer.parseInt(params[1]));
				response.setContentType("application/json"); // informando o mime
				response.setCharacterEncoding("UTF-8"); // informando a codificacao
				response.getWriter().flush();
			}
		}
	}

}
