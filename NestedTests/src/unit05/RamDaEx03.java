package unit05;

@FunctionalInterface
interface Calculable{
	void calculate(int n1, int n2);
	static void func() {};
	default void func2() { System.out.println("aaaa");}  
}

class CalTests implements Calculable{

	@Override
	public void calculate(int n1, int n2) {
		System.out.println("x / y = " + (double)n1/n2);
	}
	
}
public class RamDaEx03 {

	public static void main(String[] args) {
		
		action((x,y)-> {
			int result = x+y;
			System.out.println("x+y = " + result);
		});
		
		System.out.println("---------------");
		action(new CalTests());
		System.out.println("---------------");
		
		action((o1,o2)-> {
			int result = o1*o2;
			System.out.println("o1*o2 = " + result);
		});
		
	}
	
	public static void action(Calculable cal) {
		int x=10;
		int y=5;
		cal.calculate(x, y);
	}
}
