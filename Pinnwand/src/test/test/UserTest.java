package test.test;

import database.UserDBHandler;
import junit.framework.TestCase;


/*public class UserTest extends TestCase {
	//==========funktionierender Junit test
	public void testUser(){
		User user1 = new User();
		user1.setbDay("bDay");
		assertEquals("bDay", user1.getbDay());
	}
}*/


//==============Android test fehlgeschlagen============
public class UserTest extends TestCase {
	UserDBHandler userDB;
		@Override
	protected void setUp() throws Exception {
		super.setUp();
//		Context context = new Context
//		User testUser = new User("username","password","email","firstname","lastname","bday","country");
//		
//		userDB = new UserDBHandler(context);
//		userDB.addUser(testUser);
	}

}
