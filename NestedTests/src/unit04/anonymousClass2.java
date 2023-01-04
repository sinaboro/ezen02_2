package unit04;

interface Cal{
	int func(int n1, int n2);
	
}

class Add implements Cal{

	@Override
	public int func(int n1, int n2) {
		return n1+n2;
	}
	
}
public class anonymousClass2 {

	public static void main(String[] args) {
		
		Cal cal = new Cal(){

			@Override
			public int func(int n1, int n2) {
				return n1+n2;
			}
			
		}; //더하기
		
		int sum = cal.func(1, 3);
		System.out.println(sum);
		
		cal = new Cal() {
			
			@Override
			public int func(int n1, int n2) {
				return n1-n2;
			}
		};
		sum = cal.func(10, 5);
		System.out.println(sum);
		
//		Cal cal = ?;  //곱하기
//		Cal cal = ?;  //나누기
	}

}

