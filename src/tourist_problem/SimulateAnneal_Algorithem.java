package tourist_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//************定义城市类************
class City {
	private static final double Earth_Radius = 6378.393D;

	private double longtitude;// 经度
	private double latitude;// 纬度
	private String name;// 名称

	// 城市构造函数，包含经纬度以及城市名称
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
	public String toString() {//覆写toString，返回城市名称
		return this.name;
	}

	// 计算城市间距离
	public double ToDistance(City city) {
		double delta_longtitude = ConvertDegreesToRadians(Math
				.abs(this.longtitude - city.longtitude));// 注意角度转换为弧度进行计算
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

	// Haversine公式
	public double Haversin(double theta) {
		return Math.pow(Math.sin(theta / 2), 2); // (sin(theta/2))^2
	}

	// 角度转换为弧度
	public double ConvertDegreesToRadians(double degree) {
		return degree * Math.PI / 180;
	}
}

// **************定义路径类**************
class Route {
	private ArrayList<City> cities = new ArrayList<City>();

	public Route(ArrayList<City> cities) {// 构建函数1，将城市群加入路径规划中，用于最初将城市数据传入Route中
		this.cities.addAll(cities);
		Collections.shuffle(this.cities);// 将城市随机排序打乱
	}
	
	public Route(Route route){//构造函数2，改变城市群顺序后，刷新Route
		for (City city:route.GetCities()){
			this.cities.add(city);
		}
	}

	public ArrayList<City> GetCities() {// 获得城市群
		return this.cities;
	}

	@Override
	public String toString() {
		return Arrays.toString(cities.toArray());  //覆写toString,返回城市群的名称（字符串）
	}

	//计算城市群路程总距离
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


//**************定义模拟退火算法**************
public class SimulateAnneal_Algorithem {
	
	int NumofIteration=0;//迭代次数
	double T=100000;  //相当于模拟退火的最高温度
	private static final double k=0.999;//降温系数
	private static final double T_min=1e-5;//相当于模拟退火的最低温度
	String CompareResult=null;//路径对比结果
	//寻找更近的路径
	public Route FindShorterRoute(Route currentRoute){
		while(T>T_min){
		Route changedRoute=ChangedRoute(new Route(currentRoute));
		if(currentRoute.getTotalDistance()>=changedRoute.getTotalDistance()){
			CompareResult="更新 -->";
			currentRoute=new Route(changedRoute);
			NumofIteration=0;
		}
		else if (currentRoute.getTotalDistance()<changedRoute.getTotalDistance()) {
			double r=Math.random();
			if(Math.exp((currentRoute.getTotalDistance()-changedRoute.getTotalDistance()))/T>r){
				CompareResult="更新 -->";	
				currentRoute=new Route(changedRoute);
				NumofIteration=0;
			}
			else{
				CompareResult="保持 <--";
				NumofIteration++;
			}
		}
		T=T*k;
		System.out.println(currentRoute+"   |   总距离：  "+currentRoute.getTotalStringDistance()+"km  | "+CompareResult+"  迭代次数 ： "+NumofIteration);
		}
		System.out.println("可能的最优解！！！！！");
	    return null;
	}
	//获得新的路径(城市顺序不同)
	public Route ChangedRoute(Route route){
		int x1=0;
		int x2=0;
		while(x1==x2){
			 x1=(int) ((route.GetCities().size()-1)*Math.random());
			 x2=(int) ((route.GetCities().size()-1)*Math.random());
		}
		City city1=route.GetCities().get(x1);
		City city2=route.GetCities().get(x2);
	//交换路径中两个城市的顺序	
		route.GetCities().set(x1, city2);
		route.GetCities().set(x2, city1);
		return  route;
	}
}

class Go{
    private   ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
            new City(116.41667, 39.91667, "北京"),
            new City(121.43333, 34.50000, "上海"),
            new City(113.00000, 28.21667, "长沙"),
            new City(114.10000,22.20000, "香港"),
            new City(106.45000, 29.56667, "重庆"),
            new City(114.31667,30.51667, "武汉"),
            new City(104.06667,30.66667, "成都"),
            new City(106.26667, 38.46667, "银川"),
            new City(109.50000, 18.20000, "三亚"),
            new City(112.53333, 37.86667, "太原"),
            new City(91.00000, 29.60000, "拉萨"),
            new City(102.73333,  25.05000, "昆明"),
            new City(126.63333, 45.75000, "哈尔滨"),
            new City(113.65000, 34.76667, "郑州"),
            new City(113.50000, 22.20000, "澳门")
            )
            );
  
    
    public static void main(String[] args) {
        Route route=new Route(new Go().initialCities);
        new SimulateAnneal_Algorithem().FindShorterRoute(route);
    }
}
