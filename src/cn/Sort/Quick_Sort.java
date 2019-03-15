package cn.Sort;

public class Quick_Sort {

	public void sort(int[] A, int N) {
		Adjust_array(A, 0, N - 1);
	}

	public void Adjust_array(int[] A, int left, int right) {
		if (right - left + 1 >= 2) {
			int i = left;
			int j = right;
			int x = A[i];// 第一个坑 i
			while (i < j) {
				while (i < j && A[j] > x)
					// 从后面找一个比x小的数来填坑
					j--;
				if (i < j)
					A[i] = A[j];// 第二个坑 j

				while (i < j && A[i] < x)
					// 从前面找一个比x大的数来填坑
					i++;
				if (i < j) {
					A[j] = A[i];// 第三个坑 i,此时坑的位置又来到i位置，将j-1,完成一轮循环
					j--;
				}
			}
			// 退出时，i=j,将x填入这个坑中
			A[i] = x;
			Adjust_array(A, left, i - 1);
			Adjust_array(A, i + 1, right);
		}
	}

}
