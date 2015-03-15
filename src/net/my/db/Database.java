package net.my.db;

import java.util.HashMap;
import java.util.Map;

import net.my.user.User;

public class Database {
	private static Map<String, User> users = new HashMap<String, User>();

	public static void addUser(User user) {
		users.put(user.getUserId(), user);	
	}
	
	public static User show(String userId) {
		User user = users.get(userId);
		return user;
	}
	
	public static boolean CheckUser(String userId) {
		return users.containsKey(userId);
	}
	
	public static void modify(User user) {
		users.replace(user.getUserId(), user);
	}
}
