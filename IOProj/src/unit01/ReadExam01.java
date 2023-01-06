package unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExam01 {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("c:/temp2/test1.db");
			
			while(true) {
				int data = is.read();
				if(data == -1)break;
				System.out.println(data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
