package edu.kh.comm.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	private MyPageDAO dao;

	// 회원 비밀번호 변경
	@Override
	public int changePw(String currentPw, String newPw) {
		return dao.changePw(currentPw, newPw);
	}

	

}
