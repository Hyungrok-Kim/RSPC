package com.myproject.rspc.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.rspc.user.model.service.UserService;
import com.myproject.rspc.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping("users/userLogin.do")
	public String memberLogin(@RequestParam String id,
							  @RequestParam String pwd,
							  HttpSession session,
							  Model model) {
		
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		System.out.println("로그인 컨트롤러 왔따.");
		
		User member = userService.selectOneUser(id);
		
		String msg = "";
		
		if( member == null) {
			msg = "존재하지 않는 아이디입니다.";
		}
		else {
			if(member.getPwd().equals(pwd)) {
				session.setAttribute("member", member);
				System.out.println("멤버 세팅 성공");
			}
			else {
				msg = "비밀번호가 틀렸습니다.";
			}
			
		}
		
		model.addAttribute("msg", msg);
		
		return "redirect:/";
	}
	
	@RequestMapping("users/userJoin.do")
	public String memeberJoin(User member, Model model) {
		
		String msg = "";
		
		try {
			int result = userService.insertUser(member);
			
			if(result > 0) msg = "회원가입 완료";
			else msg = "회원가입 실패";
			
			model.addAttribute("msg", msg);
			
		}catch(Exception e){
			System.out.println("회원가입시 에러 발생");
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
	 @RequestMapping("users/userLogout.do")
	   public String memberLogout(HttpSession session) {
	      
	   session.invalidate(); 
	      
	   
	   return "redirect:/";
	   
	   }
}
