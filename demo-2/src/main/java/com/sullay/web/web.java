package com.sullay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class web {
	@RequestMapping(value="/*",method=RequestMethod.GET)
	public String login(){
		return "/login.html";
	}
}
