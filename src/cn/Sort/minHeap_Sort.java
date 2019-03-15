package cn.Sort;

/**
 * 堆排序
 * 构造最小堆：数组实现
 * 其中假设当前结点下标为n，则父结点下标为（n-1）/2,左儿子结点下标为2*n+1，右儿子结点下标为2*n+2；
 */
public class minHeap_Sort {
    /**
     * 堆的插入
     * @param a 堆的实现数组
     * @param n 插入元素的初始下标
     * @param num 元素值
     */
    public void insert(int[] a, int n,int num) {
        a[n] = num;
        minHeap_fixup(a, n);
    }

    /**
     * 插入过程：先将新的元素插入数组的末尾，然后依次与父节点比较，替换最终到达合适的位置，是一个“自下而上”的替换过程。
     * @param a 堆的实现数组
     * @param n 插入元素的初始下标
     */
    private void minHeap_fixup(int[] a, int n) {
        int p = (n - 1) / 2;//父节点
        int temp = a[n];
        //进行直接插入排序
        for (int i = p; i >= 0 && n > 0; n = i, i = (i - 1) / 2) {
            if (a[i] > a[n]) {
                swap(a, i, n);
            }
        }
    }

    /**
     *
     * @param a 堆的实现数组
     * @param n 删除前的结点总个数
     */
    void delete(int[] a, int n)
    {
        swap(a,0,n-1);
        minHeap_fixdown(a,0,n-1);
    }


    /**
     * 删除的过程其实是个自上而下的过程，
     *       根据堆的定义，删除元素时首先将最后一个元素与堆顶替换位置
     *       接着新的堆顶元素与左右儿子的较小者作比较：
     *          1.若小于左右儿子的较小者，则说明位置合适
     *          2.不小于，则其值被左右儿子的较小者覆盖，继续向下寻找合适位置，循环12过程。
     * @param a 堆的实现数组
     * @param i 从i处开始往下进行替换
     * @param n 结点总个数
     */
    private void minHeap_fixdown(int[] a, int i, int n)
    {
        int temp=a[i];
        int j =i*2+1;//下标为i的结点的左儿子
        while(j<=n-1)
        {
            if(j+1<=n-1&&a[j+1]<a[j])
                j++;//得到结点左右儿子中较小的那一个
            if(a[j]>temp)
                break;//找到合适的位置
            a[i]=a[j];
            i=j;
            j=2*j+1;
        }
        a[i]=temp;
    }
    private void swap(int[] a, int i, int n) {
        int temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }


    public static void main(String[] args) {
        int[] test=new int[100];
        minHeap_Sort minheap=new minHeap_Sort();
        minheap.insert(test,0,19);
        minheap.insert(test,1,8);
        minheap.insert(test,2,2);
        minheap.insert(test,3,3);
        minheap.insert(test,4,1);

        minheap.delete(test,5);

    }
}
