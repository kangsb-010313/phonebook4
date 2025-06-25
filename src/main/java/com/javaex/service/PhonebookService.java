package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;

@Service
public class PhonebookService {
	
	//필드
	@Autowired
	private PhonebookDAO phonebookDAO;
	
	//리스트 가져오기
	public List<PersonVO> exeGetPhonebookList(){
		
		System.out.println("PhonebookService.exeGetPhonebookList()");
		
		List<PersonVO> phonebookList = phonebookDAO.personSelect();
		
		return phonebookList;
	}
	
	//리스트 등록하기
	public int exeGetPhonebookAdd(PersonVO personVO) {
		
		System.out.println("PhonebookService.exeGetPhonebookAdd()");
	
		int count = phonebookDAO.personInsert(personVO);
		
		return count;
		
	}
	
	//리스트 삭제하기
	public int exeGetPhonebookDelete(int no) {
		System.out.println("PhonebookService.exeGetPhonebookDelete()");
		
		int count = phonebookDAO.personDelete(no);
		
		return count;
		
	}
	
	//리스트 수정폼
	public PersonVO exeGetPhonebookMform(int no) {
		System.out.println("PhonebookService.exeGetPhonebookMform()");
		
		PersonVO personVO = phonebookDAO.personSelectOne(no);
	
		return personVO;
	}
	
	//리스트 수정하기
	public int exeGetPhonebookUpdate(PersonVO personVO) {
		System.out.println("PhonebookService.exeGetPhonebookUpdate)");

		int count = phonebookDAO.personUpdate(personVO);
	
		return count;
	}
}
