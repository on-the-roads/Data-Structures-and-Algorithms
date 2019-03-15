package cn.Sort;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Bubble_SortTest extends TestCase {
    private  Bubble_Sort test;
    int[] A={6,5,4,3,2,1};
    @Before
    public void setUp() throws Exception {
        System.out.print("排序前：");
        for (int i:A)
            System.out.print(i+" ");
        test=new Bubble_Sort();
    }

    @Test
    public void testSort() {
        test.sort(A,6);
        System.out.println();
        System.out.print("排序后：");
        for (int i:A)
            System.out.print(i+" ");
    }
}