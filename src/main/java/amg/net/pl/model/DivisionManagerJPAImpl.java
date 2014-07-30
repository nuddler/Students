package amg.net.pl.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DivisionManagerJPAImpl implements IDivisionManager {

	private static final Logger logger = LogManager
			.getLogger(DivisionManagerJPAImpl.class);
	@PersistenceContext
	private EntityManager em;

	@Override
	public Map<String, Division> getAll() {

		List<Division> resultList = em.createQuery("select a from Division a").getResultList();

		Map<String, Division> map = new HashMap<String, Division>();

		for (Division division : resultList) {
			map.put(division.getName(), division);
		}
		return map;
	}

	@Override
	public Division getById(String id) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Starting getting by id("+id+") division");
		}
		
		List list=em.createQuery("Select a from Division a where a.name=?").setParameter(1, id).getResultList();
		
		if(list.isEmpty()){
			logger.warn("Division with name "+id+"dosen't exist");
			throw new RuntimeException();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("Division was found - "+list.get(0));
		}
		return (Division) list.get(0);
	}

}
