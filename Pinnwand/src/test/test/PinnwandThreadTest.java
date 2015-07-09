package test.test;

import database.PinnwandThread;
import junit.framework.TestCase;

public class PinnwandThreadTest extends TestCase {
	
	int test = 32;
	public void testPinnwandThread(){
		PinnwandThread pt1 = new PinnwandThread();
		pt1.settId(test);
		pt1.setName("Th");
		pt1.setUserId(1);
		assertEquals("Th", pt1.getName());
	}
}
