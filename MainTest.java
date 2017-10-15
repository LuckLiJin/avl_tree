package ht;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Administrator
 * 用户操作类
 */
public class MainTest {
	/**
	 * 打印操作菜单
	 */
	public static void menu()
	{
		System.out.println("\t\t The main operating menu :");
		System.out.println("\t (a)dd a key-value");
		System.out.println("\t (d)elete a key-value");
		System.out.println("\t (l)oad data by file");
		System.out.println("\t (s)ave data to file");
		System.out.println("\t (q)uery a key-value");
		System.out.println("\t (p)rint all key-value:");
		System.out.println("\t (e)xit.");
	}
	/**
	 * 获取用户的选择
	 * @return  命令字符
	 */
	public static char get_choose()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input your choose:");
		String ch;
		while(true)
		{
			 ch = in.nextLine();
			if(ch.length() > 0)
			{
				break;
			}
		}
//		in.
//		in.close();
		return  ch.charAt(0);
	}
	/**
	 * 向bst二叉树中新增一个元素
	 * @param bst 操作对象
	 */
	public static void add(BinaryTree bst)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the 'key':");
		long key = in.nextLong();
		System.out.print("Please input the 'value':");
		String value = in.next();
		boolean res = bst.insert(key, value);
		if(res)
		{
			System.out.println("Insert succeed!");
		}
		else
		{
			System.out.println("Insert failed!");
		}
//		in.close();
	}
	/**
	 * 查询操作
	 * @param bst 操作对象
	 */
	public static void query(BinaryTree bst)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the 'key':");
		long key = in.nextLong();
		System.out.println(bst.query(key));
//		in.close();
	}
	/**
	 * 删除操作
	 * @param bst 操作对象
	 */
	public static void del(BinaryTree bst)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the 'key':");
		long key = in.nextLong();
		if(bst.delete(key))
		{
			System.out.println("succeed!");
		}
		else
		{
			System.out.println("failed!");
		}
//		in.close();
	}
	/**
	 * 从文件中加载数据
	 * @param bst 操作对象
	 */
	public static void load(BinaryTree bst)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input data file's name:");
		String filename = in.nextLine();
		if(bst.read_file(filename))
		{
			System.out.println("succeed! table size is " + bst.size());
		}
		else
		{
			System.out.println("failed!");
		}
//		in.close();
	}
	/**
	 * 将二叉树中的数据写出到文件中
	 * @param bst 操作对象
	 */
	public static void pull(BinaryTree bst)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the output file's name:");
		String filename = in.nextLine();
		if(bst.write_file(filename))
		{
			System.out.println("succeed!");
		}
		else
		{
			System.out.println("failed!");
		}
		in.close();
	}
	public static void main(String[] args) {
		
		BinaryTree bst = new BinaryTree();
		
		while(true)
		{
			menu();
			switch(get_choose())
			{
			case 'a':
				add(bst);
				break;
			case 'd':
				del(bst);
				break;
			case 'l':
				load(bst);
				break;
			case 's':
				pull(bst);
				break;
			case 'q':
				query(bst);
				break;
			case 'p':
				try {
				bst.display();
				}
				catch (IOException e)
				{
					System.out.println("error.");
				}
				break;
			case 'e':
				System.out.println("exit successful!");
				return;
			default:
				System.out.println("Invaild command!");
			}
		}
		
	}

}
