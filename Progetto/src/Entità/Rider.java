package Entità;

public class Rider {
	
	private int idRider;
	private String cognome;
	private String nome;
	private String numeroDiTelefono;
	private String tipoMezzo;
	private boolean attivo;
	private int idRistorante;
	
	public Rider(int idRider, String cognome, String nome, String numeroDiTelefono, String tipoMezzo, boolean attivo,
			int idRistorante) {
		super();
		this.idRider = idRider;
		this.cognome = cognome;
		this.nome = nome;
		this.numeroDiTelefono = numeroDiTelefono;
		this.tipoMezzo = tipoMezzo;
		this.attivo = attivo;
		this.idRistorante = idRistorante;
	}
	
	
	
	public int getIdRider() {
		return idRider;
	}
	public void setIdRider(int idRider) {
		this.idRider = idRider;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	public String getTipoMezzo() {
		return tipoMezzo;
	}
	public void setTipoMezzo(String tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	public int getIdRistorante() {
		return idRistorante;
	}
	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
	}

	@Override
	public String toString() {
		return cognome + " " + nome;
	}
	

	
	
	
	

}
