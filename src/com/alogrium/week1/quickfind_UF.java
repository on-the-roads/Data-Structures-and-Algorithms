package com.alogrium.week1;

import java.io.IOException;
import java.util.Scanner;

public class quickfind_UF {

	/**
	 * @param args
	 *            ��һ�ֲ��ҷ�����quickfind
	 */
	private int[] id;// ����id����,�Դ�����Ϊ����
	private int count;// ��������

	// ��������ʱ��ʽ����������
	public quickfind_UF(int N) {
		count = N;
		id = new int[N];
		for (int n = 0; n < N; n++) {
			id[n] = n;
		}
	}

	// ��÷�������
	public int Getcount() {
		return count;
	}

	/*
	 * ���ӷ��� quick find �㷨
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

	// ��ö�Ӧ����id
	public int Find(int p) {
		return id[p];
	}

	// �ж��Ƿ���ͨ
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
			System.out.println(p + " " + q+ " ����������" + UF1.Getcount());
		}
	}
}
