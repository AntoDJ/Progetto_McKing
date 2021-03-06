package Entit�;

public class Admin {
	
	private boolean adminCatena;
	private String cognome;
	private String nome;
	private String email;
	private String password;
	private boolean attivo;	
	private int idRistorante;

	public Admin(boolean adminCatena, String cognome, String nome, String email, String password, boolean attivo, int idRistorante) {
		super();
		this.adminCatena = adminCatena;
		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.attivo = attivo;
		this.idRistorante = idRistorante;
	}
	
	public int getIdRistorante() {
		return idRistorante;
	}
	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
	}	
	public boolean isAdminCatena() {
		return adminCatena;
	}
	public void setAdminCatena(boolean adminCatena) {
		this.adminCatena = adminCatena;
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
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "Admin [adminCatena=" + adminCatena + ", cognome=" + cognome + ", nome=" + nome + ", email=" + email
				+ ", password=" + password + ", attivo=" + attivo + "]";
	}
	
	
	

}
