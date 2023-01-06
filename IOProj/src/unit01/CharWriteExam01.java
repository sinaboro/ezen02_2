package unit01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharWriteExam01 {

	public static void main(String[] args) throws IOException {
		
		Writer writer = new FileWriter("c:/temp2/sample1.txt"); 
		
		char a = 'A';
		writer.write(a);
		
		char b = 'B';
		writer.write(b);
		
		char[] arr = {'C', 'D', 'E'};
		
		writer.write(arr);
		writer.write("FGH");
		
		writer.flush();
		writer.close();
				
	}

}
