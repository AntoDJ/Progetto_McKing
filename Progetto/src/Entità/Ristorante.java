package Entità;

import java.sql.Time;

public class Ristorante {
	
	private String citta;
	private String indirizzo;
	private String numeroDiTelefono;
	private Time orarioApertura;
	private Time orarioChiusura;
	private double distanzaMassima;
	private boolean attivo;
	
	
	public Ristorante(String citta, String indirizzo, String numeroDiTelefono, Time orarioApertura, Time orarioChiusura, double distanzaMassima) {
		super();
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.numeroDiTelefono = numeroDiTelefono;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
		this.distanzaMassima = distanzaMassima;
	}
	
	
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	public Time getOrarioApertura() {
		return orarioApertura;
	}
	public void setOrarioApertura(Time orarioApertura) {
		this.orarioApertura = orarioApertura;
	}
	public Time getOrarioChiusura() {
		return orarioChiusura;
	}
	public void setOrarioChiusura(Time orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}
	public double getDistanzaMassima() {
		return distanzaMassima;
	}
	public void setDistanzaMassima(double distanzaMassima) {
		this.distanzaMassima = distanzaMassima;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	
	

}
