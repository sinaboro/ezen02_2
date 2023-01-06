package unit07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student{
	String name;
	int java;
	int jsp;
	
	public Student(String name, int java,int jsp) {
		this.name = name;
		this.java = java;
		this.jsp = jsp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getJava() {
		return java;
	}
	public int getJsp() {
		return jsp;
	}
}

public class StreamEx02 {

	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(
				new Student("이상호", 15,100),
				new Student("이예찬", 19,99),
				new Student("황규성", 8,10)
		);
		
		Stream<Student> studentstream = list.stream();
//		IntStream intstudent = studentstream.mapToInt(s-> s.getJsp());
//		OptionalDouble opavg = intstudent.average();
//		double avg = opavg.getAsDouble();
		
		int avg = studentstream.mapToInt(s->s.getJsp()).sum();
		
		System.out.println("avg : " + avg);
		
	}

}
