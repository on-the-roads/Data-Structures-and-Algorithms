package DiGui;

public class Hanoi_Tower_Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hanoi_Tower_Problem().Hanoi(2, 'A','B','C');
	}
	
	//圆盘转移过程函数
	//输入参数为圆盘个数、起始塔座、目标塔座、过渡塔座。
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
	//行为函数，观察圆盘转移行为
	//输入参数为起始塔座、目标塔座
	public void move (char a,char b) {
		System.out.println(a+"-->"+b);
	}
}
