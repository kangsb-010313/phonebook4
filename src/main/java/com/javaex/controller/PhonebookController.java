package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVO;

@Controller
public class PhonebookController {
	
	//필드
	@Autowired
	private PhonebookService phonebookService;
	
	//생성자
	
	
	//메소드 gs
	
	
	//메소드 일반	
	//리스트 가져오기
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list");
		
		List<PersonVO> phonebookList = phonebookService.exeGetPhonebookList();

		model.addAttribute("pList", phonebookList);
		
		return "list";
	}
	
	//등록폼
	@RequestMapping(value="/wform", method= {RequestMethod.GET, RequestMethod.POST})
	public String wform() {
		System.out.println("PhonebookController.wform");
		
		return "writeform";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVO personVO) {
		System.out.println("PhonebookController.write");
		
		System.out.println(personVO);
		
		phonebookService.exeGetPhonebookAdd(personVO);
		
		return "redirect:/list";
	}
	
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController.delte");
		
		phonebookService.exeGetPhonebookDelete(no);
		
		return "redirect:/list";
	}

	//수정폼
	@RequestMapping(value="/mform", method= {RequestMethod.GET, RequestMethod.POST})
	public String mform(@RequestParam(value = "no") int personId, Model model) {
		System.out.println("PhonebookController.mform");
	    
	    PersonVO personVO = phonebookService.exeGetPhonebookMform(personId);
	    
	    model.addAttribute("personVO", personVO);
		
		return "modifyform";
	}
	
	//수정
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVO personVO) {
		System.out.println("PhonebookController.modify");
		
		phonebookService.exeGetPhonebookUpdate(personVO);
		
		return "redirect:/list";
	}
	
}
