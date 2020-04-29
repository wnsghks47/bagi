package com.tech.lunch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tech.lunch.model.Lunch;

@Controller
public class LunchController {
	
	@RequestMapping("/lunch/lunchview1")
	public String lunchview1(HttpServletRequest request,
			Model model) {
		String fname=request.getParameter("fname");
		String fprice=request.getParameter("fprice");
		String fkind=request.getParameter("fkind");
		String floc=request.getParameter("floc");
		
		model.addAttribute("fname", fname);
		model.addAttribute("fprice", fprice);
		model.addAttribute("fkind", fkind);
		model.addAttribute("floc", floc);
	
		return "/lunch/lunchview1";
	}
	@RequestMapping("/lunch/lunchview2")
	public String lunchview2(@RequestParam("fname") String fname,
			@RequestParam("fprice") String fprice,
			@RequestParam("fkind") String fkind,
			@RequestParam("floc") String floc,
			Model model) {
		
		model.addAttribute("fname", fname);
		model.addAttribute("fprice", fprice);
		model.addAttribute("fkind", fkind);
		model.addAttribute("floc", floc);
	
		return "/lunch/lunchview2";
	}
	
	@RequestMapping("/lunch/lunchview3")
	public ModelAndView lunchview3(@RequestParam("fname") String fname,
			@RequestParam("fprice") String fprice,
			@RequestParam("fkind") String fkind,
			@RequestParam("floc") String floc,
			ModelAndView mv) {
		
		mv.addObject("fname", fname);
		mv.addObject("fprice", fprice);
		mv.addObject("fkind", fkind);
		mv.addObject("floc", floc);
		mv.setViewName("/lunch/lunchview3");
	
		return mv;
	}
	@RequestMapping("/lunch/lunchview4")
	public String lunchview4(@ModelAttribute("lunch") Lunch lunch) {
		
		return "/lunch/lunchview4";
	}
	@RequestMapping("/lunch/lunchview5")
	public String lunchview5(Lunch lunch) {
		
		return "/lunch/lunchview5";
	}
	
	@RequestMapping("/lunch/lunchview6")
	public String lunchview6(@ModelAttribute("lch") Lunch lunch) {
		
		return "/lunch/lunchview6";
	}
	
	
	@RequestMapping("/lunch/lunchform1")
	public String lunchform1() {
		return "/lunch/lunchform1";
	}
	@RequestMapping("/lunch/lunchform2")
	public String lunchform2() {
		return "/lunch/lunchform2";
	}
	@RequestMapping("/lunch/lunchform3")
	public String lunchform3() {
		return "/lunch/lunchform3";
	}
	@RequestMapping("/lunch/lunchform4")
	public String lunchform4() {
		return "/lunch/lunchform4";
	}
	@RequestMapping("/lunch/lunchform5")
	public String lunchform5() {
		return "/lunch/lunchform5";
	}
	@RequestMapping("/lunch/lunchform6")
	public String lunchform6() {
		return "/lunch/lunchform6";
	}
}
