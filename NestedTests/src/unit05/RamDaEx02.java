package unit05;


interface Cal2{  //추상메소드 1개 있는 경우 함수형인터페이스 부른다
	public int calc(int n1, int n2);
}

public class RamDaEx02 {

	public static void main(String[] args) {
		
		Cal2 cal = 
			(int n1, int n2)-> {
				return n1 +n2; 
			};
		
		
		System.out.println(cal.calc(10, 20));

		cal = ( n1, n2)-> {
				return n1 -n2; 
			};
		System.out.println(cal.calc(10, 20));

		cal = 
			(n1, n2)-> {
				System.out.println("람다연습");
				return n1 *n2; 
			};
		System.out.println(cal.calc(10, 20));

		cal = (n1, n2)->  n1 /n2; 
		
		System.out.println(cal.calc(10, 20));
		
		
		
		
	}
	
}
