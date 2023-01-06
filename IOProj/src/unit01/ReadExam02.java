package unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExam02 {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("c:/temp2/test2.db");
			
			byte[] data = new byte[100];
			
			while(true) {
				int num = is.read(data);
				
				System.out.println("num : " + num);
				if(num == -1) break;
				
				for(int i=0; i<num; i++) {
					System.out.println(data[i]);
				}
			}
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
