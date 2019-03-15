package com.StacksAndQueues;

import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class StackbyLinkedlist<Item> {

	/**
	 * @param args
	 *            利用链表实现栈
	 */
	private Node first=null ;// 栈顶结点
	static private int N = 0;// 结点数量

	private class Node {// 链表或者为空，或者是指向一个结点的引用。该结点含有一个泛型的元素和一个指向另一个链表的引用
		Item item;
		Node next;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {

		return first == null;
	}

	// 弹栈
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	// 压栈
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackbyLinkedlist<String> stack = new StackbyLinkedlist<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数据：");
		while (scanner != null) {
			String data = scanner.next();
			if (!data.equals("-")) {
				stack.push(data);
				System.out.println("添加结点");
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					System.out.println("弹出结点");
				}
			}
			System.out.println(stack.size() + " 个结点 left on the stack");
		}
	}

}
