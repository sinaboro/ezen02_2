package unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadExam03 {

	public static void main(String[] args) throws IOException {
		
		String original = "c:/temp2/img1.jpg";
		String target = "c:/temp2/test1_1.jpg";
		
		InputStream is = new FileInputStream(original);
		OutputStream os = new FileOutputStream(target);
		
		byte[] data = new byte[1024];
		
//		while(true) {
//			int num = is.read(data);
//			if(num == -1) break;
//			os.write(data, 0, num);
//		}
		
		is.transferTo(os);
		
		os.flush();
		is.close();
		os.close();
		System.out.println("복사 완료!!");
	}

	

}
