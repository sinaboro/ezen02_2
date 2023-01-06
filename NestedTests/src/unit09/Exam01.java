package unit09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Exam01 {

	public static void main(String[] args) {
		
		String[] num = {"aaa","AAA","ab","cb","ba", "Bbbb"};
		Integer[] n = {5,2,4,3,1};
		Double[] d = {5.1,1.2,2.24,3.1,1.1};
		//정렬 -->기본자료형은 정렬을 해준다.   
		Arrays.stream(num).sorted(Comparator.reverseOrder()).forEach(i-> System.out.println(i));
		
		Arrays.stream(d).sorted().forEach(i-> System.out.println(i));
	}

}
