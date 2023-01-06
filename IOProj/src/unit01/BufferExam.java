package unit01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExam {

	public static void main(String[] args) throws Exception {

		//버퍼쓰기전...
		String original = "c:/temp2/img2.jpg";
		String target = "c:/temp2/img2_1.jpg";
		
		FileInputStream fis = new FileInputStream(original);
		FileOutputStream fos = new FileOutputStream(target);
		
		long nonBufferTime = copy(fis, fos);
		System.out.println("nonBuffer : " +nonBufferTime);

		//버퍼쓰기 사용...
		String original2 = "c:/temp2/img2.jpg";
		String target2 = "c:/temp2/img2_2.jpg";
		
		FileInputStream fis2 = new FileInputStream(original2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		FileOutputStream fos2 = new FileOutputStream(target2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long useBufferTime = copy(bis, bos);
		System.out.println("useBuffer : " +useBufferTime);
		fis.close();
		fos.close();
	}
	
	public static long copy(InputStream fis, OutputStream fos) throws IOException {
		long start = System.nanoTime();
		
		while(true) {
			int data = fis.read();
			if(data == -1) break;
			fos.write(data);
		}
		fos.flush();
		long end = System.nanoTime();
		return (end-start);
	}

}
