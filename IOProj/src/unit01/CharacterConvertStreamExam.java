package unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExam {

	public static void main(String[] args) throws IOException {
		writer("합동참모본부 관계자는 6일 대북 확성기 방송 시설과 관련해 \"대비태세 차원에서 평소 (방송 재개) 준비는 당연히 돼 있다\"며 \"항상 어떤 상황에든 대비해야 하므로 그런 차원에서 준비하고 있다\"고 말했다.\r\n"
				+ "\r\n"
				+ "대북 확성기는 2018년 4월 판문점 선언 이후 군이 5월부터 전방 지역 10여 곳에 설치된 고정식과 이동식 40여 대를 철거한 바 있다.\r\n"
				+ "\r\n"
				+ "장비들은 철거 후 현재 해체된 상태로 보관 중인 것으로 알려졌다. 군은 정부 지침이 있으면 언제든 방송 재개가 가능하도록 상시 점검하는 것으로 전해졌다.\r\n"
				+ "\r\n"
				+ "과거 대북 확성기 방송을 담당했던 국군심리전단이 장비 점검 등 대비태세 유지 임무를 계속 수행하고 있다.\r\n"
				+ "\r\n"
				+ "대북 확성기는 고출력 스피커를 이용해 가요, 뉴스(북한실상 포함), 기상정보 등을 북한 쪽으로 틀어주는 방송 시설이다. 저녁 시간에는 청취 거리가 20㎞ 이상의 성능을 발휘한다.");
		StringBuilder data = read();
		System.out.println(data);
	}
	
	public static void writer(String str) throws IOException {
		OutputStream os = new FileOutputStream("c:/temp2/sample2.txt");
		Writer writer = new OutputStreamWriter(os,"utf-8");
		
		writer.write(str);
		writer.flush();
		writer.close();
		
	}
	
	public static StringBuilder read() throws IOException {
		InputStream is = new FileInputStream("c:/temp2/sample2.txt");
		Reader reader  = new InputStreamReader(is);
		StringBuilder str = new StringBuilder();
		char[] data = new char[30];
		while(true) {
			int num = reader.read(data);
			if(num == -1) break;
			str.append(new String(data,0, num) + "\n");
		}
		reader.close();
		is.hashCode();
		return str;
	}

}
