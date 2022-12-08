package com.napmkmk.mkboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping(value = "/index")
	@ResponseBody //본문에 아래 들어가 있는 텍스트 출력됨
	public String index() {
		
		return "게시판 프로젝트입니다.";
	}
}
