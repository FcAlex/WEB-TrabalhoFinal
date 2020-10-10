package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DbUtil;

public class UserDbDAO {

	private static Connection connection = DbUtil.getConnection();

	public static User addUser(String email, String senha, String firstName, String lastName, String telefone, String endereco, String complemento, String cidade, String estado, String cep) { // adicionar os outros atributos
		try {
			// para persistir no banco
			String insert = "insert into users(email, senha, \"firstName\", \"lastName\", telefone, endereco, complemento, cidade, estado, cep) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, email);
			pStmt.setString(2, senha);
			pStmt.setString(3, firstName);
			pStmt.setString(4, lastName);
			pStmt.setString(5, telefone);
			pStmt.setString(6, endereco);
			pStmt.setString(7, complemento);
			pStmt.setString(8, cidade);
			pStmt.setString(9, estado);
			pStmt.setString(10, cep);
			pStmt.executeUpdate(); // alterar tabela
			// para retornar ao user
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return returnUserResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String email, String senha) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set email=?, senha=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, email);
			pStmt.setString(2, senha);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return returnUserResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = returnUserResultSet(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery(); // executar busca
			if (rs.next()) {
				return returnUserResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByEmail(String email) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where email=?");
			pStmt.setString(1, email);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return returnUserResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static User returnUserResultSet(ResultSet rs) throws SQLException {
		return new User(rs.getInt("id"), rs.getString("email"), rs.getString("senha"),
				rs.getString("firstName"), rs.getString("lastName"), rs.getString("telefone"),
				rs.getString("endereco"), rs.getString("complemento"), rs.getString("cidade"),
				rs.getString("estado"), rs.getString("cep"));
	}

	public static User getUserByLogin(String email, String senha) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where email=? and senha=?");
			pStmt.setString(1, email);
			pStmt.setString(2, senha);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return returnUserResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}