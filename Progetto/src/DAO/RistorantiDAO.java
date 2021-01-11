package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Ristorante;

public class RistorantiDAO {
	DBConnection dbconnection = null;
	Connection connection = null;
	
	
	//prendo tutti i ristoranti attivi da mostrare sia in VisualizzaRistoranteGUI che in DettagliOrdine
	public ArrayList<Ristorante> getRstoranti(){		
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			dbconnection = DBConnection.getInstance();
			connection = dbconnection.getConnection();
			Statement st = connection.createStatement();			
			ResultSet rs= st.executeQuery("SELECT * FROM \"Ristorante\" WHERE \"Attivo\"='False';");
			
			
			while(rs.next()) {
				Ristorante ristorante = new Ristorante(rs.getString("Citta"), rs.getString("Indirizzo"), rs.getString("NumeroDiTelefono"), 
														rs.getTime("OrarioApertura"), rs.getTime("OrarioChiusura"), rs.getDouble("DistanzaMassima"));	
				ristoranti.add(ristorante);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return ristoranti;	
	}
}
