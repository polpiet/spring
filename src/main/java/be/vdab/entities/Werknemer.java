package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "werknemers")
public class Werknemer {
	@Id
	@GeneratedValue
	private long id;
	private String voornaam;
	private String familienaam;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="filiaalId")
	private Filiaal filiaal;
	private BigDecimal wedde;
	@Column(unique=true)
	private long rijksregisterNR;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rijksregisterNR ^ (rijksregisterNR >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Werknemer other = (Werknemer) obj;
		if (rijksregisterNR != other.rijksregisterNR)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	public Filiaal getFiliaal() {
		return filiaal;
	}
	public void setFiliaal(Filiaal filiaal) {
		this.filiaal = filiaal;
	}
	public BigDecimal getWedde() {
		return wedde;
	}
	public void setWedde(BigDecimal wedde) {
		this.wedde = wedde;
	}
	public long getRijksregisterNR() {
		return rijksregisterNR;
	}
	public void setRijksregisterNR(long rijksregisterNR) {
		this.rijksregisterNR = rijksregisterNR;
	}
}
