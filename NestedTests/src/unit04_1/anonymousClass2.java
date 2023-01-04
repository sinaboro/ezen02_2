package unit04_1;

interface Person{
	void infoMember(String name, int age);
}

class Test00 implements Person{

	@Override
	public void infoMember(String name, int age) {
		System.out.println(name + " 나이는 " + age);
		
	}
	
}
public class anonymousClass2 {

	public static void main(String[] args) {
		
		Person p = new Person(){
			@Override
			public void infoMember(String name, int age) {
				System.out.println(name + " 나이는 " + age);
			}
		};
		p.infoMember("홍길동", 20);
	}
}

