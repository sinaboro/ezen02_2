package unit03;

public class InnerClass {

	public static void main(String[] args) {
		A a = new A();
		a.useB();
	}

}

class A{
	
	int aNum = 10;
	
	void useB() {
		int bNum = 20;
		
//		bNum += 10;
		
		class B{
			
			int num=1;
			
			B(){
				System.out.println("B()");
			}
			
			void method1() {
				aNum += 1;
				System.out.println("method1() : " + aNum);
				
				//bNum +=1;
				
				System.out.println("method1() : " + bNum);
			}
		}
		
		B b = new B();
		System.out.println(b.num);
		b.method1();
	}
	

	
}