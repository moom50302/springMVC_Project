package main.java.service.view.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.dao.view.ticket.vTicketDAO;
import main.java.entity.v_ticket;

@Service("vTicketService")
@Transactional(readOnly = true)
public class vTicketServiceImpl	implements vTicketService {

	@Autowired
	@Qualifier("vTicketDAO")
	private vTicketDAO vDAO;
	
	@Override
	public List<v_ticket> findById(int id) {
		return (List<v_ticket>) vDAO.findById(id);
	}

}
