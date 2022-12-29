package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc ;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				
				);
	}

	@Test
	public void testRegister() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "post 글 제목")
					.param("content", "post 글 내용")
					.param("writer", "post")
				)
				.andReturn()
				.getModelAndView()
				.getViewName()
				
				);
	}

	@Test
	public void testGet() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "41")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap()
				
				);
	}
	
	@Test
	public void testModify() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
					.param("bno", "41")
					.param("title", "modify 글 제목")
					.param("content", "modify 수정된 내용")
					.param("writer", "modify")
				)
				.andReturn()
				.getModelAndView()
				.getViewName()
				
				);
	}

	@Test
	public void testDelete() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
				.param("bno", "41")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap()
				
				);
	}
	
	
}
