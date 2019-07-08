package main.java.service.view.ticket;

import java.util.List;

import main.java.entity.v_ticket;

public interface vTicketService {
	public List<v_ticket> findById(int id);
}
