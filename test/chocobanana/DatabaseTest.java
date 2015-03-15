package chocobanana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.my.db.Database;
import net.my.user.InvalidAccessException;
import net.my.user.User;
import net.my.user.UserTest;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void addAndFindWhenExisted() {
		User user = UserTest.TEST_USER;
		
		Database.addUser(user);
		
		try {
			Database.checkUser(user.getUserId());
		} catch (InvalidAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User dbUser = Database.findbyId(user.getUserId());
		assertEquals(user, dbUser);
	}
	
	@Test
	public void addAndFindWhenNotExisted() {
		User dbUser = Database.findbyId("userId2");
		assertNull(dbUser);
	}
	
	

}
