package unit09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Studnet implements Comparable<Studnet>{
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
	@Override
	public int compareTo(Studnet o) {
		return Integer.compare(java, o.java);
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
		
		list.stream().sorted().
		forEach(n-> System.out.println(n.getName() + " , " + n.getJava()));
	}

}
