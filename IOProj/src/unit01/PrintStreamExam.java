package unit01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExam {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:\\temp2\\printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("김길동");
		ps.println("홍길동전 허균작.");
		ps.printf("|%10d|%-10s|%10s\n", 1, "홍길동", "허균");
		ps.printf("|%10d|%-10s|%10s\n", 2, "이순신", "해군");
		
		ps.flush();
		ps.close();
	}

}
