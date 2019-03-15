package com.StacksAndQueues;

public interface Queue {
	void inQ(Object Items);//入列
	Object OutQ();//出列
	int getSize();
	boolean isEmpty();
}
