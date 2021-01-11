package Entità;

public class Utente {
	private String cognome;
	private String nome;
	private String email;
	private String password;
	private String indirizzo;
	private String cartaDiCtredito;
	private String numeroDiTelefono;
	private boolean attivo;
	
	
	
	public Utente(String cognome, String nome, String indirizzo, String cartaDiCtredito,
			String numeroDiTelefono, boolean attivo) {
		super();
		this.cognome = cognome;
		this.nome = nome;		
		this.indirizzo = indirizzo;
		this.cartaDiCtredito = cartaDiCtredito;
		this.numeroDiTelefono = numeroDiTelefono;
		this.attivo = attivo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCartaDiCtredito() {
		return cartaDiCtredito;
	}
	public void setCartaDiCtredito(String cartaDiCtredito) {
		this.cartaDiCtredito = cartaDiCtredito;
	}
	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	
	
	

}
