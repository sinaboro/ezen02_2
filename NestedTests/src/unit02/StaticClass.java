package unit02;

public class StaticClass {
	public static void main(String[] args) {
		A.B b = new A.B();
		b.method1();
		
	}
}

class A{
	
	A() {}
	
	static class B{
		
		B() {
			System.out.println("B()");
		}
		
		void method1() {
			System.out.println("method1()");
		}
	}
};


