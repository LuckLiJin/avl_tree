/**
 * 
 */
package ht.test;
import ht.HashNode;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class HashNodeTest {

	@Test
	public void testHashNode() {
		HashNode hn = new HashNode();
		assertEquals(0, hn.key);
	}
	@Test
	public void testHashNodeIntString() {
		HashNode hn = new HashNode(1, "test");
		assertEquals(1, hn.key);
		assertEquals("test", hn.value);
	}
	@Test
	public void testDisplay() {
		HashNode hn = new HashNode(1, "test");
		try {
			hn.display(null);
		}
		catch (IOException e)
		{
			
		}
		
	}
	
}
