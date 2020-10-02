package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

public class UserDAO {
	private static final Map<Integer, User> userMap = new HashMap<Integer, User>();
	private static int i = 4;
	
	static {
		initUsers();
	}
	
	private static void initUsers() {
		User user1 = new User(1, "alex@gmail.com", "123", "Alex", "Sousa", "88999357058", "Rua dos gaiatos, nr. 512, bairro Boa Nova",
				"Apt 01", "Independencia", "CE", "63640-000");
		User user2 = new User(2, "joao@gmail.com", "165453");
		User user3 = new User(3, "lucas@gmail.com", "12445");
		
		userMap.put(user1.getId(), user1);
		userMap.put(user2.getId(), user2);
		userMap.put(user3.getId(), user3);
	}
	
	public static User getUser(int id) {
		return userMap.get(id);
	}
	
	public static User getUserByEmail(String login) {
		for (User user : getAllUsers()) {
			if(user.getEmail().equals(login)) return user;
		}
		
		return null;
	}
	
	public static List<User> getAllUsers() {
		return new ArrayList<User>(userMap.values());
	}
	
	public static User addUser(String login, String password) {
		User user = new User(i, login, password);
		userMap.put(user.getId(), user);
		i++;
		return user;
	}
	
	public static User updateUser(int id, String login, String password) {
		User user = new User(id, login, password);
		userMap.put(user.getId(), user);
		return user;
	}
	
	public static void deleteUser(int id) {
		if(userMap.containsKey(id)) {
			userMap.remove(id);
		}
	}

	public static User getUserByLogin(String login, String password) {
		List<User> list = getAllUsers();

		for (User user : list) {
			if (user.getEmail().equals(login) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}
}
