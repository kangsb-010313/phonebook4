package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
		//int count = phonebookDAO.personInsert(personVO);
		
		/*
		 가정 데이터가 여기서 생김. 여기서 묶어야 됨
		 1.vo를 만들고 묶으면 된다
		 2.map으로 묶는다(이번에만 쓴다) <-- 지금은 여기에 해당
		*/
		
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", "강수빈");
		personMap.put("hp", "010");
		personMap.put("company", "02");
		
		int count = phonebookDAO.personInsert2(personMap);
		
		return count;
		
	}
	
	//리스트 삭제하기
	public int exeGetPhonebookDelete(int no) {
		System.out.println("PhonebookService.exeGetPhonebookDelete()");
		
		int count = phonebookDAO.personDelete(no);
		
		return count;
		
	}
	
	//1명 리스트 가져오기(리스트 수정폼)
	public PersonVO exeGetPhonebookMform(int personId) {
		System.out.println("PhonebookService.exeGetPhonebookMform()");
		
		PersonVO personVO = phonebookDAO.personSelectOne(personId);
	
		return personVO;
	}
	
	//리스트 수정하기
	public int exeGetPhonebookUpdate(PersonVO personVO) {
		System.out.println("PhonebookService.exeGetPhonebookUpdate)");

		int count = phonebookDAO.personUpdate(personVO);
	
		return count;
	}
}
