package Entità;

import java.sql.Date;
import java.sql.Time;

public class Ordine {
	
	private Date dataOrdine;
	private Time orarioPrevisto;
	private String indirizzoConsegna;
	private boolean consegnato;
	private String prezzoTotale;
	
	
	public Date getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public Time getOrarioPrevisto() {
		return orarioPrevisto;
	}
	public void setOrarioPrevisto(Time orarioPrevisto) {
		this.orarioPrevisto = orarioPrevisto;
	}
	public String getIndirizzoConsegna() {
		return indirizzoConsegna;
	}
	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}
	public boolean isConsegnato() {
		return consegnato;
	}
	public void setConsegnato(boolean consegnato) {
		this.consegnato = consegnato;
	}
	public String getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(String prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	
	

}
