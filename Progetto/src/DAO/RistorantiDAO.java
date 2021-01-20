package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Ristorante;
import Entità.Utente;

public class RistorantiDAO {
	DBConnection dbconnection = null;
	Connection connection = null;
	
	
	//prendo tutti i ristoranti attivi da mostrare sia in VisualizzaRistoranteGUI che in DettagliOrdine
	public ArrayList<Ristorante> getRistorantiAttivi(){		
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			dbconnection = DBConnection.getInstance();
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
			dbconnection = DBConnection.getInstance();
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
	
}
