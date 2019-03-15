package com.StacksAndQueues;

import java.util.Scanner;

/**
 * 顺环队列，通过数组实现 
 *
 */
public class QueuebyArray implements Queue {

	private int front=0;
	private int rear=0;
	private int Maxsize=6;
	private int CurrenSize=0;
	private String[] s=new String[Maxsize];
	@Override
	public Object OutQ() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
		String Item=s[front];
		front=(front+1)%Maxsize;
		CurrenSize--;
		return Item;
		}
		else {
			System.err.println("队列已空");
			return null;
		}
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.CurrenSize;
	}
	@Override
	public void inQ(Object Items) {
		// TODO Auto-generated method stub
		if(!isFUll()){
		s[rear]=(String) Items;
		rear=(rear+1)%Maxsize;
		CurrenSize++;
		}
		else 
			System.err.println("队列已满");
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (front==rear)
		return true;
	return false;
	}
	
	
	public boolean isFUll() {
		// TODO Auto-generated method stub
		if(CurrenSize==(Maxsize-1))
		return true;
	return false;
	}
	
	public static void main(String[] args) {
		QueuebyArray queue=new QueuebyArray();
		Scanner scan= new Scanner(System.in);
		while(scan!=null)
		{
			String data=scan.next();
			if (!data.equals("-")) {
				queue.inQ(data);
			} else {
					System.out.println("出列："+queue.OutQ());
			}
			System.out.println("队列中的元素个数： "+queue.CurrenSize);
		}
	}

	

	
}
