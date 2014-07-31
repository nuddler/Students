package amg.net.pl.model;

import java.util.Map;

import amg.net.pl.pojo.Division;

public interface IDivisionManager {
	
	public Map<String, Division> getAll();
	public Division getById(String id);
	
}
