package amg.net.pl.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Adress {
	
	@NotNull(message="Imię nie może być puste")
	private String street;
	
	@NotNull(message="Imię nie może być puste")
	private String posesionNumber;
	
	@NotNull(message="Imię nie może być puste")
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
		// TODO Auto-generated constructor stub
	}
}
