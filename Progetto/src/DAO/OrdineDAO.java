package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DBConnection.DBConnection;
import Entità.Ordine;
import Entità.Rider;
import Entità.Utente;

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
				o = new Ordine(rs.getInt("IdOrdine"),rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), rs.getDouble("PrezzoTotale"), null, null);
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
				r = new Rider(rs.getInt("IdRider"), rs3.getString("Cognome"), rs3.getString("Nome"), rs3.getString("NumeroDiTelefono"), rs3.getString("TipoMezzo"), rs3.getBoolean("Attivo"),
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
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Ordine\" WHERE \"IdRistorante\" = ? AND \"IdRider\" IS NULL AND \"Consegnato\" = 'false' ; ");
			ps.setInt(1, IdRistorante);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//CREAZIONE Ordine
				o = new Ordine(rs.getInt("IdOrdine"), rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), rs.getDouble("PrezzoTotale"), null, null);
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
	
	
	public void cambioStatoConsegna(Ordine o) {
		try {
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE \"Ordine\" SET \"Consegnato\" = 'true' WHERE \"IdOrdine\" = ? ; ");
			ps.setInt(1, o.getIdOrdine());
			int rs = ps.executeUpdate();
			if (rs == 0)
				System.out.println("Erroreeeeeeeee");
			else System.out.println("Modificato");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void inserisciOrdine(Ordine nuovoOrdine) throws SQLException{
		connection = dbconnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO public.\"Ordine\"(\"DataOrdine\", \"OrarioPrevisto\", \"IndirizzoDiConsegna\", \"PrezzoTotale\", \"IdRistorante\", \"IdProfilo\")VALUES (to_timestamp(?, 'YYYY-MM-DD hh24:mi:ss')::timestamp without time zone at time zone 'Etc/UTC', ?, ?, ?, ?, ?);");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date date = new Date(System.currentTimeMillis());
		ps.setString(1, formatter.format(new Timestamp(System.currentTimeMillis())));
		ps.setTime(2, nuovoOrdine.getOrarioPrevisto());
		ps.setString(3, nuovoOrdine.getIndirizzoConsegna());
		ps.setDouble(4, nuovoOrdine.getPrezzoTotale());
		ps.setInt(5, nuovoOrdine.getRistorante().getId());
		ps.setInt(6, nuovoOrdine.getUtente().getId());
		int rs = ps.executeUpdate();
		if (rs == 0)
			System.out.println("Erroreeeeeeeee");
		else System.out.println("Modificato");	
		ps.close();
		connection.close();		
	}

	

	public ArrayList<Ordine> getStoricoRistorante(int idRistorante, String anno, String tipoMezzo, double prezzo){
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		Ordine o;
		Rider r;
		Utente u;
		String sql;
		int indiceAnno = 1;
		int indiceTipoMezzo = 1;
		int indicePrezzo = 1;
		
		try {
			connection = dbconnection.getConnection();
			sql = "SELECT * FROM \"Ordine\" NATURAL JOIN \"Rider\" AS R  WHERE 1=1 AND \"IdRistorante\" = ? ";
			
			if(anno != null){
				sql += "AND CAST (EXTRACT(YEAR FROM \"DataOrdine\") AS character varying) = ? ";
				indiceAnno++;
			}
			if(tipoMezzo != null){
				sql += "AND CAST ( R.\"TipoMezzo\" AS character varying ) = ? ";
				indiceTipoMezzo = indiceAnno + 1;
			}
			else indiceTipoMezzo = indiceAnno;
			if(prezzo != 0.0){
				sql += "AND \"PrezzoTotale\" > ?  ";
				indicePrezzo = indiceTipoMezzo + 1;
			}
			
			sql += "ORDER BY \"DataOrdine\" ASC; ";			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			
			ps.setInt(1, idRistorante);
			
			if(anno != null){
				ps.setString(indiceAnno, anno);
			}
			if(tipoMezzo != null){
				ps.setString(indiceTipoMezzo, tipoMezzo);
			}
			if(prezzo != 0.0){
				ps.setDouble(indicePrezzo, prezzo);
			}
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				//CREAZIONE ORDINE
				o = new Ordine(rs.getInt("IdOrdine"), rs.getDate("DataOrdine"), rs.getTime("OrarioPrevisto"), rs.getString("IndirizzoDiConsegna"), rs.getBoolean("Consegnato"), rs.getDouble("PrezzoTotale"), null, null);
				ordini.add(o);
				System.out.println(o);

				//CREAZIONE RIDER
				r = new Rider(rs.getInt("IdRider"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("NumeroDiTelefono"), rs.getString("TipoMezzo"), rs.getBoolean("Attivo"),
						rs.getInt("IdRistorante"));	
				o.setRider(r);
				System.out.println("RIDERRRRRRRRR");
				
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordini;
	}
	
	
	
	
	
	
	
	
	

}
