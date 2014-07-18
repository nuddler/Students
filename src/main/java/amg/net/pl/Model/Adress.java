package amg.net.pl.Model;

public class Adress {
	
	private String street;
	private String posesionNumber;
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
	
}
