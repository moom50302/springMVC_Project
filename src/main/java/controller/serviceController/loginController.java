package main.java.controller.serviceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.entity.v_customer;
import main.java.service.view.customer.vCustomerService;;

@Controller
public class loginController {
	
	@Autowired
	@Qualifier("vCustomerService")
	private vCustomerService vCustomerService;
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public ModelAndView check(@RequestParam("account") String account,
			@RequestParam("password") String password,
			ModelAndView modelAndView){
		
		String result = vCustomerService.findByAP(account, password);
		
		if(result.contains("ERROR")){
			modelAndView.setViewName("login");
			// error message center
			modelAndView.addObject("message","Wrong Account or Password");
			// modelAndView.addObject("message",errorMessageCenter.feedback());
		}else{
			List<v_customer> list = vCustomerService.getByAP(account);
			modelAndView.addObject("customerData",list.get(0));
			modelAndView.setViewName("index");
		}
		
		return modelAndView;
	}
}
