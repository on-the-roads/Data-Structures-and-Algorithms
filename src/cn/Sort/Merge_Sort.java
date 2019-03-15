package cn.Sort;

/**
 * 归并排序
 */
public class Merge_Sort {

    /**
     * 递归进行合并，此方法调用了Merge_array（）方法，递归和合并在一起构成了“归并”
     * @param A
     * @param left
     * @param right
     */
    void Merge_sort(int A[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Merge_sort(A, left, mid);
            Merge_sort(A, mid + 1, right);
            Merge_array(A, left, mid + 1, right);
        }
    }


    /**
     * 两个有序子列的合并：A{4 5 6 1 2 3 }->A{1 2 3 4 5 6 }
     */
    private void Merge_array(int A[], int L, int R, int R_end) {
        /*
         * L:左边序列起始位置
         * R:右边序列起始位置
         * Rend:右边序列结束位置
         */
        //元素个数
        int num = R_end - L + 1;
        //左边子序列结束位置
        int L_end = R - 1;
        int left = L;
        int right = R;
        //临时数组
        int[] temp = new int[num];

        int i = 0;
        while (left <= L_end && right <= R_end) {
            if (A[left] <= A[right])
                temp[i++] = A[left++];
            else
                temp[i++] = A[right++];
        }

        while (left <= L_end)
            temp[i++] = A[left++];
        while (right <= R_end)
            temp[i++] = A[right++];

        for (int k = 0; k < i; k++) {
            A[L + k] = temp[k];//注意这里不能写作A[k] = temp[k];
        }

    }



}
