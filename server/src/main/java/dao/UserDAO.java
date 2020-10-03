package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	User getUser(int id);
	User getUserByEmail(String login);
	List<User> getAllUsers();
	User addUser(String login, String password);
	User updateUser(int id, String login, String password);
	void deleteUser(int id);
	User getUserByLogin(String login, String password);
}
