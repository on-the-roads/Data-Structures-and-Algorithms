package com.alogrium.week1;

import java.io.IOException;
import java.util.Scanner;

public class quickfind_UF {

	/**
	 * @param args
	 *            第一种查找方法：quickfind
	 */
	private int[] id;// 分量id数组,以触点作为索引
	private int count;// 分量数量

	// 创建对象时格式化分量数组
	public quickfind_UF(int N) {
		count = N;
		id = new int[N];
		for (int n = 0; n < N; n++) {
			id[n] = n;
		}
	}

	// 获得分量数量
	public int Getcount() {
		return count;
	}

	/*
	 * 连接分量 quick find 算法
	 */
	public void Union(int p, int q) {
		int pid = Find(p);
		int qid = Find(q);
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
		count--;
	}

	// 获得对应分量id
	public int Find(int p) {
		return id[p];
	}

	// 判断是否连通
	public boolean IsUnion(int p, int q) {
		return Find(p) == Find(q);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		quickfind_UF UF1 = new quickfind_UF(N);
		while (scan != null) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (UF1.IsUnion(p, q))
				continue;
			UF1.Union(p, q);
			System.out.println(p + " " + q+ " 分量个数：" + UF1.Getcount());
		}
	}
}
