package net.my.user;

import static org.junit.Assert.*;
import net.my.db.Database;

import org.junit.Test;

public class UserTest {

	public static User TEST_USER = new User("userId","password","javajigi@slipp.net");

	@Test
	public void matchPassword() {
		assertTrue(TEST_USER.matchPassword("password"));
	}

	@Test
	public void notMatchPassword() {
		assertFalse(TEST_USER.matchPassword("password2"));
	}
	
	@Test
	public void signUp() throws Exception {
		User user =  new User("userId2","password","javajigi@slipp.net");
		assertTrue(User.signUp(user));
	}
	
	@Test(expected=UserFoundException.class)
	public void signUpWhenExistedUser() throws Exception {
		User user =  new User("userId2","password","javajigi@slipp.net");
		Database.addUser(user);	
		User.signUp(user);
	}
	
	@Test
	public void login() throws Exception {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		assertTrue(User.login(TEST_USER.getUserId(), TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception {
		User.login("userId2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPasswordMismatch() throws Exception {
		User user = UserTest.TEST_USER;
		Database.addUser(user);		
		User.login(TEST_USER.getUserId(), "password2");
	}
	
}
