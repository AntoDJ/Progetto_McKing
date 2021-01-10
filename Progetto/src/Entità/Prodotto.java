package Entità;

public class Prodotto {
	
	private String nome;
	private double prezzo;
	private String dimensione;
	private String tipoProdotto;
	private boolean attivo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	public String getTipoProdotto() {
		return tipoProdotto;
	}
	public void setTipoProdotto(String tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	

}
