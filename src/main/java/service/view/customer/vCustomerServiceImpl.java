package main.java.service.view.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.java.dao.view.customer.vCustomerDAO;
import main.java.entity.v_customer;

@Service("vCustomerService")
@Transactional(readOnly = true)
public class vCustomerServiceImpl implements vCustomerService {

	@Autowired
	@Qualifier("vCustomerDAO")
	private vCustomerDAO vCustomerDAO;

	@Override
	public String findByAP(String account, String password) {
		return vCustomerDAO.findByAP(account, password);
	}

	@Override
	public List<v_customer> getByAP(String account) {
		return vCustomerDAO.getByAP(account);
	}
}
