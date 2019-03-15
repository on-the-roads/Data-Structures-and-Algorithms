package com.Search;

import java.util.List;

public class BinarySearch {

	public int  find(int[] list, int K){
		int left=0;
		int right=list.length-1;
		int NotFound=-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(list[mid]<K)
			{
				left=mid+1;
			}
			else if (list[mid]>K) {
				right=mid-1;
			}
			else 
				return mid;
		}
		return NotFound;
	}
}
