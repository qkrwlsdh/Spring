package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.phonebook.PhoneBookDAO;

@Service
public class HomeService {

	@Autowired private PhoneBookDAO dao;
}
