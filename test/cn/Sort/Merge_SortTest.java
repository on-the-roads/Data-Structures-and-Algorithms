package cn.Sort;

import junit.framework.TestCase;

public class Merge_SortTest extends TestCase {
    private Merge_Sort test;
    int[] A={6,5,4,3,2,1};
    public void setUp() throws Exception {
        System.out.print("排序前：");
        for (int i:A)
            System.out.print(i+" ");
        test=new Merge_Sort();
    }

    public void testSort() {
        test.Merge_sort(A,0,5);
        System.out.println();
        System.out.print("排序后：");
        for (int i:A)
            System.out.print(i+" ");
    }
}