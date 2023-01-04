package unit05;

import java.util.function.Function;

//Function 함수형 인터페이스 작성한다...
//interface Function {
//	double apply(double x, double y);
//}

public class RamdaEx00 {

	public static void main(String[] args) {
		
		Double result = calc( x-> x );
		
		System.out.println("result : " + result);
	}

	public static double calc(Function fun) {
		double x = 10;
		return  (double) fun.apply(x);
	}
}


