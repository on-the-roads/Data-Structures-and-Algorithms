package cn.Sort;

/**
 * 插入排序: 模拟打牌
 */
public class Insertion_Sort {

	public void sort(int A[], int N) {
		for(int P=1;P<N;P++){
			int temp=A[P];//摸下一张牌
			for(int i=P;i>0&&A[i-1]>temp;i--)
			{
				A[i]=A[i-1];//移出空位
				A[i-1]=temp;//新牌落位
			}
		}
			
	}
}
