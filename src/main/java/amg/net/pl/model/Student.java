package amg.net.pl.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

public class Student {
	
	@NotEmpty(message="Imię nie może być puste")
	private String vorName;
	
	@NotNull(message="Imię nie może być puste")
	private String lastname;
	
	@NotNull(message="Imię nie może być puste")
	private String pesel;
	
	private Adress homeAdress;
	
	private Division division;
	
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
	public void setPesel(String pesel) {
		this.pesel=pesel;
	}
	public Adress getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(Adress homeAdress) {
		this.homeAdress = homeAdress;
	}
	public Division getDivision() {
		return division;
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
		this.setDivision(division);
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public void setDivision(Division division) {
		this.division = division;
	}

}
