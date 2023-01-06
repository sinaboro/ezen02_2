package unit08;

import java.util.stream.IntStream;

public class StreamEx03 {
	
	static int sum=0;
	static int odd=0;
	static int even=0;
	public static void main(String[] args) {
		
//		IntStream str = IntStream.rangeClosed(1, 100);
//		str.forEach(i-> sum += i );  ;
		
		IntStream.rangeClosed(1, 100).forEach(i-> sum += i );
		System.out.println("sum : " + sum);

		IntStream.rangeClosed(1, 100).filter(n-> n%2==0).forEach( i-> even += i );
		System.out.println("짝수 합 : " + even);

		IntStream.rangeClosed(1, 100).filter(n-> n%2 != 0).forEach(i-> odd += i );
		System.out.println("홀수 합 : " + odd);
		
	}

}
