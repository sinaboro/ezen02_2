package unit01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutStreamExam {

	public static void main(String[] args) throws IOException  {
		FileOutputStream fos = new FileOutputStream("c:/temp2/inout.db");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("정재환");
		dos.writeDouble(99.9);
		dos.writeInt(98);
		
		dos.flush();
		dos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("c:/temp2/inout.db");
		DataInputStream dis = new DataInputStream(fis);
		
		String name = dis.readUTF();
		double score = dis.readDouble();
		int order = dis.readInt();
		
		System.out.println(name + " , " + score + " , " + order);
		
		dis.close();
	}

}
