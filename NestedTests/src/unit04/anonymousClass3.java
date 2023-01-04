package unit04;

class Button{
	public static interface ClickListener{
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener click) {
		this.clickListener = click;
	}
	public void click() {
		this.clickListener.onClick();
	}
} 

public class anonymousClass3 {

	public static void main(String[] args) {
		Button btnOk = new Button();
		
		btnOk.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		});
		
		btnOk.click();
		//
		Button btnCancle = new Button();
		btnCancle.setClickListener(()-> {
			
			 {
				System.out.println("Cancle 버튼을 클릭했습니다.");
			}
		});

		btnCancle.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("Cancle 버튼을 클릭했습니다.");
			}
		});

		
		//
		btnCancle.click();   //Cancle 버튼을 클릭했습니다.
	}
	
	
	
	
}

