package edu.kh.comm.member.model.service;

import java.util.List;

import edu.kh.comm.member.model.vo.Member;

/* Service Interface를 사용하는 이유
 * 
 * 1. 프로젝트에 규칙성을 부여하기 위해서 사용
 * 
 * 2. Spring AOP(Aspect Oriented Programming, 관점 지향 프로그래밍)를 위해서 필요
 * 
 * 3. 클래스간의 결합도를 약화 시키기 위해서 -> 유지보수성 향상
 * 
 * */
public interface MemberService {

	// 모든 메서드가 추상 메서드 (묵시적으로 public abstract)
	// 모든 필드는 상수 (묵시적으로 public static final)

	/**
	 * 로그인 서비스
	 * 
	 * @param inputMember
	 * @return loginMember
	 */
	public abstract Member login(Member inputMember);

	/** 이메일 중복 검사
	 * @param memberEmail
	 * @return
	 */
	public abstract int emailDupCheck(String memberEmail);

	/** 닉네임 중복 검사
	 * @param memberNickname
	 * @return
	 */
	public abstract int nicknameDupCheck(String memberNickname);

	/** 회원 가입 DB 저장
	 * @param newMember 
	 * @return
	 */
	public abstract int insertMember(Member newMember);
	
	/** 회원 정보 조회 비동기 통신(AJAX)
	 * @return member
	 */
	public abstract Member memberSelectOne(String memberEmail);

	
	/** 회원 목록 조회(ajax) 서비스
	 * @return memberList
	 */
	public abstract List<Member> memberSelectAll();
}
