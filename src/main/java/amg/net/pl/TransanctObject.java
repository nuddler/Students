package amg.net.pl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class TransanctObject {

	@Autowired
	ObjectDAO dao;
	
	public void doIt(){
		
		dao.saveObjectA();
		dao.saveObjectB();
	}

}
