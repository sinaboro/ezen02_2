package unit06;

public class MethodRef01 {

	public static void main(String[] args) {
		
		Person person =  new Person();
		
		person.action( (x,y)-> x+y );
		
		person.action((x,y)-> Computer.staticMethod(x, y));
	
		//클래스명::정적메소드
		person.action(Computer::staticMethod);
		
		System.out.println("-------------------------------");
		Computer com = new Computer();
		
		//person.action(??);
		
		person.action( (x,y)-> com.InstanceMethod(x, y));
		
		person.action(com::InstanceMethod);
	}

}

@FunctionalInterface
interface Calcuable{
	double calc(double x, double y);
}

class Person{
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("result : " + result);
	}
}

class Computer{
	public static double staticMethod(double x, double y) {
		return x+y;
	}
	public double InstanceMethod(double x, double y) {
		return x+y;
	}
	
	
}
