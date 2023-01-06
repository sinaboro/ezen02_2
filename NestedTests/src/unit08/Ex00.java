package unit08;

@FunctionalInterface
interface Function<T>{
	public double apply(T t);
}

@FunctionalInterface
interface Function2<T>{
	public int apply(T t);
}

class Eng implements Function<Student2>{

	@Override
	public double apply(Student2 t) {
		return t.getEngScore();
	}
}

class Student2{
	private String name;
	private int engScore;
	private int mathScore;
	public Student2(String name, int engScore, int mathScore) {
		this.name = name;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	public String getName() { 	return name; }
	public int getEngScore() { 	return engScore; }
	public int getMathScore() { return mathScore; }
	
	
}
public class Ex00 {

	private static Student2[] students  = {
			new Student2("홍길동", 90, 95),
			new Student2("이순신", 96, 98)
	};
	
	//avg() 메소드 작성.
	public static double avg(Function<Student2> t) {
		
		int sum = 0;
		for (Student2 student : students) {
			sum += t.apply(student);
		}
		return (double)sum/students.length;
	}
	
	public static void main(String[] args) {
		
		double engAvg = avg(s-> s.getEngScore());
		System.out.println("영어 점수 평균 = " + engAvg);

//		double mathAvg = avg(s->s.getMathScore());
		double mathAvg = avg(Student2::getMathScore); //메소드참조
		System.out.println("영어 점수 평균 = " + mathAvg);
		
	}

}












