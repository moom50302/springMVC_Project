package main.java.controller.serviceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.entity.v_ticket;
import main.java.service.vService;

@CrossOrigin(origins = "http://localhost:13323")

@RestController
public class vServiceController {
	
	@Autowired
	@Qualifier("vTicketService")
	private vService vService;
	
	@RequestMapping(value="/vTicket/{id}",produces = {"application/json;charset=UTF-8"},method=RequestMethod.GET)
    public List<v_ticket> listClassItem(@PathVariable("id") int id){
        List<v_ticket> vTicketList = (List<v_ticket>) vService.findById(id);
        vTicketList.stream().forEach(s -> System.out.println(s.toString()));
        
        return vTicketList;
    }
}
