package amg.net.pl.model;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


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
		return ToStringBuilder.reflectionToString(this);
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(obj, this);
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
