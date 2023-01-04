package unit01;

public class InstanceClass {

	public static void main(String[] args) {
		A a = new A();
		a.useB();
		
		A.B b = a.new B();
		b.method1();
	}

}

class A{
	int num=100;
	A(){
		System.out.println("A()생성자");
	}
	
	void func() {
		System.out.println("A-func()");
	}
	
	void useB() {
		B b = new B();
		b.method1();
		System.out.println(b.num);
	}
	
	class B{
		
		int num=10;
		
		B(){
			System.out.println("B()생성자");
		}
		
		void func() {
			System.out.println("B-func()");
		}
		void method1() {
			System.out.println("-----------------------");
			System.out.println("method1()" + num);
			System.out.println("method1-1()" + A.this.num);
			A.this.func();
		}
		
	}
}