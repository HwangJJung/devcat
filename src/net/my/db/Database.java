package net.my.db;

import java.util.HashMap;
import java.util.Map;

import net.my.user.InvalidAccessException;
import net.my.user.User;
import net.my.user.UserNotFoundException;

public class Database {
	private static Map<String, User> users = new HashMap<String, User>();

	public static void addUser(User user) {
		users.put(user.getUserId(), user);	
	}
	
	public static User show(String userId) {
		User user = users.get(userId);
		return user;
	}
	
	public static boolean checkUser(String userId) throws InvalidAccessException  {
		if(userId == null) throw new InvalidAccessException();
		return users.containsKey(userId);
	}
	
	public static void modify(User user) {
		users.replace(user.getUserId(), user);
	}

	public static User findbyId(String userId)  {
		return users.get(userId);
	}
	
	public static User modifyParsebyId(String userId) throws InvalidAccessException  {
		
		if(userId == null) throw new InvalidAccessException();
			User user = findbyId(userId);
		return user;
	}
}
