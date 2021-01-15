package Entità;

import java.sql.Date;
import java.sql.Time;

public class Ordine {
	
	private Date dataOrdine;
	private Time orarioPrevisto;
	private String indirizzoConsegna;
	private boolean consegnato;
	private double prezzoTotale;
	private int idRistorante;
	private int idRider;
	private int idProfilo;
	
	
	public Ordine(Date dataOrdine, Time orarioPrevisto, String indirizzoConsegna, boolean consegnato,
			double prezzoTotale, int idRistorante, int idRider, int idProfilo) {
		super();
		this.dataOrdine = dataOrdine;
		this.orarioPrevisto = orarioPrevisto;
		this.indirizzoConsegna = indirizzoConsegna;
		this.consegnato = consegnato;
		this.prezzoTotale = prezzoTotale;
		this.idRistorante = idRistorante;
		this.idRider = idRider;
		this.idProfilo = idProfilo;
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
	public int getIdRistorante() {
		return idRistorante;
	}
	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
	}
	public int getIdRider() {
		return idRider;
	}
	public void setIdRider(int idRider) {
		this.idRider = idRider;
	}
	public int getIdProfilo() {
		return idProfilo;
	}
	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	@Override
	public String toString() {
		return "Ordine [dataOrdine=" + dataOrdine + ", orarioPrevisto=" + orarioPrevisto + ", indirizzoConsegna="
				+ indirizzoConsegna + ", consegnato=" + consegnato + ", prezzoTotale=" + prezzoTotale
				+ ", idRistorante=" + idRistorante + ", idRider=" + idRider + ", idProfilo=" + idProfilo + "]";
	}
	
	
	
	

}
