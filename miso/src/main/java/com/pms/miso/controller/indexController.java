package com.pms.miso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@GetMapping("/index")
	public String index()	{
		System.out.println("인덱스 페이지 입니다...");
		return "index";
		
	}	
	
	@GetMapping("/about")
	public String about()	{
		System.out.println("인덱스 페이지 입니다...");
		return "about";
	}

	@GetMapping("/board")
	public String board()	{
		System.out.println("게시판입니다.");
		return "board";		

	
	}
}


