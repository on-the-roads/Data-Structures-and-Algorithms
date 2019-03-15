package cn.Sort;

public class IsOrdered {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Boolean boolean1 = new IsOrdered().IsOrder(new int[] { 2,2,2,2,2,2 });
		System.out.println(boolean1);
	}

	public static Boolean IsOrder(int[] str) {
		// �����ж��������Ƿ����Ԫ��ȫ����ȵ����
		int j = 0;
		while (j < (str.length - 1) && str[j] == (str[j + 1]))
			j++;
		if (str.length == 1 || j == str.length - 1)
			return true;
		// ��Ԫ�ز�ȫ�����ʱ���ж������Ƿ��е�һ�͵ڶ���Ԫ�صĴ�С��ϵ
		else
			j = str[j] - str[j + 1];
		//���ж���������Ԫ�ش�С��ϵ�Ƿ񱣳�һ��
		for (int i = 0; i < str.length - 1; i++) {
			if ((str[i] - str[i + 1])*j < 0)
				return false;
		}
		return true;
	}

}
