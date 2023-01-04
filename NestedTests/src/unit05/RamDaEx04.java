package unit05;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/*class Sample00 implements IntUnaryOperator{
	
	@Override
	public int applyAsInt(int operand) {
		return (int)(Math.random()*5)+1;
	}
}*/

public class RamDaEx04 {

	public static void main(String[] args) {
		
		int[] arr = new int[5]; //? ? ? ? ?
		
		Arrays.setAll(arr, 	operand -> (int)(Math.random()*5)+1 ); 
		
//		Arrays.setAll(arr,  new Sample00());  //1~5
//		Arrays.setAll(arr, (i)-> (int)(Math.random()*5)+1 );  //1~5
		
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	
}
