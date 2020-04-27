package com.tech.aPrj5;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
@RequestMapping("/member/memberform")
	public String member() {
		return "/member/memberform";
	}
@RequestMapping("/member/memberview")
public String member1(HttpServletRequest request,Model model){
	System.out.println("Æû ½ÅÈ£!");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	model.addAttribute("name", name);
	model.addAttribute("id", id);
	model.addAttribute("pw", pw);
	
	System.out.println("name : "+name);
	System.out.println("id : "+id);
	System.out.println("pw : "+pw);
	
	
	return "/member/memberview";
}
}
