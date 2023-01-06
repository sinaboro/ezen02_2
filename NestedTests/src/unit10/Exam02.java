package unit10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Studnet {
	String name;
	int java;
	public Studnet(String name, int java) {
		this.name = name;
		this.java = java;
	}
	public String getName() {
		return name;
	}
	public int getJava() {
		return java;
	}
}
public class Exam02 {

	public static void main(String[] args) {
		
		List<Studnet> list = new ArrayList<>();
		list.add(new Studnet("이상호", 45));
		list.add(new Studnet("박선화",  55));
		list.add(new Studnet("이은혜" , 43));
		list.add(new Studnet("김윤아", 56));
		list.add(new Studnet("정재환", 38));
		list.add(new Studnet("이예찬", 90));
		
		list.stream().
		sorted((x,y)-> Integer.compare(x.getJava(), y.getJava())).
		forEach(n-> System.out.println(n.getName() + " , " + n.getJava()));

		System.out.println("-----------------------------------------------");
		list.stream().
		sorted((x,y)-> Integer.compare(y.getJava(), x.getJava())).
		forEach(n-> System.out.println(n.getName() + " , " + n.getJava()));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
