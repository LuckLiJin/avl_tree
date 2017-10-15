package ht;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * 二叉树的节点类
 * @author Administrator
 *
 */
public class HashNode {
	public long key;
	public String value;
	public HashNode lc;
	public HashNode rc;
	public int hight;
	public boolean deleted;
	
	/**
	 * 构造函数
	 */
	public HashNode()
	{
		key = 0;
		value = null;
		lc = null;
		rc = null;
		hight = 0;
		deleted = false;
	}
	
	/**
	 * @param k key
	 * @param v value
	 * @param p 父节点
	 */
	public HashNode(long k, String v)
	{
		key = k;
		value = v;
//		root = null;
		lc = null;
		rc = null;
		hight = 0;
		deleted = false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		if(value == null)
		{
			return key + " ''" ;
		}
		return key + " " + "'" + value + "'";
	}
	/**
	 * 按照从小到大的顺序打印二叉树
	 * @param writer  写文件的对象，如果是null则输出到屏幕上
	 * @throws IOException
	 */
	public void display(BufferedWriter writer) throws IOException
	{
		if(lc != null)
		{
			lc.display(writer);
		}
		if(writer == null)
		{
			if(!deleted)
				System.out.println(toString());
		}
		else
		{
			if(!deleted)
			{
				writer.write(toString());
	            writer.newLine();
	            writer.flush();
			}
			
		}
		
		if(rc != null)
		{
			rc.display(writer);
		}
		
	}

}
