package unit10;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Exam05 {

	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5,6,7,8,9,10};
		
		
		//카운트
		long count =  Arrays.stream(intArr).filter(n->n%2==0).count();
		System.out.println("짝수는 : " + count);

		//합
		int sum =  Arrays.stream(intArr).filter(n->n%2==0).sum();
		System.out.println("짝수 합 : " + sum);

		//평균
		OptionalDouble op =  Arrays.stream(intArr).filter(n->n%2==0).average();
		double avg = op.getAsDouble();
		System.out.println("짝수 평균 : " + avg);

		//평균
		double avg2 = Arrays.stream(intArr).filter(n->n%2==0).average().getAsDouble();
		System.out.println("짝수 평균 : " + avg2);

		//최대값
		int max = Arrays.stream(intArr).filter(n->n%2==0).max().getAsInt();
		System.out.println("짝수 최대값 : " + max);

		int first = Arrays.stream(intArr).filter(n->n%2==0).findFirst().getAsInt();
		System.out.println("짝수 처음 값 : " + first);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
