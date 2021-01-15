package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Ordine;

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
			ordiniAssegnati = new ArrayList<Ordine>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Ordine\" WHERE \"IdRistorante\" = ? AND \"IdRider\" IS NOT NULL ;");
			ps.setInt(1, IdRistorante);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ordine o = new Ordine(rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), 
										rs.getDouble("PrezzoTotale"), rs.getInt("IdRistorante"), rs.getInt("IdRider"), rs.getInt("IdProfilo"));
				ordiniAssegnati.add(o);
				System.out.println(o);
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
			ordiniAssegnati = new ArrayList<Ordine>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Ordine\" WHERE \"IdRistorante\" = ? AND \"IdRider\" IS NULL ;");
			ps.setInt(1, IdRistorante);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ordine o = new Ordine(rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), 
										rs.getDouble("PrezzoTotale"), rs.getInt("IdRistorante"), rs.getInt("IdRider"), rs.getInt("IdProfilo"));
				ordiniAssegnati.add(o);
				System.out.println(o);
			}
			ps.close();
			connection.close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ordiniAssegnati;		
	}

}
