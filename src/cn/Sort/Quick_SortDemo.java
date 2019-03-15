package cn.Sort;

/**
 * 快速排序:
 */
public class Quick_SortDemo {
//	static final  int Cutoff=10;//设定用快速排序法进行排序的元素阈值
	
	public void sort(int A[], int N) {
		quick_Sort(A, 0, N-1);
	}
	
	/**
	 * 1.比较头、尾、中间元素，将顺序变为头<=中间<=尾，然后将中间元素与（尾-1）位置的元素交换位置，此时主元在（尾-1）的位置.
	 */
	private int Median3(int A[],int left,int right){    //A={10,9,8,7,6,5,4,3,2,1};
		int mid=(left+right)/2;
		if(A[left]>A[mid])
			swap(A,left,mid);
		if(A[left]>A[right])
			swap(A,left,right);
		if(A[mid]>A[right])
			swap(A,mid,right);
		
		swap(A,mid,right-1);
		return A[right-1];//返回主元元素
	}
	
	/**
	 * 2.子集划分：将（头+1）到（尾-2）的元素依据主元大小划分位置，即左边元素s<=主元<=右边元素s,此时主元位置再也不会改变，完成一次递归排序。
	 * 当有元素等于主元时，我们选择进行交换而不是不处理，这样做的好处是主元每次都停在中间位置,最终复杂度为O(NlogN)。若选择不处理，则每次主元都会停在端点处，导致复杂度为O(N^2).
	 */
		public void quick_Sort(int[] A, int left, int right){
			 
			if(right-left+1>=3){
				int pivot=Median3(A, left, right);//得到主元
			int i=left;int j=right-1;
			for( ; ;)
			{
				while (A[++i]<pivot){}//满足条件，继续++i
				while(A[--j]>pivot){}//满足条件，继续--j
			
				if(i<j)
					swap(A,i,j);//不满足条件且i<j时，交换两个位置的元素
				else 
					break;//不满足条件且i>=j时，跳出循环，由下一步骤确定主元素最终位置
			}
			swap(A,i,right-1);//主元元素位置确定，不会再改变，此时左边元素均小于等于主元，右边元素均大于等于主元
			quick_Sort(A, left, i-1);
			quick_Sort(A, i+1,right);
			}
			}
			
			//将要进行排序的元素个数小于阈值时进行插入排序
//			else{
////				 int[] B=new int[right-left+1];
////				for(int i=left;i<=right;i++){
////					for (int j=0;j<=right-left;j++)
////						B[j]=A[i];
////				}
//				new Insertion_Sort().Merge_array(A, right-left+1);
//			}
			
//		}
	
	/**
	 * 交换函数
	 */
	private void swap(int[] S,int a,int b){
			int temp;
			temp=S[a];
			S[a]=S[b];
			S[b]=temp;
	}
}
