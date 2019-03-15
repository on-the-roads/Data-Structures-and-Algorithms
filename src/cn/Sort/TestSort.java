package cn.Sort;


import org.junit.Test;

public class TestSort {
	
	@Test
	public void testBubble_sort() throws Exception {
		int[] A={6,5,4,3,2,1};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Bubble_Sort().sort(A, 6);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
	@Test
	public void testInsertion_sort() throws Exception {
		int[] A={6,5,4,3,2,1};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Insertion_Sort().sort(A, 6);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
	@Test
	public void testShell_sort() throws Exception {
		int[] A={6,5,4,3,2,1};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Shell_Sort().sort(A, 6);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
	@Test
	public void testMerge_Sort1() throws Exception {
		int[] A={4,5,6,1,2,3};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Merge_Sort().Merge_sort(A,0,5);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}

	@Test
	public void testMerge_Sort2() throws Exception {
		int[] A={4,5,6,1,8,5};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Merge_Sort().Merge_sort(A,0,5);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
	@Test
	public void testSelect_Sort() throws Exception {
		int[] A={6,5,4,3,2,1};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Select_Sort().sort(A,6);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
	@Test
	public void testQuick_Sort() throws Exception {
		int[] A={10,9,8,7,6,5,4,3,2,1};
		int[] B={1,1,1,1,1,1,1,3,2,1};
		System.out.print("排序前：");
		for (int i:B)
			System.out.print(i+" ");
		new Quick_Sort().sort(B,10);
		System.out.println();
		System.out.print("排序后：");
		for (int i:B)
			System.out.print(i+" ");
	}
	@Test
	public void testQuick_SortDemo() throws Exception {
		int[] A={10,9,8,7,6,5,4,3,2,1};
		int[] B={1,1,1,1,1,1,1,3,2,1};
		System.out.print("排序前：");
		for (int i:A)
			System.out.print(i+" ");
		new Quick_SortDemo().sort(A,10);
		System.out.println();
		System.out.print("排序后：");
		for (int i:A)
			System.out.print(i+" ");
	}
}
