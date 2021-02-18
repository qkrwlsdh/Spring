package com.itbank.board;

public class Paging {

	private final int perPage = 10;
	private int pageCount, first, last, begin, end, section, page, boardCount;
	private final int perSection = 10;
	
	private boolean prev, next;
	
	public Paging(int page, int boardCount) {
 		this.page = page;
 		this.boardCount = boardCount;
 		
 		pageCount = boardCount / perPage;
 		pageCount += (boardCount % perPage) == 0 ? 0 : 1;
 		
 		first = (page - 1) * perPage + 1;
 		last = first + perPage - 1;
 		
 		section = (page - 1) / 10;	// (1 ~ 10 : 0), (11 ~ 20 : 1), (21 ~ 30 : 2) ...
 		begin = 10 * section + 1;		// (0, 1),  (1, 11), (2, 21)
 		end = begin + perSection - 1;	// (0, 10), (1, 20), (2, 30)
 		end = end > pageCount ? pageCount : end;	// 총 페이지수보다 큰 값은 출력하지 않는다
 		
 		prev = section != 0;	// 이전 섹션으로 이동하는 링크를 출력하는지에 대한 조건
 		next = boardCount > perPage * end;	// 다음 섹션으로 이동하는 링크 출력할지에 대한 조건

	}

	public int getPerPage() {
		return perPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	public int getSection() {
		return section;
	}

	public int getPage() {
		return page;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public int getPerSection() {
		return perSection;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
}
