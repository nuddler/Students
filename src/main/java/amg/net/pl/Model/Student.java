package amg.net.pl.Model;

import java.util.ArrayList;
import java.util.Collection;


public class Student {
	
	private String vorName;
	private String lastname;
	private final String pesel;
	private Adress homeAdress;
	private Collection<Division> divisions;
	
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPesel() {
		return pesel;
	}
	public Adress getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(Adress homeAdress) {
		this.homeAdress = homeAdress;
	}
	public Collection<Division> getDivision() {
		return divisions;
	}
	
	@Override
	public String toString() {
		return "Student [vorName=" + vorName + ", lastname="
				+ lastname + ", pesel=" + pesel + ", homeAdress=" + homeAdress
				+ ", division=" + divisions + "]";
	}
	public Student(String vorName, String lastname, String pesel,
			Adress homeAdress, Division division) {
		super();
		this.vorName = vorName;
		this.lastname = lastname;
		this.pesel = pesel;
		this.homeAdress = homeAdress;
		divisions=new ArrayList<Division>(); 
		this.divisions.add(division);
	}

}
