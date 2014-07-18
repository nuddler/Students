package amg.net.pl.Model;

import java.util.Collection;

public interface IDivisionManager {
	
	public Collection<Division> getAll();
	public Division getById(String id);
	
}
