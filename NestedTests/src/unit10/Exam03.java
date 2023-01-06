package unit10;

import java.util.Arrays;

public class Exam03 {

	public static void main(String[] args) {
		int[] intArr = {2,8,10,3};
		
	 	boolean flag =  Arrays.stream(intArr).allMatch(n->n%2==0);
	 	System.out.println("모두 2의 배수 ? " + flag);

	 	flag =  Arrays.stream(intArr).anyMatch(n->n%5==0);
	 	System.out.println("모두 5의 배수 ? " + flag);

	 	flag =  Arrays.stream(intArr).noneMatch(n->n%6==0);
	 	System.out.println("모두 6의 배수 ? " + flag);
	}

}
