package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.MemberDto;

public interface IMemberService {
	public List<MemberDto> memberList();
	
	public boolean signUpMember(MemberDto dto);
	
	public int idDuplicateCheck(String id);
	
	public MemberDto loginMember(Map<String, String>map);
	
	public String selStringPw(String id);
	
}  
