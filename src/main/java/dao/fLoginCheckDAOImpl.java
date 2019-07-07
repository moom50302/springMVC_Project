package main.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fLoginCheckDAO")
public class fLoginCheckDAOImpl implements fDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String loginCheck(String account,String password) {
		Session session = this.sessionFactory.getCurrentSession();
        
        List list = session.createQuery("select f_loginCheck(:account,:password)").setParameter(1,account).setParameter(2,password).getResultList();
        String resultString = list.get(0).toString();
		
        return resultString;
	}

}
