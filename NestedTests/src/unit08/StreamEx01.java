package unit08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("이상호");
		list.add("이상호");
		list.add("이상호");
		list.add("박선화");
		list.add("이은혜");
		list.add("김윤아");
		list.add("정재환");
		list.add("이예찬");
			
		//중복제거
		list.stream().distinct().forEach(name-> System.out.println(name));
		System.out.println();
		
		//이로 시작하는 데이타만 추출
		list.stream().distinct().filter(name->name.startsWith("이")).
		forEach(name->System.out.println(name)) ;
		System.out.println();
		
	}

}
