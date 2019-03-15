package cn.Sort;

/**
 * 原始希尔排序:
 */
public class Shell_Sort {

	public void sort(int A[], int N) {
		for (int D = N / 2; D > 0; D = D / 2) {// 希尔增量序列

			for (int P = D; P < N; P++) {
				int temp = A[P];
				for (int i = P; i >= D && A[i - D] > temp; i = i - D) {
					A[i] = A[i - D];// 移出空位,间隔D位的插入排序
					A[i - D] = temp;// 新牌落位
				}
			}
		}
	}
}
