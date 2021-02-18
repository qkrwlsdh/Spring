package com.itbank.board;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	
	List<BoardDTO> selectList(HashMap<String, Object> map);

	int selectCount(HashMap<String, Object> map);

	BoardDTO selectOne(int idx);

	int insertBoard(BoardDTO user);

	int selectMaxIdx();
}
