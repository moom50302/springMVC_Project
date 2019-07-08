package main.java.dao.view.customer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import main.java.entity.v_customer;


@Repository("vCustomerDAO")
public class vCustomerDAOImpl implements vCustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String findByAP(String account, String password) {
		Session session = this.sessionFactory.getCurrentSession();
        List result;
       
        result = session.createQuery("select v from v_logincheck as v where account=:in_account and password=:in_password")
        		.setParameter("in_account", account)
        		.setParameter("in_password", password)
        		.getResultList();
        
        String user_role;
        
        if(result.size() != 0)
        	user_role = result.get(0).toString();
        else
        	user_role = "ERROR-0001";
        
        return user_role;
	}

	@Override
	public List<v_customer> getByAP(String account) {
		Session session = this.sessionFactory.getCurrentSession();
        List<v_customer> result;
       
        result = session.createQuery("select v from v_customer v where account=:in_account",v_customer.class)
        		.setParameter("in_account", account)
        		.getResultList();
		
        return result;
	}
}
