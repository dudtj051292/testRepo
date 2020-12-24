package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.dao.IMemberDao;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao dao;
	
	@Override
	public List<MemberDto> memberList() {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.signUpMember(dto);
	}

	@Override
	public int idDuplicateCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idDuplicateCheck(id);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.loginMember(map);
	}

	@Override
	public String selStringPw(String id) {
		// TODO Auto-generated method stub
		return dao.selStringPw(id);
	}

}
