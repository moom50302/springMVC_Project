package main.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.dao.vDAO;
import main.java.entity.v_ticket;

@Service("vTicketService")
@Transactional(readOnly = true)
public class vTicketServiceImpl	implements vService {

	@Autowired
	@Qualifier("vTicketDAO")
	private vDAO vDAO;
	
	@Override
	public List<v_ticket> findById(int id) {
		return (List<v_ticket>) vDAO.findById(id);
	}

}
