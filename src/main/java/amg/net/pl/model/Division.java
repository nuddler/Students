package amg.net.pl.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Component
public class Division {
	
	@NotNull(message="Imię nie może być puste")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Division(String name) {
		super();
		this.name = name;
	}
	public Division() {
		// TODO Auto-generated constructor stub
	}

}
