package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTxServiceTests {
	
	@Autowired
	private SampleTxService service;
	
	@Test
	public void testLong() {
		String str = "펌웨어를 좋아하긴 하는데 제가 리눅스쪽도 못하고 수학도 겉핥기만 하다보니 이분야에서 썩 비전이 없어보여 전직을 생각하고 있습니다\r\n"
				+ "\r\n"
				+ "공부를 해보니 자바,스프링,깃 이정도만 해도 충분히 시간이 촉박할 것 같아서.. 다른건 못할것같은데..";
		
		log.info("Str ==> " + str.getBytes().length);
		service.addData(str);
	}
}
