
package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVO;

@Repository
public class PhonebookDAO {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	
	// 전체리스트 가져오기
	public List<PersonVO> personSelect() {
		
		System.out.println("PhonebookDAO.personSelect()");
		
		//리스트준비
		List<PersonVO> personList = sqlSession.selectList("phonebook.selectList2");
		
		return personList;
		
	}
	
	
	// 1명 정보 가져오기
	public PersonVO personSelectOne(int personId) {
		
		System.out.println("PhonebookDAO.personSelectOne()");
		
		PersonVO personVO = sqlSession.selectOne("phonebook.selectOne", personId);
		
		Map<String, Object> map = sqlSession.selectOne("phonebook.selectOne2", personId);
		
		System.out.println(map);
		
		
		
		return personVO;
		
	}
	
	
	//사람(주소) 등록
	public int personInsert(PersonVO personVO) {
		System.out.println("PhonebookDAO.personInsert()");

		int count = sqlSession.insert("phonebook.insert", personVO);
		
		return count;
	}
	//사람(주소) 등록Map
	public int personInsert2(Map<String, String> personMap) {
		System.out.println("PhonebookDAO.personInsert2()");
		System.out.println(personMap);

		//int count = sqlSession.insert("phonebook.insert", personVO);
		int count = sqlSession.insert("phonebook.insert2", personMap);
		return count;
	}
	
	
	//사람(주소) 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDAO.personDelete()");
		
		int count = sqlSession.delete("phonebook.delete", no);
		
		return count;
	}
	
	
	//사람(주소) 수정
	public int personUpdate(PersonVO personVO) {
		System.out.println("PhonebookDAO.personUpdate()");
		
		int count = sqlSession.update("phonebook.update", personVO);
		
		return count;
	}
	
	
}
