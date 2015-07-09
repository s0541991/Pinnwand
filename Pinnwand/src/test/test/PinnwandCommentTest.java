package test.test;

import database.PinnwandComment;
import junit.framework.TestCase;

public class PinnwandCommentTest extends TestCase {
	
	public void testPinnwandComment(){
		PinnwandComment comment1 = new PinnwandComment();
		comment1.setComment("Hallo Welt.");
		assertEquals("Hallo Welt.", comment1.getComment());
	}

}
