/**
 * 
 */
package ht;
import java.io.IOException;
import java.util.Random;
/**
 * @author Administrator
 *	性能演示
 */
public class MainTest2 {

	/**
	 * 最坏情况下的插入测试
	 * @throws IOException 
	 */
	public static void badInsert() throws IOException
	{
		long startTime=System.currentTimeMillis(); 
		BinaryTree bst = new BinaryTree();
		for(long i = 10000; i > 0; i--)
		{
			bst.insert(i, "test->"+i);
//			System.out.println("current size is " + bst.size());
		}
//		bst.display();
		long endTime=System.currentTimeMillis(); 
		System.out.println("1 : The worst case insert operation test： "+(endTime-startTime)+"  ms");
	}
	/**
	 * 一般情况下插入性能测试
	 */
	public static void bestInsert()
	{
		Random rand = new Random();
		long startTime=System.currentTimeMillis(); 
		BinaryTree bst = new BinaryTree();
		bst.insert(0, "fdsa");
		for(long i = 1; i <10000; i++)
		{
			bst.insert(rand.nextLong(), "test->"+i);
			
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println("2 : The best case insert operation test： "+(endTime-startTime)+"  ms");
	}
	/**
	 * 最坏删除情况
	 */
	public static void badDelete()
	{
		
		BinaryTree bst = new BinaryTree();
		for(long i = 10000; i > 0; i--)
		{
			bst.insert(i, "test->"+i);
		}
		long startTime=System.currentTimeMillis(); 
		for(long i = 0; i < 10000; i++)
		{
			bst.delete(i);
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println("3 : The worst case delete operation test： "+(endTime-startTime)+"  ms");
	
	}
	/**
	 * 最好删除情况
	 */
	public static void bestDelete()
	{
		
		BinaryTree bst = new BinaryTree();
		for(long i = 10000; i > 0; i--)
		{
			bst.insert(i, "test->"+i);
		}
		long startTime=System.currentTimeMillis(); 
		for(long i = 10000; i > 0; i--)
		{
			bst.delete(i);
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println("4 : The best case delete operation test： "+(endTime-startTime)+"  ms");
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		badInsert();
		bestInsert();
		badDelete();
		bestDelete();
	}

}
