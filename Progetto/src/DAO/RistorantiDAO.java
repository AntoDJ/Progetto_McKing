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
	
	
	//prendo tutti i ristoranti (solo attivi o tutti)
	public ArrayList<Ristorante> getRistoranti(boolean soloAttivi){		
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			connection = dbconnection.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs;
			if (soloAttivi)
				rs = st.executeQuery("SELECT * FROM \"Ristorante\" WHERE \"Attivo\"='TRUE' ORDER BY \"Città\";");
			else
				rs = st.executeQuery("SELECT * FROM \"Ristorante\" ORDER BY \"Città\";");
			
			while(rs.next()) {
				Ristorante ristorante = new Ristorante(rs.getInt("IdRistorante"), rs.getString("Città"), rs.getString("Indirizzo"), rs.getString("NumeroDiTelefono"), 
														rs.getTime("OrarioApertura"), rs.getTime("OrarioChiusura"), rs.getDouble("DistanzaMassima"), rs.getBoolean("Attivo"));	
				ristoranti.add(ristorante);
			}
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return ristoranti;	
	}
	
	public void inserisciRistorante(Ristorante ristorante) throws SQLException{
		
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
			ps.executeUpdate();
			ps.close();
			connection.close();
		
	}
	
	
	public int getIdRistoranteDao(Ristorante ristorante) {
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


	public void modificaStatoAttività(int id, boolean b) {
		try {
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE \"Ristorante\" SET \"Attivo\" = ? WHERE \"IdRistorante\" = ?;");
			ps.setBoolean(1, b);
			ps.setInt(2, id);
			int updateEffettuato = ps.executeUpdate();
			System.out.println(updateEffettuato == 1 ? "Update eseguito" : "Update non eseguito");
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
