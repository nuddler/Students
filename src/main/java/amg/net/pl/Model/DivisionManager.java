package amg.net.pl.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class DivisionManager implements IDivisionManager {

	private static IDivisionManager instance;
	
	private DivisionManager(){
		divisions=new HashMap<String, Division>();
		Division tmpDivision=new Division("FITMS");
		divisions.put("Name", tmpDivision);
		tmpDivision=new Division("OIZ");
		divisions.put("Name2", tmpDivision);
	}
	
	private Map<String,Division> divisions;
	
	public Collection<Division> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Division getById(String id) {

		return divisions.get(id);
	}
	public static IDivisionManager getInstance(){
		if(instance==null){
    		instance=new DivisionManager();
    	}
    	return instance;
	}
}
