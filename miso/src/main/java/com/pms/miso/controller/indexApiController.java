package com.pms.miso.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class indexApiController {

	@GetMapping("/index/api/{name}/{age}")
	public String index(@PathVariable String name, @PathVariable int age)	{
		System.out.println("인덱스 api 페이지 입니다...");
		
		String jsonData = "{\"name\":\"John Doe\",\"age\":30,\"email\":\"johndoe@example.com\",\"address\":{\"street\":\"123 Main Street\",\"city\":\"New York\",\"state\":\"NY\",\"zipcode\":\"10001\"},\"hobbies\":[\"reading\",\"traveling\",\"cooking\"],\"active\":true}";
		String result = "안녕하세요" + name + "의 나이는 " + age + " 입니다.";
		
		//return jsonDta;
		return result;
	}
	
	@PostMapping("/index2/api")
	public String index2(@RequestBody Map<String, Object> mapData )	{
		
		System.out.println("name : " + mapData.get("name").toString());
		System.out.println("age : " + mapData.get("age").toString());
		
		String name = mapData.get("name").toString();
		String age = mapData.get("age").toString();
		String result = "안녕하세요 " + name + " 의 나이는 " + age + " 입니다.";
		
		return result;
	}
	
	
	
	
}
