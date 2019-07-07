package main.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.java.dao.fDAO;

@Service("fLoginCheckService")
@Transactional(readOnly = true)
public class fLoginCheckServiceImpl	implements fService {

	@Autowired
	@Qualifier("fLoginCheckDAO")
	private fDAO fDAO;
	
	@Override
	public String loginCheck(String account,String password) {
		return fDAO.loginCheck(account,password);
	}

}
