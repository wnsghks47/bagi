package com.tech.lunch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class lunchController {
	@RequestMapping("/lunch/lunchView1")
	public String lunchView1(HttpServletRequest request,Model model) {
		String fname=request.getParameter("fname");
		String fprice=request.getParameter("fprice");
		String fkind=request.getParameter("fkind");
		String floc=request.getParameter("floc");
		
		model.addAttribute("fname", fname);
		model.addAttribute("fprice", fprice);
		model.addAttribute("fkind", fkind);
		model.addAttribute("floc", floc);
		
		return "/lunch/lunchView1";
	}
	@RequestMapping("/lunch/lunchView2")
	public String lunchView2(@RequestParam("fname") String fname,
		@RequestParam("fprice") String fprice,
		@RequestParam("fkind") String fkind,
		@RequestParam("floc") String floc,
		Model model) {
		
		model.addAttribute("fname", fname);
		model.addAttribute("fprice", fprice);
		model.addAttribute("fkind", fkind);
		model.addAttribute("floc", floc);
		
		return "/lunch/lunchView2";
	}
	
	@RequestMapping("/lunch/lunchView3")
	public ModelAndView lunchView3(@RequestParam("fname") String fname,
		@RequestParam("fprice") String fprice,
		@RequestParam("fkind") String fkind,
		@RequestParam("floc") String floc,
		ModelAndView mv) {
		
		mv.addObject("fname", fname);
		mv.addObject("fprice", fprice);
		mv.addObject("fkind", fkind);
		mv.addObject("floc", floc);
		
		return mv;
	}

	@RequestMapping("/lunch/lunchForm1")
	public String lunchForm1() {

		return "/lunch/lunchForm1";
	}
	@RequestMapping("/lunch/lunchForm2")
	public String lunchForm2() {

		return "/lunch/lunchForm2";
	}
	@RequestMapping("/lunch/lunchForm3")
	public String lunchForm3() {

		return "/lunch/lunchForm3";
	}
}
