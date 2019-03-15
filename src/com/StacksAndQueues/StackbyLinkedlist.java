package com.StacksAndQueues;

import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class StackbyLinkedlist<Item> {

	/**
	 * @param args
	 *            ��������ʵ��ջ
	 */
	private Node first=null ;// ջ�����
	static private int N = 0;// �������

	private class Node {// �������Ϊ�գ�������ָ��һ���������á��ý�㺬��һ�����͵�Ԫ�غ�һ��ָ����һ�����������
		Item item;
		Node next;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {

		return first == null;
	}

	// ��ջ
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	// ѹջ
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
		System.out.println("���������ݣ�");
		while (scanner != null) {
			String data = scanner.next();
			if (!data.equals("-")) {
				stack.push(data);
				System.out.println("��ӽ��");
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					System.out.println("�������");
				}
			}
			System.out.println(stack.size() + " ����� left on the stack");
		}
	}

}
