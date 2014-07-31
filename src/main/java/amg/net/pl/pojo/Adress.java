package amg.net.pl.pojo;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Adress {
	
	@NotEmpty(message="Musisz podac nazwe ulice")
	@Pattern(regexp = "[A-Za-z]{2,}",message="Podaj poprawna nazwe ulicy")
	private String street;
	
	@NotEmpty(message="Musiz podac numer posesji")
	@Pattern(regexp = "[0-9]{1,}[a-z]{0,1}",message="Podaj poprawny numer posesji")
	private String posesionNumber;
	
	@NotEmpty(message="Musisz podac numer mieszkania")
	@Pattern(regexp = "[0-9]{1,}",message="Podaj poprawny numer mieszkania")
	private String flatNumber;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPosesionNumber() {
		return posesionNumber;
	}
	public void setPosesionNumber(String posesionNumber) {
		this.posesionNumber = posesionNumber;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	
	@Override
	public String toString() {
		return "Adress [street=" + street + ", posesionNumber="
				+ posesionNumber + ", flatNumber=" + flatNumber + "]";
	}
	public Adress(String street, String posesionNumber, String flatNumber) {
		super();
		this.street = street;
		this.posesionNumber = posesionNumber;
		this.flatNumber = flatNumber;
	}
	public Adress() {
	}
}
