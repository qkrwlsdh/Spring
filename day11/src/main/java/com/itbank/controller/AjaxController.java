package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.phonebook.PhoneBookDTO;
import com.itbank.service.PhoneBookService;

@RestController
public class AjaxController {

	@Autowired private PhoneBookService pbs;
	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping(value="phonebook", produces="application/json;charset=utf-8")
	public String phoneList() throws JsonProcessingException {
		
		String data = "";
		List<PhoneBookDTO> list = pbs.getPhoneList();
		data = mapper.writeValueAsString(list);
		
		return data;
	}
	
	@PostMapping("phonebook")
	public String add(@RequestBody PhoneBookDTO dto) {
		int row = pbs.insert(dto);
		return row == 1 ? "success" : "failure";
	}
}
