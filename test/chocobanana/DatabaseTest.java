package chocobanana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.my.db.Database;
import net.my.user.User;
import net.my.user.UserTest;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void addAndFindWhenExisted() {
		User user = UserTest.TEST_USER;
		
		Database.addUser(user);
		
		Database.CheckUser(user.getUserId());
		User dbUser = Database.FindbyId(user.getUserId());
		assertEquals(user, dbUser);
	}
	
	@Test
	public void addAndFindWhenNotExisted() {
		User dbUser = Database.FindbyId("userId2");
		assertNull(dbUser);
	}
	
	

}
