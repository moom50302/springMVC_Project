package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class pageController {
	
	@GetMapping("/")
	public ModelAndView con(ModelAndView modelAndView){
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/loginPage/{customerType}")
	public ModelAndView con2(@PathVariable("customerType") String customerType,ModelAndView modelAndView){
		if("normal".equals(customerType))
			modelAndView.setViewName("loginNormal");
		else if("enterprise".equals(customerType))
			modelAndView.setViewName("loginEnterprise");
		
		return modelAndView;
	}
	
	@RequestMapping("/checkTicket")
	public ModelAndView con3(ModelAndView modelAndView){
		modelAndView.setViewName("Normal");
		return modelAndView;
	}
	
	@RequestMapping("/udpateCustomer")
	public ModelAndView con4(ModelAndView modelAndView){
		modelAndView.setViewName("Normal");
		return modelAndView;
	}

	@RequestMapping("/vipService")
	public ModelAndView con5(ModelAndView modelAndView){
		modelAndView.setViewName("Enterprise");
		return modelAndView;
	}
}
