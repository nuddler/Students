package amg.net.pl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
	
	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false) 
	private Long id;
	
	@NotEmpty
	@Pattern(regexp = "[A-Za-z]{2,}",message="Bad pesel")
	private String vorName;
	
	@NotEmpty(message="Imię nie może być puste")
	@Pattern(regexp = "[A-Za-z]{2,}",message="Podaj poprawne nazwisko")
	private String lastname;
	
	@Pattern(regexp = "\\d{11}",message="Zly pesel")
	private String pesel;
	
    @Valid
	private Adress homeAdress;
	
    @Valid
    @ManyToOne
	private Division division;
    
    @Version
    @NotNull
    private Long version=1L;
    
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
		this.id= new Long(pesel);
	}
	
	public Student() {}
	
	public void setDivision(Division division) {
		this.division = division;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
