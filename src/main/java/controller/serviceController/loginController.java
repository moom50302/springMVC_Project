package main.java.controller.serviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import main.java.service.fService;

@Controller
public class loginController {
	
	@Autowired
	@Qualifier("fLoginCheckService")
	private fService fService;
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public ModelAndView check(@RequestParam("account") String account,
			@RequestParam("account") String password,
			ModelAndView modelAndView){
		
		String result = fService.loginCheck(account, password);
		
		if(result.equals("0")){
			modelAndView.setViewName("index");
			modelAndView.addObject("message","Wrong Account or Password");
		}else if(result.equals("1")){
			modelAndView.setViewName("Normal");
		}if(result.equals("2")){
			modelAndView.setViewName("Enterprise");
		}
		
		return modelAndView;
	}
}
