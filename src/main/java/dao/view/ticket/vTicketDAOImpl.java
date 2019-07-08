package main.java.dao.view.ticket;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.entity.v_ticket;

@Repository("vTicketDAO")
public class vTicketDAOImpl implements vTicketDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<v_ticket> findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        List<v_ticket> vTicketList;
       
        vTicketList = session.createQuery("select v from v_ticket v", v_ticket.class).getResultList();
        
        List<v_ticket> result = vTicketList.stream()
							        		.filter(v -> v.getCid()==id)
							        		.collect(Collectors.toList());
        
        return result;
	}

}
