package unit08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx04 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("this is a java");
		list.add("I am a best programer");
		
		list.stream().flatMap(d -> Arrays.stream(d.split(" "))).
		forEach(n->System.out.println(n));
		
		System.out.println("------------------------");
		list.stream().flatMap(d -> Stream.of(d.split(" "))).
		forEach(n->System.out.println(n));
		
		
	}

}
