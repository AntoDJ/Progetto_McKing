package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entit�.Ordine;
import Entit�.Rider;
import Entit�.Utente;

public class OrdineDAO {
	DBConnection dbconnection = null;
	Connection connection = null;
	ArrayList<Ordine> ordiniAssegnati;
	ArrayList<Ordine> ordiniDaAssegnare;
	
	public OrdineDAO() {
		try {
			dbconnection = DBConnection.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ordine> getOrdiniAssegnati(int IdRistorante) {
		try {
			connection = dbconnection.getConnection();
			Ordine o;
			Utente u;
			Rider r;
			ordiniAssegnati = new ArrayList<Ordine>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Ordine\" WHERE \"IdRistorante\" = ? AND \"IdRider\" IS NOT NULL AND \"Consegnato\" = 'false' ;");
			ps.setInt(1, IdRistorante);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//CREAZIONE Ordine
				o = new Ordine(rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), rs.getDouble("PrezzoTotale"), null, null);
				ordiniAssegnati.add(o);
				System.out.println(o);				
				

				//CREAZIONE UTENTE
				PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM \"Profilo\" WHERE \"IdProfilo\" = ?  ;" );											
				ps2.setInt(1, rs.getInt("IdProfilo"));
				ResultSet rs2 = ps2.executeQuery();	
				rs2.next();
				u = new Utente(rs2.getString("Cognome"), rs2.getString("Nome"), rs2.getString("Indirizzo"), rs2.getString("Email"), rs2.getString("CartaDiCredito"), 
									rs2.getString("NumeroDiTelefono"), rs2.getBoolean("Attivo"));	
				o.setUtente(u);				
				System.out.println("UTENTEEEE");				
				ps2.close();
				
				
				//CREAZIONE RIDER
				PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM \"Rider\" WHERE \"IdRider\" = ?  ;" );											
				ps3.setInt(1, rs.getInt("IdRider"));
				ResultSet rs3 = ps3.executeQuery();	
				rs3.next();
				r = new Rider(rs3.getString("Cognome"), rs3.getString("Nome"), rs3.getString("NumeroDiTelefono"), rs3.getString("TipoMezzo"), rs3.getBoolean("Attivo"),
						rs3.getInt("IdRistorante"));	
				o.setRider(r);
				System.out.println("RIDERRRRRRRRR");
				ps3.close();				
			}
			ps.close();			
			
			connection.close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ordiniAssegnati;		
	}
	
	public ArrayList<Ordine> getOrdiniDaAssegnare(int IdRistorante) {
		try {
			connection = dbconnection.getConnection();
			Ordine o;
			Utente u;
			Rider r;
			ordiniAssegnati = new ArrayList<Ordine>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Ordine\" WHERE \"IdRistorante\" = ? AND \"IdRider\" IS NULL ;");
			ps.setInt(1, IdRistorante);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//CREAZIONE Ordine
				o = new Ordine(rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), rs.getDouble("PrezzoTotale"), null, null);
				ordiniAssegnati.add(o);
				System.out.println(o);				
				

				//CREAZIONE UTENTE
				PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM \"Profilo\" WHERE \"IdProfilo\" = ?  ;" );											
				ps2.setInt(1, rs.getInt("IdProfilo"));
				ResultSet rs2 = ps2.executeQuery();	
				rs2.next();
				u = new Utente(rs2.getString("Cognome"), rs2.getString("Nome"), rs2.getString("Indirizzo"), rs2.getString("Email"), rs2.getString("CartaDiCredito"), 
									rs2.getString("NumeroDiTelefono"), rs2.getBoolean("Attivo"));	
				o.setUtente(u);				
				System.out.println("UTENTEEEE");				
				ps2.close();
				
			}
			ps.close();
			connection.close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ordiniAssegnati;		
	}

}