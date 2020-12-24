package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.dao.IBoardDao;

@Service
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<AnswerboardDto> selectDynamic(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectDynamic(map);
	}


	@Override
	public boolean modifyBoard(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.modifyBoard(map);
	}

	@Override
	public int insertBoard(AnswerboardDto dto) {
		// TODO Auto-generated method stub
		return dao.insertBoard(dto);
	}

	@Override
	public boolean multiDelete(String seq) {
		// TODO Auto-generated method stub
		return dao.multiDelete(seq);
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return dao.multiDelete2(map);
	}

	@Transactional
	@Override
	public boolean reply(AnswerboardDto dto) {
		 boolean isc1 = dao.replyUpdate(dto);
		 boolean isc2 = dao.replyInsert(dto);
		 
		return (isc1||isc2)? true : false;
	}

}
