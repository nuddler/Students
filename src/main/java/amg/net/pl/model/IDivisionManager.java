package amg.net.pl.model;

import java.util.Map;

public interface IDivisionManager {
	
	public Map<String, Division> getAll();
	public Division getById(String id);
	
}
