package Entità;

public class Utente {

	private int id;
	private String cognome;
	private String nome;
	private String email;
	private String password;
	private String indirizzo;
	private String cartaDiCredito;
	private String numeroDiTelefono;
	private boolean attivo;
	
	
	
	public Utente(String cognome, String nome, String indirizzo, String email,String cartaDiCtredito,
			String numeroDiTelefono, boolean attivo) {
		super();
		this.cognome = cognome;
		this.nome = nome;		
		this.indirizzo = indirizzo;
		this.email = email;
		this.cartaDiCredito = cartaDiCtredito;
		this.numeroDiTelefono = numeroDiTelefono;
		this.attivo = attivo;
	}
	public Utente(int id, String cognome, String nome, String indirizzo, String email,String cartaDiCtredito,
			String numeroDiTelefono, boolean attivo) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;		
		this.indirizzo = indirizzo;
		this.email = email;
		this.cartaDiCredito = cartaDiCtredito;
		this.numeroDiTelefono = numeroDiTelefono;
		this.attivo = attivo;
	}
	public Utente(String nome, String cognome, String email, String password, String indirizzo, String numeroDiTelefono, String cartaDiCredito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.numeroDiTelefono = numeroDiTelefono;
		this.cartaDiCredito = cartaDiCredito;
		this.attivo = true;
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
	public String getCartaDiCredito() {
		return cartaDiCredito;
	}
	public void setCartaDiCredito(String cartaDiCtredito) {
		this.cartaDiCredito = cartaDiCtredito;
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
	@Override
	public String toString() {
		return "Utente [cognome=" + cognome + ", nome=" + nome + ", email=" + email + ", password=" + password
				+ ", indirizzo=" + indirizzo + ", cartaDiCredito=" + cartaDiCredito + ", numeroDiTelefono="
				+ numeroDiTelefono + ", attivo=" + attivo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
