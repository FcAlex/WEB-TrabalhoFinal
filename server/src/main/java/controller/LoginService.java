package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

import dao.UserDbDAO;
import model.User;

@WebServlet("/api/users/login")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		User user = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			user = UserDbDAO.getUserByLogin(jsonObject.getString("email"), jsonObject.getString("senha"));
			if(user != null) {
				
				// Response
				jsonObject = new JSONObject();
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
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(jsonObject.toString());
				response.getWriter().flush();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
