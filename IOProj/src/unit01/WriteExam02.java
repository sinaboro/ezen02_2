package unit01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExam02 {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("c:\\temp2\\test2.db");
			
			byte[] array = 
				{11,20,30,40,50,-12};
			os.write(array);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
