package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("-----------------");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get2()");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto, Model model) {
		model.addAttribute("model", dto);
		log.info("dto : " + dto);
		return "ex01";
	}
	
	@GetMapping("/list")
	public String ex02List(ArrayList<String> ids) {
		log.info(ids);
		return "ex02List";
	}
	
	@InitBinder
	public void intiBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO dto) {
		log.info("todo : " + dto);
		return "ex03";
	}
	
}
