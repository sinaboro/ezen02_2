package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info("New reply===> " + vo);
		int insertCount = service.Register(vo);
//		log.info("insertCount : " + insertCount);
//		return  insertCount==1? new ResponseEntity<String>("success", HttpStatus.OK):
//			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		String msg=null;
		HttpStatus status =null;
		if(insertCount == 1) {
			msg = "Register Success";
			status = HttpStatus.OK;
		}else {
			msg = "댓글 등록이 실패했습니다.";
			status = HttpStatus.NOT_MODIFIED;
		}
		
		return new ResponseEntity<String>(msg, status);
		
	}
	
	@GetMapping(value = "/{rno}", 
			produces = { MediaType.APPLICATION_XML_VALUE, 
					     MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {

		log.info("get: " + rno);

		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/pages/{bno}/{page}", produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, 
			@PathVariable("bno") Long bno){
		
		log.info("getList");
		Criteria cri = new Criteria(page, 10);
		log.info("cri : " + cri);
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
			
	}

	@DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		log.info("remove ==> " + rno);
		return service.remove(rno)==1 ? new ResponseEntity<String>("delete success", HttpStatus.OK):
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@RequestMapping(method = {RequestMethod.PUT,RequestMethod.PATCH},value = "/{rno}", 
			consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
										@PathVariable("rno") Long rno){
		
		log.info("modify===> " + rno + " : " + vo);
		vo.setRno(rno);
		return  service.modify(vo)==1? new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
