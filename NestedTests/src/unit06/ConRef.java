package unit06;

public class ConRef {

	public static void main(String[] args) {
		Person2 person = new Person2();
		
		Member m1 = person.getMember1(new test1());
		System.out.println(m1);
		System.out.println("--------------------------");
		
		Member m2 = person.getMember1(
				id-> new Member(id)				
		);
		System.out.println("M2 = " + m2);
		System.out.println("--------------------------");

		Member m3 = person.getMember1(Member::new);
		System.out.println("M3 = " + m3);
		System.out.println("--------------------------");
	}
}

@FunctionalInterface
interface Creatable1{
	public Member create(String id);
}

class test1 implements Creatable1{

	@Override
	public Member create(String id) {
		return new Member(id);
	}
	
}

@FunctionalInterface
interface Creatable2{
	public Member create(String id, String name);
}

class Member{
	private String id, name;
	
	public Member(String id) {
		this.id = id;
	}
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
}

class Person2{
	
	public Member getMember1(Creatable1 creatable1) {
		String id = "winter";
		Member member = creatable1.create(id);
		return member;
	}
	
	public Member getMember2(Creatable2 creatable2) {
		String id = "winter";
		String name = "한겨울";
		Member member = creatable2.create(id,name);
		return member;
	}
}

















