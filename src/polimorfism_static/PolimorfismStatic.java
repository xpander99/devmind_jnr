package polimorfism_static;

public class PolimorfismStatic {
	private static double calc(int a,int b) {
		return a+b;
	}
	private static double calc(double a, double b) {
		return (a+b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calc(3,4)); // calls calc(int,int)
		System.out.println(calc(3.4,3.5)); // calls calc(double,double)
	}

}
