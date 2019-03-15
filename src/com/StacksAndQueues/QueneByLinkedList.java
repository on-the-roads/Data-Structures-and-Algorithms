package com.StacksAndQueues;

import java.util.Scanner;

/**
 * 通过单向链表实现队列
 *
 */
public class QueneByLinkedList implements Queue {

	private int currentSize=0;
	Node front=null;
	Node rear=null;
	private class Node{
		Object Items;
		Node next;
		Node(Object item){
			this.Items=item;
			this.next=null;
		}
	}
	
	@Override
	public void inQ(Object Items) {
		// TODO Auto-generated method stub
		if(!isEmpty()){//队列不为空,front和rear都指向这个Node
		Node oldRearNode=rear;
		rear=new Node(Items);
		oldRearNode.next=rear;
		currentSize++;
		}
		else {//队列为空
			rear=new Node(Items);
			front=rear;
			currentSize++;
		}
	}
	
	@Override
	public Object OutQ() {
		// TODO Auto-generated method stub
		if(!isEmpty()){//队列不为空
		Node oldFrontNode=front;
		front=oldFrontNode.next;
		currentSize--;
		Object OutItems=oldFrontNode.Items;
		oldFrontNode=null;
		return OutItems;
		}
		else {//队列为空
			System.err.println("队列已空");
			return -1;
		}
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.currentSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.currentSize==0;
	}

	
	
	public static void main(String[] args) {
		QueneByLinkedList queue=new QueneByLinkedList();
		Scanner scan= new Scanner(System.in);
		while(scan!=null)
		{
			String data=scan.next();
			if (!data.equals("-")) {
				queue.inQ(data);
			} else {
					System.out.println("出列："+queue.OutQ());
			}
			System.out.println("队列中的元素个数： "+queue.getSize());
		}
	}

}
