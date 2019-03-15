package DiGui;

public class Hanoi_Tower_Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hanoi_Tower_Problem().Hanoi(2, 'A','B','C');
	}
	
	//Բ��ת�ƹ��̺���
	//�������ΪԲ�̸�������ʼ������Ŀ������������������
	public void Hanoi(int n, char ori, char dest, char med){
		if(n==1){
			move(ori,dest);
		}
		else
		{
		Hanoi(n-1, ori, med, dest);
		move(ori,dest);
		Hanoi(n-1,med, dest, ori);
		}
	}
	//��Ϊ�������۲�Բ��ת����Ϊ
	//�������Ϊ��ʼ������Ŀ������
	public void move (char a,char b) {
		System.out.println(a+"-->"+b);
	}
}
