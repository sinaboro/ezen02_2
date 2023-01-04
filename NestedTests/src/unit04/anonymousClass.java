package unit04;

public class anonymousClass {

	public static void main(String[] args) {
		SampleRomote sr = new SampleRomote();
		sr.trunOff();
		sr.trunOn();
	}

}

interface RemoteControl{  //인터페이스 
	void trunOn();
	void trunOff();
}

class SampleRomote implements RemoteControl{

	@Override
	public void trunOn() {
		System.out.println("전원 온");
	}

	@Override
	public void trunOff() {
		System.out.println("전원 오프");
	}
	
}