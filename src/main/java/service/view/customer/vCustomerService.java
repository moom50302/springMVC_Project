package main.java.service.view.customer;

import java.util.List;

import main.java.entity.v_customer;

public interface vCustomerService {
	public String findByAP(String account,String password);
	public List<v_customer> getByAP(String account);
}
