package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pet;
import model.User;
import util.DbUtil;

public class PetDbDAO implements PetDAO{
	
	private static Connection connection = DbUtil.getConnection();

	

	@Override
	public static Pet addPet(String nome, String raca, String porte, String sexo, String caracteristicas, String historia,
			User user) {
		
		try {
			String insert = "insert into pets(nome, raca, porte, caracteristicas, historia, user_id) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, nome);
			pStmt.setString(2, raca);
			pStmt.setString(3, porte);
			pStmt.setString(4, caracteristicas);
			pStmt.setString(5, historia);
			pStmt.setInt(6, user.getId());
			
			pStmt.executeUpdate(); // alterar tabela
			// para retornar ao user
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return returnPetResultSet(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Pet updatePet(int id, String nome, String caracteristicas) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update pets set nome=?, caracteristicas=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nome);
			pStmt.setString(2, caracteristicas);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return returnPetResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public static Pet getPet(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from pets where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery(); // executar busca
			if (rs.next()) {
				return returnPetResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public static List<Pet> getAllPets() {
		List<Pet> pets = new ArrayList<Pet>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from pets order by id");
			while (rs.next()) {
				Pet pet = returnPetResultSet(rs);
				pets.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pets;
	}
	

	@Override
	public void deletePet(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from pets where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Pet returnPetResultSet(ResultSet rs) throws SQLException {
		return new Pet(rs.getInt("id"), rs.getString("nome"), rs.getString("raca"),
				rs.getString("porte"), rs.getString("sexo"), rs.getString("caracteristicas"),
				rs.getString("historia"), (User) rs.getObject("users_id"));  //Pegando objeto?
	}

}
