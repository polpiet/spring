package be.vdab.valueobjects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.constraints.Postcode;

@Embeddable
public class Adres {
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String straat;
	@NotNull
	@NotBlank
	@Size(min = 1, max = 7)
	@SafeHtml
	private String huisNr;
	@NotNull
	@Postcode
	private Integer postcode;
	@NotNull
	@NotBlank
	@Size(min = 1, max = 50)
	@SafeHtml
	private String gemeente;

	public Adres() {
	}
	
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
}
