package com.Tree;
/**
 *	普通的树节点
 *	<链表存储结构>
 */
public class TreeNode<T> {
	private T value;
	private	TreeNode<T> leftChild;
	private	TreeNode<T> rightChild;
	public TreeNode() {
	}
	public TreeNode(T value){
		this(value,null,null);
	}
	public TreeNode(T value,TreeNode<T>lefT,TreeNode<T>rightT){
		this.value=value;
		this.leftChild=lefT;
		this.rightChild=rightT;
	}
	
	/**
	 * 增加左节点
	 */
	public void addLeftChild(T value) {
		TreeNode<T> leftNode=new TreeNode<T>(value);
		this.leftChild=leftNode;
	}
	/**
	 * 增加右节点
	 */
	public void addRightChild(T value) {
		TreeNode<T> rightNode=new TreeNode<T>(value);
		this.rightChild=rightNode;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "value:"+this.value+" ";
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	
}
