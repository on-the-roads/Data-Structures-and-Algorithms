package cn.Sort;

/**
 * 选择排序
 * 与插入排序的区别：
 *      插入排序将无序区中的第一个元素插入到有序区的适当位置；
 *      选择排序是将无序中的最小元素插入到有序区的最后位置。
 */
public class Select_Sort {
    void sort(int[] a,int n)
    {
        int min=0;
        for (int P = 0; P <=n-2 ; P++) {
            min=P;
            //无序区进行一次遍历，找到最小元素
            for (int i = P+1; i <=n-1 ; i++) {
                if(a[i]<a[min])
                    min=i;
            }
            swap(a,P,min);//将无序区的最小元素插入到有序区后面
        }
    }

    private void swap(int[] a, int p, int q) {
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }



}
