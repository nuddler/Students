package amg.net.pl.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DivisionManager implements IDivisionManager {

	private static IDivisionManager instance;
	private static final Logger logger = LogManager
			.getLogger(DivisionManager.class);
	private DivisionManager(){
		divisions=new HashMap<String, Division>();
		Division tmpDivision=new Division("FTIMS");
		divisions.put("FTIMS", tmpDivision);
		tmpDivision=new Division("OIZ");
		divisions.put("OIZ", tmpDivision);
	}
	
	private Map<String,Division> divisions;
	
	public Collection<Division> getAll() {
		return null;
	}

	public Division getById(String id)  {
		if(id==null || !divisions.containsKey(id)){	
		logger.error("Wrong id");
		throw new DivisionNotFound();
		}
		
		return divisions.get(id);
	}
	public static IDivisionManager getInstance(){
		if(instance==null){
    		instance=new DivisionManager();
    	}
    	return instance;
	}
}
