package ht;

import java.io.BufferedWriter;
import java.io.File;
import java.io.Reader;


import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Administrator
 *二叉排序树的实现类
 */
public class BinaryTree {
	
	private HashNode root = null;
	private int cnt = 0;

	public BinaryTree() {
		cnt = 0;
		root = null;
	}
	
	
	/**
	 * @param n 节点
	 * @return 返回树的高度
	 */
	private int height(HashNode n)
	{
		return n == null ? -1 : n.hight;
	}
	
	/**
	 * @param k 键值
	 * @param v 值
	 * @return 成功, 重复插入表示覆盖或者修改
	 */
	public boolean insert(long k, String v)
	{
		root = insert(root,  k,  v);
		return true;
	}
	
	/**
	 * @param key 被删除的key值
	 * @return 是否删除成功
	 */
	public boolean delete(long key) {
		if (root == null) {
			return false;
		} else {
			HashNode curr = root;
			while (curr != null) {
				if (curr.key > key) {
					curr = curr.lc;
				} else if (curr.key < key) {
					curr = curr.rc;
				} else if (curr.key == key) {
					if(curr.deleted)
					{
						return false;
					}
					else
					{
						curr.deleted = true;
						cnt--;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	

	
	/**
	 * @param t 插入节点
	 * @param k 键
	 * @param v 值
	 * @return 插入后的树
	 */
	private HashNode insert(HashNode t, long k, String v)
	{
		if(t == null)
		{
			cnt++;
			return new HashNode(k, v);
		}
		
		long cmp = k - t.key;
		
		if(cmp < 0)
		{
			t.lc = insert(t.lc, k, v);
			if((height(t.lc) - height(t.rc)) == 2)
			{
				long tmp = k - t.lc.key;
				
				if(tmp < 0)
				{
					t = l_rotate(t);
				}
				else
				{
					t = dlr_rotate(t);
				}
			}
		}
		else if(cmp > 0)
		{
			t.rc = insert(t.rc, k, v);
			if((height(t.rc) - height(t.lc)) == 2 )
			{
				long tmp = k - t.rc.key;
				if(tmp > 0)
				{
					t = r_rotate(t);
				}
				else
				{
					t = drl_rotate(t);
				}
			}
		}
		else
		{
			t.value = v;
			if(t.deleted)
			{
				cnt++;
				t.deleted = false;
			}
		}
		t.hight = (height(t.lc) >= height(t.rc) ? height(t.lc):height(t.rc)) + 1;
		return t;
	}

	
	
	/**
	 * @param n  节点
	 * @return 返回节点的高度
	 */
	private int max(HashNode n)
	{
		int l = height(n.lc);
		int r = height(n.rc);
		return (l >= r ? l : r) + 1;
	}
	/**
	 * 左旋转
	 * @param t
	 * @return
	 */
	private HashNode l_rotate(HashNode t) {
		HashNode t1 = t.lc;
		t.lc = t1.rc;
		t1.rc = t;
		t1.hight = max(t1);
		t.hight = max(t);
		return t1;
	}

	/**
	 * 右旋转
	 * @param t
	 * @return
	 */
	private HashNode r_rotate(HashNode t) {
		HashNode t1 = t.rc;
		t.rc = t1.lc;
		t1.lc = t;
		
		t.hight = max(t);
		t1.hight = max(t1);
		return t1;
	}

	/**
	 * 双左右旋转
	 * @param k
	 * @return
	 */
	private HashNode dlr_rotate(HashNode t) {
		
		t.lc = r_rotate(t.lc);
		return l_rotate(t);
	}

	/**
	 * 双右左旋转
	 * @param k 
	 * @return
	 */
	private HashNode drl_rotate(HashNode t) {
		t.rc = l_rotate(t.rc);
		return r_rotate(t);
	}

	
	
	/**
	 * 输出数据到屏幕
	 * @throws IOException
	 */
	public void display() throws IOException {
		if (root != null && cnt > 0) {
			root.display(null);
		} else {
			System.out.println("Binary Tree is empty!");
		}
	}


	/**
	 * @param key 键值
	 * @return 成功查询的节点
	 */
	public HashNode query(long key) {
		if (root == null) {
			return null;
		} else {
			HashNode curr = root;
			while (curr != null) {
				if (curr.key > key) {
					curr = curr.lc;
				} else if (curr.key < key) {
					curr = curr.rc;
				} else if (curr.key == key) {
					if(curr.deleted)
						return null;
					return curr;
				}
			}

			return null;
		}

	}

	/**
	 * 将二叉排序树的内容保存到文件中
	 * @param filename 文件名
	 * @return 成功 true， 失败 false
	 */
	public boolean write_file(String filename)
	{
		File file = new File(filename);
		FileWriter fw = null;
        BufferedWriter writer = null;
        try 
        {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
           
            root.display(writer);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            try 
            {
                writer.close();
                fw.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
                return false;
            }
        }
		return true;
	}
	
	/**
	 * 从文件中直接加载数据
	 * @param filename 文件路径
	 * @return 成功 true， 失败 false
	 */
	public boolean read_file(String filename)
	{
		File file = new File(filename);
		
		Reader reader = null;
        try {
        	boolean value_flag = false; 
        	boolean value_start = false;
        	boolean value_end = false;
        	
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar = -1;
            long key = 0;
            char curr;
            String skey = "",value = "";
           
            while ((tempchar = reader.read()) != -1) {
            	curr = (char)tempchar;

                if (curr == '\r' || curr == '\n') {
                	 value_flag = false;
                	 value_start = false;
                	 value_end = false;
                	 skey = "";
                	 value = "";
                }
                else
                {
                	

                	if(!value_flag )
                	{
                		if(curr == ' ')
                		{
                			key = Integer.valueOf(skey);
                    		value_flag = true;
                		}
                		else
                		{
                			skey += curr;
                		}
                	}
                	else
                	{
                		if(value_end)
                		{
                			continue;
                		}
                		if(value_start)
                		{
                			if(curr == '\'')
                			{
                				value_start = false;
                				value_end = true;
                				insert(key, value);
                			}
                			else
                			{
                    			value += curr;
                			}
                		}
                		else
                		{
                			if(curr == '\'')
                			{
                				value_start = true;
                			}
                		}
                	}
      
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	/**
	 * 返回树的元素数量
	 * @return 元素数量
	 */
	public int size()
	{
		return cnt;
	}
}
