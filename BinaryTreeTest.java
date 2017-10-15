/**
 * 
 */
package ht.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ht.BinaryTree;
import ht.HashNode;

/**
 * @author Administrator
 *
 */
public class BinaryTreeTest {

	@Test
	public void testInsert() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		
		assertEquals(10, bst.size());
	}
	@Test
	public void testDelete() {
		System.out.println("-------------test delete-------------------");
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}		
			
		for(int i = 0; i < 10; i++)
		{
			System.out.println("-->delete key " + i);
			bst.delete(i);
			try {
			bst.display();
			}
			catch (IOException e)
			{
				
			}
			System.out.println("--------------------------------");
//			break;
		}
		
		assertEquals(0, bst.size());
	}
	@Test
	public void testDisplay() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		try
		{
			bst.display();
		}
		catch (IOException e)
		{
			
		}
		
	}
	@Test
	public void testQuery() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		
		HashNode hn = bst.query(9);
		assertEquals(9, hn.key);
		assertEquals("test--->9", hn.value);
	}
	@Test
	public void testRead() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		assertEquals(10, bst.size());
		bst.write_file("lijin.txt");
		bst.read_file("lijin.txt");
		assertEquals(10, bst.size());
	}
	@Test
	public void testSize() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		assertEquals(10, bst.size());
	}
	@Test
	public void testWrite() {
		BinaryTree bst = new BinaryTree();
		for(int i = 0; i < 10; i++)
		{
			bst.insert(i, "test--->" + i);
		}
		assertEquals(10, bst.size());
		bst.write_file("test.txt");
	}
}
