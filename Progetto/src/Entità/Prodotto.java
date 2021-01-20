package Entità;

public class Prodotto {
	
	private String nome;
	private double prezzo;
	private String dimensione;
	private String tipoProdotto;
	private boolean attivo;
	private String url;
	private int quantità = 0;
	
	
	public Prodotto(String nome, double prezzo, String dimensione, String tipoProdotto, boolean attivo, String url) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.dimensione = dimensione;
		this.tipoProdotto = tipoProdotto;
		this.attivo = attivo;
		this.url = url;
	}
	public Prodotto(String nome, String url) {
		super();
		this.nome = nome;
		this.url = url;
	}
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", prezzo=" + prezzo + ", dimensione=" + dimensione + ", tipoProdotto="
				+ tipoProdotto + ", attivo=" + attivo + ", quantità=" + quantità + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dimensione == null) ? 0 : dimensione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (dimensione == null) {
			if (other.dimensione != null)
				return false;
		} else if (!dimensione.equals(other.dimensione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
