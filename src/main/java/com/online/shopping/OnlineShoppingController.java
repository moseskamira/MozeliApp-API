package com.online.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/onlineshopping")
public class OnlineShoppingController {
	@RequestMapping(value="")
	public ModelAndView returnHomePage() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greeting", "Welcome to spring MVC");
		
		return mv;
	}
}
