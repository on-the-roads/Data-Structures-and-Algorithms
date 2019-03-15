package com.StacksAndQueues;

import java.util.Scanner;

public class StackbyArray {

	/**
	 * @param args
	 *            ͨ������ʵ��ջ
	 */
	private int N = 0;// Ԫ������,��ʼΪ0
	private String[] s = new String[1];

	public int getSize() {
		return N;
	}

	public Boolean isEmpty() {
		return N==0;
	}

	public void resize(int capacity_new) {
		String[] sn = new String[capacity_new];
		for (int i = 0; i < N; i++)
			sn[i] = s[i];
		s = sn;
	}

	public String pop() {
		String item = s[--N];
		if (N == s.length / 4 && N > 0)
			resize(s.length / 2);
		System.out.println("�������");
		return item;
	}

	public void push(String item) {
		s[N++] = item;
		if (N == s.length)
			resize(s.length*2);
		System.out.println("��ӽ��");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackbyArray stack=new StackbyArray();
		Scanner scan= new Scanner(System.in);
		while(scan!=null)
		{
			String data=scan.next();
			if (!data.equals("-")) {
				stack.push(data);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			System.out.println(stack.getSize()+ " ����� left on the stack");
		}
	}
}
