package unit08;

import java.util.function.BiFunction;
import java.util.function.Predicate;




public class Example {
	
	private static int[] scores={20,40,10};
	
	public static int maxOrMin(BiFunction<Integer, Integer, Integer> operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}
	
	public static int add(BiFunction<Integer, Integer, Integer> op) {
				
		return op.apply(10, 20);
		
	}
	
	public static boolean checkAge(Predicate<Integer> pre) {
		return pre.test(15);
	}
	
	public static void main(String[] args) {
		
		//최대값 구하기
		int max = maxOrMin( (i, j)-> (i > j) ? i : j );

		
		//최소값 구하기
		int min = maxOrMin( (i, j)-> (i < j) ? i : j  );
		
		System.out.println("최대값 : " + max +  ", 최소값 : " + min);
		
		int sum = add((i,j)-> i-j);
		System.out.println("minus  = " + sum);
		
		boolean chk = checkAge((age) -> age>20? true : false );
		
		if(chk) System.out.println("성인");
		else System.out.println("미성인");
		
		
		
		
		
		
		
		
		
		
		
	}
}
