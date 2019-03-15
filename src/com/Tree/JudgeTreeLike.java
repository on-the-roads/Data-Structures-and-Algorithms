package com.Tree;



/**
 * 结构数组表示二叉树：静态链表
 * @author Chenjiawen
 *
 */
public class JudgeTreeLike {
	final int MaxTree=10;
	final int Null=-1;

	class TreeNode{
		char Element;
		int Left;
		int Right;
	}
	TreeNode[] T1=new TreeNode[MaxTree];
	TreeNode[] T2=new TreeNode[MaxTree];
	
	/**
	 * 读数据建二叉树
	 */
	public TreeNode BuileTree(TreeNode[] T){
		TreeNode Root=null;
		int N=T.length;
		int[] check=new int[N];//用于判断根节点的位置，初始时设置数组值均为0
		for(int i=0;i<N;i++){
			check[i]=0;
		}
		
		if(N==0)
			return null;
		else
		{
			for(int i=0;i<N;i++)
			{
				if(T[i].Left!=Null)//左子树不为空
					check[T[i].Left]=1;//说明对应的左子树不是根节点，check置1
				if(T[i].Right!=Null)
					check[T[i].Right]=1;
			}
			
			for (int i = 0; i < check.length; i++) {
				if(check[i]==0&&T[i].Element!='\0')//若结点值不为空同时check[i]为0，则说明为根结点
					break;
				Root=T[i];
			}
		}
		return Root;
	}
	
	/**
	 * 判断是否同构
	 * @return int(0,1)
	 */
	public int Isomorphic(TreeNode R1,TreeNode R2) {
		if(R1==null&&R2==null)//均为空
			return 1;
		if((R1==null&&R2!=null)&&(R1!=null&&R2==null))//其中一方为空
			return 0;
		if(R1.Element!=R2.Element)//均不为空但是元素不相等
			return 0;
		if(R1.Left==Null&&R2.Left==Null)//左子树均为空，则递归比较右子树
			return Isomorphic(T1[R1.Right], T2[R2.Right]);
		if((T1[R1.Left]!=null&&T2[R2.Left]!=null)&&(T1[R1.Left].Element==T2[R2.Left].Element))//左子树同时不为空，则判断元素是否相同，相同则继续判断各自的左子树和右子树是否同构：左对左，右对右
			return (Isomorphic(T1[R1.Left], T2[R2.Left])*Isomorphic(T1[R1.Right], T2[R2.Right]));
		else//左对右，右对左
			return (Isomorphic(T1[R1.Right], T2[R2.Left])*Isomorphic(T1[R1.Left], T2[R2.Right]));

//		return 0;
	}
	public static void main(String[] args) {
		//1、建二叉树1
		//2、建二叉树2
		//3、判断是否同构并输出
		
		TreeNode[] node=new TreeNode[5];
		System.out.println(node.length);
	}
}
