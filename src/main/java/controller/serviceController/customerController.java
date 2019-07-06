package main.java.controller.serviceController;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/customerService")
public class customerController {
	
	@RequestMapping(value="/{customerType}",method = RequestMethod.POST)
	public ModelAndView insert(@PathParam("customerType")String customerType,ModelAndView modelAndView){
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{customerType}",method = RequestMethod.PUT)
	public ModelAndView update(@PathParam("customerType")String customerType,ModelAndView modelAndView){
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{customerType}",method = RequestMethod.DELETE)
	public ModelAndView delete(@PathParam("customerType")String customerType,ModelAndView modelAndView){
		
		
		return modelAndView;
	}
}
