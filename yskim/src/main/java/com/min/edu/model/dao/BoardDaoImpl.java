package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AnswerboardDto;

@Repository
public class BoardDaoImpl implements IBoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "boardMapper.";
	
	@Override
	public List<AnswerboardDto> selectDynamic(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"selectDynamic", map);
	}

	@Override
	public boolean replyInsert(AnswerboardDto dto) {
		// TODO Auto-generated method stub
		return (sqlSession.insert(NS+"replyInsert", dto ) !=0 ) ? true : false ;
	}

	@Override
	public boolean replyUpdate(AnswerboardDto dto) {
		// TODO Auto-generated method stub
		return (sqlSession.update(NS+"replyUpdate",  dto)!= 0)  ? true : false ;
	}

	@Override
	public boolean modifyBoard(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"modifyBoard", map ) !=0 ? true : false ;
	}

	@Override
	public int insertBoard(AnswerboardDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"insertBoard", dto );
	}

	@Override
	public boolean multiDelete(String seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"multiDelete", seq )!=0 ? true : false ;
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"multiDelete2",map  )!=0 ? true : false ;
	}
	
}
