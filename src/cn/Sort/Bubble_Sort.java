package cn.Sort;

/**
 * 冒泡排序:
 * 从前往后，依次与下一元素比较
 */
public class Bubble_Sort {

	public void sort(int A[], int N) {
		int flag=0;//flag用于判断初始数值是否有序
		for (int P = N; P > 1; P--) {
			//一趟冒泡
			for (int i = 0; i < P - 1; i++) {
				if (A[i] > A[i + 1]) {
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
					flag=1;
				}
			}
			//第一次循环结束后发现没有移位，则说明初始数组有序，跳出循环，不再判断
			if(flag==0)
				break;
		}
	}
}
