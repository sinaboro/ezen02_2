package unit07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("이상호");
		list.add("이상호");
		list.add("이상호");
		list.add("박선화");
		list.add("이은혜");
		list.add("김윤아");
		list.add("정재환");
		list.add("이예찬");
			
//		Stream<String> stream  = list.stream();
//		stream.distinct().forEach(name-> System.out.println(name));
		
		Stream<String> parallstream = list.parallelStream();
		parallstream.forEach(name-> System.out.println(name + " : " 
				+ Thread.currentThread().getName()));
		
		IntStream.rangeClosed(1, 20).parallel()
				.forEach(i-> System.out.println(i));
	}

}
