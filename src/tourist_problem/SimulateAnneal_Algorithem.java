package tourist_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//************���������************
class City {
	private static final double Earth_Radius = 6378.393D;

	private double longtitude;// ����
	private double latitude;// γ��
	private String name;// ����

	// ���й��캯����������γ���Լ���������
	public City(double longtitude, double latitude, String name) {
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.name = name;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {//��дtoString�����س�������
		return this.name;
	}

	// ������м����
	public double ToDistance(City city) {
		double delta_longtitude = ConvertDegreesToRadians(Math
				.abs(this.longtitude - city.longtitude));// ע��Ƕ�ת��Ϊ���Ƚ��м���
		double delta_latitude = ConvertDegreesToRadians(Math.abs(this.latitude
				- city.latitude));
		double h = Haversin(delta_latitude / 2)
				+ Math.cos(ConvertDegreesToRadians(this.latitude))
				* Math.cos(ConvertDegreesToRadians(city.latitude))
				* Haversin(delta_longtitude / 2);
		double distance = Earth_Radius * 2D
				* Math.atan(Math.sqrt(h) / Math.sqrt(1 - h));
		return distance;
	}

	// Haversine��ʽ
	public double Haversin(double theta) {
		return Math.pow(Math.sin(theta / 2), 2); // (sin(theta/2))^2
	}

	// �Ƕ�ת��Ϊ����
	public double ConvertDegreesToRadians(double degree) {
		return degree * Math.PI / 180;
	}
}

// **************����·����**************
class Route {
	private ArrayList<City> cities = new ArrayList<City>();

	public Route(ArrayList<City> cities) {// ��������1��������Ⱥ����·���滮�У�����������������ݴ���Route��
		this.cities.addAll(cities);
		Collections.shuffle(this.cities);// ����������������
	}
	
	public Route(Route route){//���캯��2���ı����Ⱥ˳���ˢ��Route
		for (City city:route.GetCities()){
			this.cities.add(city);
		}
	}

	public ArrayList<City> GetCities() {// ��ó���Ⱥ
		return this.cities;
	}

	@Override
	public String toString() {
		return Arrays.toString(cities.toArray());  //��дtoString,���س���Ⱥ�����ƣ��ַ�����
	}

	//�������Ⱥ·���ܾ���
	public double getTotalDistance(){
		int dex=0;
		double sum=0;
		while(dex<this.cities.size()-1){
			sum=sum+this.cities.get(dex).ToDistance(cities.get(dex+1));
			dex++;
		}
		sum=sum+this.cities.get(0).ToDistance(cities.get(cities.size()-1));
		return sum;
	}
	
    public String getTotalStringDistance() {        
    	String returnString = String.format("%.2f", this.getTotalDistance());     
    	return returnString;   
    	}
}


//**************����ģ���˻��㷨**************
public class SimulateAnneal_Algorithem {
	
	int NumofIteration=0;//��������
	double T=100000;  //�൱��ģ���˻������¶�
	private static final double k=0.999;//����ϵ��
	private static final double T_min=1e-5;//�൱��ģ���˻������¶�
	String CompareResult=null;//·���ԱȽ��
	//Ѱ�Ҹ�����·��
	public Route FindShorterRoute(Route currentRoute){
		while(T>T_min){
		Route changedRoute=ChangedRoute(new Route(currentRoute));
		if(currentRoute.getTotalDistance()>=changedRoute.getTotalDistance()){
			CompareResult="���� -->";
			currentRoute=new Route(changedRoute);
			NumofIteration=0;
		}
		else if (currentRoute.getTotalDistance()<changedRoute.getTotalDistance()) {
			double r=Math.random();
			if(Math.exp((currentRoute.getTotalDistance()-changedRoute.getTotalDistance()))/T>r){
				CompareResult="���� -->";	
				currentRoute=new Route(changedRoute);
				NumofIteration=0;
			}
			else{
				CompareResult="���� <--";
				NumofIteration++;
			}
		}
		T=T*k;
		System.out.println(currentRoute+"   |   �ܾ��룺  "+currentRoute.getTotalStringDistance()+"km  | "+CompareResult+"  �������� �� "+NumofIteration);
		}
		System.out.println("���ܵ����Ž⣡��������");
	    return null;
	}
	//����µ�·��(����˳��ͬ)
	public Route ChangedRoute(Route route){
		int x1=0;
		int x2=0;
		while(x1==x2){
			 x1=(int) ((route.GetCities().size()-1)*Math.random());
			 x2=(int) ((route.GetCities().size()-1)*Math.random());
		}
		City city1=route.GetCities().get(x1);
		City city2=route.GetCities().get(x2);
	//����·�����������е�˳��	
		route.GetCities().set(x1, city2);
		route.GetCities().set(x2, city1);
		return  route;
	}
}

class Go{
    private   ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
            new City(116.41667, 39.91667, "����"),
            new City(121.43333, 34.50000, "�Ϻ�"),
            new City(113.00000, 28.21667, "��ɳ"),
            new City(114.10000,22.20000, "���"),
            new City(106.45000, 29.56667, "����"),
            new City(114.31667,30.51667, "�人"),
            new City(104.06667,30.66667, "�ɶ�"),
            new City(106.26667, 38.46667, "����"),
            new City(109.50000, 18.20000, "����"),
            new City(112.53333, 37.86667, "̫ԭ"),
            new City(91.00000, 29.60000, "����"),
            new City(102.73333,  25.05000, "����"),
            new City(126.63333, 45.75000, "������"),
            new City(113.65000, 34.76667, "֣��"),
            new City(113.50000, 22.20000, "����")
            )
            );
  
    
    public static void main(String[] args) {
        Route route=new Route(new Go().initialCities);
        new SimulateAnneal_Algorithem().FindShorterRoute(route);
    }
}
