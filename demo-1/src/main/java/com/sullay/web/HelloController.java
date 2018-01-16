package com.sullay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage() {
		return "/html/admin.html";
	}
	@RequestMapping(value="/xxx",method=RequestMethod.GET)
	public String xxx() {
		return "/html/hello.html";
	}
	@ResponseBody
	@RequestMapping(value="/login_page",method=RequestMethod.GET)
	public String adminPage() {
		return "xxxxxxxxxxx";
	}
}
