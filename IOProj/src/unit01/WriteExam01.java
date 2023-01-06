package unit01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExam01 {

	public static void main(String[] args) {
		OutputStream os =null;
		try {
			os = new FileOutputStream("c:/temp2/test1.db");
//			int a=10;
//			int b=20;
//			byte c=30;
			byte d = -30;
			byte e = 110;
			byte f = -100;
			
//			os.write(a);
//			os.write(b);
//			os.write(c);
			os.write(d);
			os.write(e);
			os.write(f);
			
			
			os.flush();
			System.out.println("저장성공");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
