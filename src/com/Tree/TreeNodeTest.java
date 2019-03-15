package com.Tree;

public class TreeNodeTest {
	

	@org.junit.Test
	public void test_InOrderTraversal2() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("中序遍历非递归方法：");
		TreeTools.InOrderTraversal2(root);
	}
	@org.junit.Test
	public void test_PreOrderTraversal2() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("先序遍历非递归方法：");
		TreeTools.PreOrderTraversal2(root);
	}
	@org.junit.Test
	public void test_PostOrderTraversal1() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("后序遍历递归方法：");
		TreeTools.PostOrderTraversal1(root);
	}
	@org.junit.Test
	public void test_PostOrderTraversal2() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("后序遍历非递归方法1：");
		TreeTools.PostOrderTraversal2(root);
	}
	@org.junit.Test
	public void test_PostOrderTraversal2s() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("后序遍历非递归方法2：");
		TreeTools.PostOrderTraversal2s(root);
	}
	@org.junit.Test
	public void test_LevelOrderTraversal1() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("层序遍历方法1：");
		TreeTools.LevelOrderTraversal1(root);
	}
	@org.junit.Test
	public void test_LevelOrderTraversal2() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("层序遍历方法2：");
		TreeTools.LevelOrderTraversal2(root);
	}
	@org.junit.Test
	public void test_DFS() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("深度优先搜索：");
		TreeTools.DFS(root);
	}
	@org.junit.Test
	public void test_getTreeNodenumByPreOrder() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("树的节点个数");
		System.out.println(TreeTools.getTreeNodenumByPreOrder(root));
	}
	@org.junit.Test
	public void test_getTreeHeightByPostOrder() throws Exception {
		TreeNode<Integer>root=new TreeNode<Integer>(0);
		root.addLeftChild(1);
		root.addRightChild(2);
		root.getLeftChild().addLeftChild(3);
		root.getRightChild().addLeftChild(4);
		root.getRightChild().addRightChild(5);
		System.out.println("树的高度");
		System.out.println(TreeTools.getTreeHeightByPostOrder(root));
	}
}
