package unit08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student{
	private String name;
	private int java;
	private int jsp;
	
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
				new Student("황규성", 18,80),
				new Student("정재환", 15,98),
				new Student("전성수", 8,75)
		);
		
		
		// jsp점수가 90이상만 이름 출력
		list.stream().filter(n->n.getJsp()>=90).filter(n->n.getJava()>15)
		.forEach( s -> 
		System.out.println(s.getName() +", " +s.getJava() + " , " + s.getJsp()) );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
