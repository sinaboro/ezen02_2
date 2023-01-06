package unit10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Exam04 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		
		/*
		 * double avg = list.stream().mapToInt( n -> n.intValue()).
		 * average().getAsDouble(); System.out.println(avg);
		 */
		
		//방법1
		OptionalDouble opD = list.stream().mapToInt( n -> n.intValue()).
				 average();
		if(opD.isPresent()) {
			System.out.println("평균 : " + opD.getAsDouble());
		}else {
			System.out.println("평균 : " + 0.0);
		}

		//방법2
		double avg = list.stream()
				.mapToInt( n -> n.intValue())
				.average()
				.orElse(0.0);
		System.out.println("평균 : " + avg);

		//방법3
		list.stream()
			.mapToInt( n -> n.intValue())
			.average()
			.ifPresent(n-> System.out.println("평균 : " + n));
		
		
		
		
		
	}

}
