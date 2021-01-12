package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Prodotto;

public class ProdottoDAO {
	
	DBConnection dbconnection= null;
	Connection connection= null;
	
	
	//funzione che prende tutti i prodotti da inserire del catalogo (in questo modo ho anche la dimensione dei prodotti per "Dettagli"<OrdineProdottoGUI)
	public ArrayList<Prodotto> getProdottiAttivi() {
		 ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			dbconnection = DBConnection.getInstance();
			connection = dbconnection.getConnection();		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM \"Prodotto\" WHERE \"Attivo\"='TRUE';" );
			while(rs.next()) {
				Prodotto prodotto = new Prodotto(rs.getString("Nome"), rs.getDouble("Prezzo"), rs.getString("Dimensione"), rs.getString("TipoProdotto"), rs.getBoolean("Attivo"));
				prodotti.add(prodotto);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}
	
	//funzione che prende tutti i prodotti dal database (attivi e non) per poterli gestire in GestioneCatalogoGUI
	public ArrayList<Prodotto> getAllProdotti(){
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			dbconnection = DBConnection.getInstance();
			connection = dbconnection.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM \"Prodotto\";");
			while(rs.next()) {
				Prodotto prodotto = new Prodotto(rs.getString("Nome"), rs.getDouble("Prezzo"), rs.getString("Dimensione"), rs.getString("TipoProdotto"), rs.getBoolean("Attivo"));
				prodotti.add(prodotto);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

}
