package unit01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExam03 {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("c:\\temp2\\test3.db");
			
			byte[] array = {10,20,30,40,50,-128};
			os.write(array,2, 4); //?
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
