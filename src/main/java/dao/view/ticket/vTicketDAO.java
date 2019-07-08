package main.java.dao.view.ticket;

import java.util.List;

import main.java.entity.v_ticket;


public interface vTicketDAO {
	public List<v_ticket> findById(int id);
}
