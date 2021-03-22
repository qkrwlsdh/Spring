package com.itbank.phonebook;

import java.util.List;

public interface PhoneBookDAO {

	List<PhoneBookDTO> selectList();

	int insertPhoneBook(PhoneBookDTO dto);

	int deletePhoneBook(int idx);

}
