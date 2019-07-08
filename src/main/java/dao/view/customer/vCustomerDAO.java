package main.java.dao.view.customer;

import java.util.List;
import main.java.entity.v_customer;

public interface vCustomerDAO {
	public String findByAP(String account,String password);
	public List<v_customer> getByAP(String account);
}
