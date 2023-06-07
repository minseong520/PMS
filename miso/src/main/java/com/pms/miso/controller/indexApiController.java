package com.pms.miso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.miso.domain.Board_MS;
import com.pms.miso.service.Board_ms_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class indexApiController {
	
	@Autowired
	private Board_ms_service boardService;
	

	@GetMapping("/index/api/{name}/{age}")
	public String index(@PathVariable String name, @PathVariable int age)	{
		System.out.println("인덱스 api 페이지 입니다...");
		
		String jsonData = "{\"name\":\"John Doe\",\"age\":30,\"email\":\"johndoe@example.com\",\"address\":{\"street\":\"123 Main Street\",\"city\":\"New York\",\"state\":\"NY\",\"zipcode\":\"10001\"},\"hobbies\":[\"reading\",\"traveling\",\"cooking\"],\"active\":true}";
		String result = "안녕하세요" + name + "의 나이는 " + age + " 입니다.";
		
		//return jsonDta;
		return result;
	}
		
	@PostMapping("/saveBoard")
	public String saveBoard(@RequestBody Map<String, Object> mapData) {

		String title = (String) mapData.get("title");
		String content = (String) mapData.get("content");
		
		boardService.saveBoard(mapData);
		
		
		return "===>" + title + "/" + content;
	}
	
	
	
	
	@GetMapping("/listBoard")
	public List<Board_MS> listBoard() {
		
		return boardService.listBoard();
	}
	
	
	
	
	
	@PostMapping("/deleteBoard")
	public void deleteBoard(@RequestBody Map<String, Object> mapData) {

		boardService.deleteBoard(mapData);
		

	}
	
	
	
	
	@PostMapping("/updateBoard")
	public void updateBoard(@RequestBody Map<String, Object> mapData) {

		boardService.updateBoard(mapData);
		

	}
}
