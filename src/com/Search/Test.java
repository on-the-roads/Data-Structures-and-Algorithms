package com.Search;

public class Test {
	@org.junit.Test
	public void Binary_SortTest() throws Exception {
		int[] A={1,2,3,4,5,6,7,8,9,11,13,25,26};
		int result=new BinarySearch().find(A, 9);
		System.out.println(result);
	}
}
