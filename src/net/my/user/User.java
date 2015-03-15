package net.my.user;

import net.my.db.Database;

public class User {
	private String userId;
	private String password;
	private String email;
	
	public User(String userId, String password, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public boolean matchPassword(String newPassword) {
		return this.password.equals(newPassword);
	}
	
	public static boolean login(String userId, String password) throws UserNotFoundException , PasswordMismatchException {
		User user = Database.FindbyId(userId);
		if(user ==null) throw new UserNotFoundException();
		if(!user.matchPassword(password)){
			throw new PasswordMismatchException();
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email
				+ "]";
	}


	
}

