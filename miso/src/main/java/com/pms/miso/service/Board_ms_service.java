package com.pms.miso.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.miso.domain.Board_MS;
import com.pms.miso.repository.Board_ms_Repository;

@Service
public class Board_ms_service {
	
	//@Autowired
	private final Board_ms_Repository board_ms_Repository;

	public Board_ms_service(Board_ms_Repository board_ms_Repository) {
		this.board_ms_Repository = board_ms_Repository;
		// TODO Auto-generated constructor stub
	}

	public void saveBoard(Map<String, Object> mapData) {

		System.out.println("===>" + mapData.get("title").toString());
		
		//객체생성
		Board_MS board = new Board_MS();
		
		//매핑
		board.setTitle(mapData.get("title").toString());
		board.setContent(mapData.get("content").toString());
		
		//저장 DB
		board_ms_Repository.save(board);
	}

	public List<Board_MS> listBoard() {
		
		// DB
		return board_ms_Repository.findAll();
	}
	
	
	public void deleteBoard(Map<String, Object> mapData) {
		
		//String -> Long
		String idStr = mapData.get("id").toString();
		Long id = Long.parseLong(idStr);
		
		//DB
		board_ms_Repository.deleteById(id);
	

		
	}

	public void updateBoard(Map<String, Object> mapData) {
		
		//String -> Long
		String idStr = mapData.get("id").toString();
		Long id = Long.parseLong(idStr);
		
		//조회 DB
		Board_MS board = board_ms_Repository.findById(id)
					.orElseThrow(() -> new IllegalAccessError("no data"));
		
		//수정된 내용 Entity(domain) 저장
		board.setTitle(mapData.get("title").toString());
		board.setContent(mapData.get("content").toString());
		
		//변경 내용 저장 DB
		board_ms_Repository.save(board);
	}
}


