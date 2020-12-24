package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.MemberDto;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS = "memberMapper.";

	
	@Override
	public List<MemberDto> memberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"memberList");
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		// TODO Auto-generated method stub
		System.out.println("dto : "+dto.toString());
		String enPassword = passwordEncoder.encode(dto.getPw());
		dto.setPw(enPassword);
		
		return sqlSession.insert(NS+"signUpMember",dto)>0? true: false;
	}

	@Override
	public int idDuplicateCheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"idDuplicateCheck",id);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		// TODO Auto-generated method stub
		MemberDto dto = null;
		System.out.println("input pw : "+map.get("pw"));
		String dbPassword = sqlSession.selectOne(NS+"selStringPw", map.get("id"));
		System.out.println("dbPw : " + dbPassword);
		
		if(passwordEncoder.matches(map.get("pw"), dbPassword)) {
			System.out.println("password Match!");
			dto = sqlSession.selectOne(NS+"enLogin",map);
		}
		
		return dto;
	}

	@Override
	public String selStringPw(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"selStringPw" ,id);
	}


}
