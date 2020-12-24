package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.MemberDto;

public interface IMemberDao {
	public List<MemberDto> memberList();
	
	
	public int idDuplicateCheck(String id);
	
	public MemberDto loginMember(Map<String, String>map);
	
	public String selStringPw(String id);
	

	public boolean signUpMember(MemberDto dto);
}
