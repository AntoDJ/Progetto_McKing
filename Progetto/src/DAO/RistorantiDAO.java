package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Rider;
import Entità.Ristorante;
import Entità.Utente;

public class RistorantiDAO {
	DBConnection dbconnection = null;
	Connection connection = null;
	
	public RistorantiDAO() {
		try {
			dbconnection = DBConnection.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	//prendo tutti i ristoranti attivi da mostrare sia in VisualizzaRistoranteGUI che in DettagliOrdine
	public ArrayList<Ristorante> getRistorantiAttivi(){		
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			connection = dbconnection.getConnection();
			Statement st = connection.createStatement();			
			ResultSet rs= st.executeQuery("SELECT * FROM \"Ristorante\" WHERE \"Attivo\"='TRUE' ORDER BY \"Città\";");
			
			
			while(rs.next()) {
				Ristorante ristorante = new Ristorante(rs.getString("Città"), rs.getString("Indirizzo"), rs.getString("NumeroDiTelefono"), 
														rs.getTime("OrarioApertura"), rs.getTime("OrarioChiusura"), rs.getDouble("DistanzaMassima"));	
				ristoranti.add(ristorante);
			}
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return ristoranti;	
	}
	public ArrayList<Ristorante> getRistorantiConsegna(){		
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			connection = dbconnection.getConnection();
			Statement st = connection.createStatement();			
			ResultSet rs= st.executeQuery("SELECT * FROM \"Ristorante\" WHERE \"Attivo\"='TRUE';");
			
			
			while(rs.next()) {
				Ristorante ristorante = new Ristorante(rs.getInt("IdRistorante"), rs.getString("Città"), rs.getString("Indirizzo"), rs.getString("NumeroDiTelefono"), 
														rs.getTime("OrarioApertura"), rs.getTime("OrarioChiusura"), rs.getDouble("DistanzaMassima"));	
				ristoranti.add(ristorante);
			}
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return ristoranti;	
	}
	
	public int inserisciRistorante(Ristorante ristorante) {
		int rs = 0;
		
		try {
			connection = dbconnection.getConnection();	
			PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Ristorante\"(\"Città\", \"Indirizzo\", \"NumeroDiTelefono\", \"OrarioApertura\", \"OrarioChiusura\", \"DistanzaMassima\", \"Attivo\", \"IdAdmin\") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?); ");
			ps.setString(1, ristorante.getCitta());
			ps.setString(2, ristorante.getIndirizzo());
			ps.setString(3, ristorante.getNumeroDiTelefono());
			ps.setTime(4, ristorante.getOrarioApertura());
			ps.setTime(5, ristorante.getOrarioChiusura());
			ps.setDouble(6, 0.0);
			ps.setBoolean(7, true);
			ps.setInt(8, ristorante.getIdAdmin());
			rs = ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return rs;
	}
	
	
	public int getIdRistornateDao(Ristorante ristorante) {
		int ritorno = 0;
		
		try {
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT \"IdRistorante\" FROM \"Ristorante\" WHERE \"Città\" = ? AND \"Indirizzo\" = ? ;");
			ps.setString(1, ristorante.getCitta());
			ps.setString(2, ristorante.getIndirizzo());
			ResultSet rs = ps.executeQuery();
			if(rs.next() == true)
				ritorno = rs.getInt("IdRistorante");
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ritorno;
	}
	
}
