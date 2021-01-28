package Entità;

import java.sql.Date;
import java.sql.Time;

public class Ordine {
	
	private int idOrdine;
	private Date dataOrdine;
	private Time orarioPrevisto;
	private String indirizzoConsegna;
	private boolean consegnato = false;
	private double prezzoTotale;
	private Ristorante ristorante;
	private Rider rider;
	private Utente utente;
	
	
	public Ordine(int idOrdine, Date dataOrdine, Time orarioPrevisto, String indirizzoConsegna, boolean consegnato,
			double prezzoTotale, Rider rider, Utente utente) {
		super();
		this.idOrdine = idOrdine;
		this.dataOrdine = dataOrdine;
		this.orarioPrevisto = orarioPrevisto;
		this.indirizzoConsegna = indirizzoConsegna;
		this.consegnato = consegnato;
		this.prezzoTotale = prezzoTotale;
		this.rider = rider;
		this.utente = utente;
	}
	
	
	public Ordine(Time orarioPrevisto, String indirizzoConsegna, double prezzoTotale, Utente utente, Ristorante ristorante2) {
		super();
		this.orarioPrevisto = orarioPrevisto;
		this.indirizzoConsegna = indirizzoConsegna;
		this.prezzoTotale = prezzoTotale;
		this.utente = utente;
		this.ristorante = ristorante2;
	}


	public int getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
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
	public double getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	


	@Override
	public String toString() {
		return "Ordine [dataOrdine=" + dataOrdine + ", orarioPrevisto=" + orarioPrevisto + ", indirizzoConsegna="
				+ indirizzoConsegna + ", consegnato=" + consegnato + ", prezzoTotale=" + prezzoTotale + "]";
	}


	public Ristorante getRistorante() {
		return ristorante;
	}


	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	
	
	

}
