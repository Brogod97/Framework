package edu.kh.comm.member.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.comm.member.model.service.MyPageService;
import edu.kh.comm.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
public class MyPageController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MyPageService service;
	

	// 비밀번호 변경
	
	// 회원 탈퇴
	
	// 회원 정보 수정
	public String updateInfo(@ModelAttribute("loginMember") Member loginMember, 
							@RequestParam Map<String, Object> paramMap, // 요청시 전달된 파라미터를 구분하지 않고 모두 Map에 담아서 얻어옴
							String[] updateAddress,
							RedirectAttributes ra) {
		
		// 필요한 값
		// - 닉네임
		// - 전화번호
		// - 주소 (String[] 로 얻어와 String.join()을 이용해서 문자열로 변경)
		// - 회원 번호(Session -> 로그인한 회원 정보를 통해서 얻어옴)
		// 		-> @ModelAttribute, @SessionAttributes 필요 
		
		// @SessionAttributes의 역할 2가지
		// 1) Model에 세팅 데이터의 key 값을 @SessionAttributes에 작성하면
		//	해당 key가 값과 같은 Model에 세팅된 데이터를 request -> session scope로 이동
		
		// 2) 기존에 session scope로 이동시켰던 값을 얻어오는 역할
		// @ModelAttribute("loginMember") Member loginMember
		// 					[session key]와 이름이 같다면
		// --> @SessionAttributes 통해 session scope에 등록된 값을 얻어와
		//		오른쪽에 작성된 Member loginMember 변수에 대입
		// 		단, @SessionAttributes({"loginMember"}) 가 클래스 위에 작성되어 있어야 가능
		
		// *** 매개변수를 이용해서 session, 파라미터 데이터를 동시에 얻어올 때 문제점 ***
		
		// session에서 객체를 얻어오기 위해 매개변수에 작성한 상태
		// -> @ModelAttribute("loginMember") Member loginMember
		
		// 파라미터의 name 속성값이 매개변수에 작성된 객체의 필드와 일치하면
		// -> name="memberNickname"
		// session 에서 얻어온 객체의 필드에 덮어쓰기가 된다!
		
		// [해결방법] 파라미터의 name 속성값을 변경해서 얻어오면 문제 해결!
		// (필드명 겹쳐서 생긴 문제이므로 겹치지 않게 변동하는 것)
		return "redirect:info";
	}
	
}
