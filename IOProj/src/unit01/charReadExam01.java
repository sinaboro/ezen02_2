package unit01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class charReadExam01 {

	public static void main(String[] args) throws IOException {
		
		Reader reader = new FileReader("c:/temp2/sample1.txt");
		
		while(true) {
			int data = reader.read();
			if(data == -1) break;
			System.out.println((char)data);
		}
		
		reader.close();
		System.out.println();
		
		reader = new FileReader("c:/temp2/sample1.txt");
		char[] data = new char[3];
		
		while(true) {
			int num = reader.read(data);
			if(num==-1) break;
			for(int i=0; i<num; i++)
				System.out.print(data[i]);
			System.out.println();
		}
		
	}
}
