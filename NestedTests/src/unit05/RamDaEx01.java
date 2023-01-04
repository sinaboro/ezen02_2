package unit05;


interface Cal{
	public int calc(int n1, int n2);
}

interface Cal3{
	public int calc(int n);  // n*n
}

//public int calc(int n1, int n2) {
//	return n1*n2;
//}
public class RamDaEx01 {

	public static void main(String[] args) {
		
		Cal cal = (int n1, int n2)-> {
				    return n1 +n2; 
			      };
		System.out.println(cal.calc(10, 20));

		
		cal = ( n1,  n2)-> {
				return n1 -n2; 
		};
		System.out.println(cal.calc(10, 20));

		cal = ( n1,  n2)-> n1 *n2; 
		System.out.println(cal.calc(10, 20));

		cal = (n1,  n2)-> n1 /n2; 
		System.out.println(cal.calc(10, 20));
		
		Cal3 c =  n -> n*n;
		System.out.println(c.calc(10));
	}
	
}
