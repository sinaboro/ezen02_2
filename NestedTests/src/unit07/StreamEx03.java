package unit07;

import java.util.stream.IntStream;

public class StreamEx03 {
	
	static int sum;
	public static void main(String[] args) {
		
		IntStream str = IntStream.rangeClosed(1, 100);
		str.forEach(i-> sum += i );
	
		System.out.println("sum : " + sum);
		
	}

}
