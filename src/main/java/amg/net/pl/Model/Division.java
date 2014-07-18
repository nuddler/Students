package amg.net.pl.Model;


public class Division {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Division [name=" + name + "]";
	}

	public Division(String name) {
		super();
		this.name = name;
	}

}
