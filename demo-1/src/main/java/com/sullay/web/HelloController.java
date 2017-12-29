package com.sullay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage() {
		return "/html/hello.html";
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String adminPage() {
		return "/html/admin.html";
	}
	@RequestMapping(value="/dba",method=RequestMethod.GET)
	public String dbaPage() {
		return "/html/admin.html";
	}
}
