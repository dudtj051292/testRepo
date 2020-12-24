package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface IBoardDao {
	public List<AnswerboardDto> selectDynamic(Map<String, String> map);
	public boolean replyInsert(AnswerboardDto dto);
	public boolean replyUpdate(AnswerboardDto dto);
	public boolean modifyBoard(Map<String, String> map);
	public int insertBoard(AnswerboardDto dto); 
	public boolean multiDelete(String seq);
	public boolean multiDelete2(Map<String, String[]> map);
}
