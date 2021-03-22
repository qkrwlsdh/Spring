package com.itbank.phonebook;

import java.util.List;

public interface PhoneBookDAO {

	List<PhoneBookDTO> selectPhoneList();

	int insertPhoneBook(PhoneBookDTO dto);

}
