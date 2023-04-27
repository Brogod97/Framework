package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService  {

	// 회원 비밀번호 변경
	int changePw(String currentPw, String newPw);

	

}
