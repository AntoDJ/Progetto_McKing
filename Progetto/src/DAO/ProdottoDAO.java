package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			ResultSet rs = st.executeQuery("SELECT * FROM \"Prodotto\" AS \"P\" NATURAL JOIN \"ImmaginiProdotti\" WHERE \"P\".\"Attivo\" = 'true' ORDER BY \"TipoProdotto\" ;" );
			while(rs.next()) {
				Prodotto prodotto = new Prodotto(rs.getString("Nome"), rs.getDouble("Prezzo"), rs.getString("Dimensione"), rs.getString("TipoProdotto"), rs.getBoolean("Attivo"), rs.getString("URLImmagine"));
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
				Prodotto prodotto = new Prodotto(rs.getString("Nome"), rs.getDouble("Prezzo"), rs.getString("Dimensione"), rs.getString("TipoProdotto"), rs.getBoolean("Attivo"), rs.getString("URLImmagine"));
				prodotti.add(prodotto);
			}
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

	public ArrayList<Prodotto> getProdottiAttivi(String tipoProdotto) {
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			dbconnection = DBConnection.getInstance();
			connection = dbconnection.getConnection();		
			PreparedStatement ps = connection.prepareStatement("Select DISTINCT \"Nome\", \"URLImmagine\" from \"Prodotto\" AS \"P\" NATURAL JOIN \"ImmaginiProdotti\" WHERE \"P\".\"Attivo\" = 'true' AND \"P\".\"TipoProdotto\" = CAST( ? AS \"TipoProdotto\") ORDER BY \"Nome\";" );
			ps.setString(1, tipoProdotto);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Prodotto prodotto = new Prodotto(rs.getString("Nome"), rs.getString("URLImmagine"));
				System.out.println(prodotto + " aggiunto");
				prodotti.add(prodotto);
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodotti;
	}

}
