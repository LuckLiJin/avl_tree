/**
 * 
 */
package ht;

/**
 * @author Administrator
 *
 */
public class MainTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		long startTime=System.currentTimeMillis();
		bst.read_file("data.db");
		long endTime=System.currentTimeMillis(); 
		System.out.println("Read data.db cost time  "+(endTime-startTime)+"  ms");
		//因为insert操作是更新，所以两次读取的时候就相当于满足了题目中修改值的要求
		bst.read_file("modified.db");
		startTime=System.currentTimeMillis();
		System.out.println("Read modified.db cost time  "+(startTime - endTime)+"  ms");
		bst.write_file("my-final.db");
		endTime=System.currentTimeMillis(); 
		System.out.println("Write my-final.db cost time  "+(endTime-startTime)+"  ms");
		

	}

}
