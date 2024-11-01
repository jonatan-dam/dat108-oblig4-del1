package no.hvl.dat108.model;

/**
 * Model-klasse for deltagere som blir påmeldt.
 * Bruker Bean Validation via Spring Boot for å stille valideringskrav fra tjenersiden til objektene som lagres.
 */

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class Deltager {
	
	@Pattern(regexp = "^[0-9]{8}$", message="Mobilnummer må være eksakt 8 sifre")
	@NotNull(message="Telefonnumer er obligatorisk")
	private String mobil;
	
	@Pattern(regexp="^(?=.*[0-9])(?=.*[\\W_])[A-Za-z0-9\\W_]{7,}$", message="Passord må ha en minimumslengde på 7. Man må også ha minst 1 tall og minst 1 spesialtegn.")
	@NotNull(message="Passord er obligatorisk")
	private String passord;
	
	@Pattern(regexp="^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\- ]{2,19}$", message="Fornavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ), bindestrek "
			+ "og mellomrom. Første tegn skal være en stor bokstav")
	@NotNull(message="Fornavn er obligatorisk")
	private String fornavn;
	
	@Pattern(regexp="^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{2,19}$", message="Etternavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og\r\n"
			+ "bindestrek. Første tegn skal være en stor bokstav.")
	@NotNull(message="Etternavn er obligatorisk")
	private String etternavn;
	
	
	@Pattern(regexp = "^(?i)(mann|kvinne)$", message = "Kjønn må være enten 'mann' eller 'kvinne'")
	@NotNull(message = "Kjønn er obligatorisk")
	private String kjonn;
	
	public Deltager(String mobil, String passord, String fornavn, String etternavn, String kjonn) {
		this.mobil = mobil;
		this.passord= passord;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		
	}
	
	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", kjonn=" + kjonn + "]";
	}
	
	// Gettere og settere
	
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public String getKjonn() {
		return kjonn;
	}
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	
	
	
	
	
	
	
	
	
}
