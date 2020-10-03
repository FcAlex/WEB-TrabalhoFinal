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

	public static User addUser(String email, String password) { // adicionar os outros atributos
		try {
			// para persistir no banco
			PreparedStatement pStmt = connection.prepareStatement("insert into users(email, password) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, email);
			pStmt.setString(2, password);
			pStmt.executeUpdate(); // alterar tabela
			// para retornar ao user
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String email, String password) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set email=?, password=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, email);
			pStmt.setString(2, password);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
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
				User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
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
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
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
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}