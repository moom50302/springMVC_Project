package main.java.controller;

import javax.websocket.server.PathParam;

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
	
	@RequestMapping("/fileAnalysis")
	public ModelAndView con6(ModelAndView modelAndView){
		modelAndView.setViewName("fileAnalysis");
		return modelAndView;
	}
	
	@RequestMapping("/checkContent/{fileName}")
	public ModelAndView con7(ModelAndView modelAndView,@PathVariable("fileName") String fileName) {
		modelAndView.addObject("fileName",fileName);
		modelAndView.setViewName("checkContent");
		return modelAndView;
	}
	
	@RequestMapping("/uploadFile")
	public ModelAndView con8(ModelAndView modelAndView) {
		modelAndView.setViewName("fileUpload");
		return modelAndView;
	}
	
	/* test for multiple page transfer
	@RequestMapping("/{pageName}")
	public ModelAndView testCon(ModelAndView modelAndView,@PathParam("pageName") String pageName) {
		modelAndView.setViewName(pageName);
		return modelAndView;
	}
	*/
}
