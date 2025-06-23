package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhonebookController {
	
	//필드
	
	
	//생성자
	
	
	//메소드 gs
	
	
	//메소드 일반
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("aaa");
		
		return "";
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		System.out.println("/phonebook4/list");
		
		return "";
	}
	
	@RequestMapping(value="/wform", method= {RequestMethod.GET, RequestMethod.POST})
	public String wform() {
		System.out.println("/phonebook4/wform");
		
		return "";
	}
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write() {
		System.out.println("/phonebook4/write");
		
		return "";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete() {
		System.out.println("/phonebook4/delte");
		
		return "";
	}

	@RequestMapping(value="/mform", method= {RequestMethod.GET, RequestMethod.POST})
	public String mform() {
		System.out.println("/phonebook4/mform");
		
		return "";
	}
	
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify() {
		System.out.println("/phonebook4/modify");
		
		return "";
	}
	
}
