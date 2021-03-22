package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.phonebook.PhoneBookDAO;
import com.itbank.phonebook.PhoneBookDTO;

@Service
public class PhoneBookService {
	
	@Autowired
	private PhoneBookDAO dao;

	public List<PhoneBookDTO> getPhoneBookList() {
		
		return dao.selectList();
	}

	public int insertPhoneBook(PhoneBookDTO dto) {
		return dao.insertPhoneBook(dto);
	}

	public int deletePhoneBook(int idx) {
		
		return dao.deletePhoneBook(idx);
	}

	
}
