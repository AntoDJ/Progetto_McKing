package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import DBConnection.DBConnection;
import Entit�.Admin;
import Entit�.Ordine;
import Entit�.Rider;
import Entit�.Ristorante;

public class RiderDAO {
	DBConnection dbconnection = null;
	Connection connection = null;
	private ArrayList<Rider> rider;
	
	public RiderDAO() {
		try {
			dbconnection = DBConnection.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Rider> getAllRiderDisponibili(Admin admin) throws SQLException{
		try {
			connection = dbconnection.getConnection();	
			rider = new ArrayList<Rider>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"Rider\" WHERE \"IdRistorante\" = ?  AND \"Attivo\" = 'true'; ");
			ps.setInt(1, admin.getIdRistorante());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Rider r = new Rider(rs.getInt("IdRider"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("NumeroDiTelefono"), rs.getString("TipoMezzo"), rs.getBoolean("Attivo"), rs.getInt("IdRistorante"));
				rider.add(r);
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return rider;
	}
	
	//get rider con meno di 3 consegne
	public ArrayList<Rider> getRider(Admin admin) throws SQLException{
		try {
			connection = dbconnection.getConnection();
			int tot=0;
			rider = new ArrayList<Rider>();
			PreparedStatement ps = connection.prepareStatement("SELECT *, (SELECT COUNT(*) FROM \"Ordine\" AS O WHERE  O.\"Consegnato\"='false' AND O.\"IdRider\" = \"Rider\".\"IdRider\") AS TOT FROM \"Rider\" WHERE \"IdRistorante\"= ? AND \"Attivo\" = 'true'; ");
			ps.setInt(1, admin.getIdRistorante());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tot = rs.getInt("tot");
				if(tot < 3) {
				Rider r = new Rider(rs.getInt("IdRider"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("NumeroDiTelefono"), rs.getString("TipoMezzo"), rs.getBoolean("Attivo"), rs.getInt("IdRistorante"));
				rider.add(r);
				}
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return rider;
	}
	
	// VIENE ASSEGNATO IL RIDER AD UN ORDINE
	public void aggiungiRider(Ordine o) {
		try {
			connection = dbconnection.getConnection();	
			PreparedStatement ps = connection.prepareStatement("UPDATE \"Ordine\" SET \"IdRider\" = ? WHERE \"IdOrdine\" = ? ; ");
			ps.setInt(1, o.getRider().getIdRider());
			ps.setInt(2, o.getIdOrdine());
			int rs = ps.executeUpdate();
			if(rs == 0) {
				System.out.println("Erroreeeee");
			    System.out.println(o.getRider().getIdRider());
			    System.out.println(o.getIdOrdine());
			}
			
			else System.out.println("Modificato");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	// VIENE ELIMINATO UN RIDER DAL DB
	public int elimiaRider(Rider rider) {
		try {
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE \"Rider\" SET \"Attivo\" = 'false' WHERE \"IdRider\" = ? ; ");
			ps.setInt(1, rider.getIdRider());
			int rs = ps.executeUpdate();
			if(rs == 0)
				return 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	// VIENE INSERITO UN NUOVO RIDER NEL DB
	public int inserisciRider(Rider r) {
		int risultato = 0;
		try {
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Rider\"( \"Cognome\", \"Nome\", \"NumeroDiTelefono\", \"TipoMezzo\", \"Attivo\", \"IdRistorante\") VALUES ( ?, ?, ?, CAST (? AS \"TipoMezzo\"), ?, ?); ");
			ps.setString(1, r.getCognome());
			ps.setString(2, r.getNome());
			ps.setString(3, r.getNumeroDiTelefono());
			ps.setString(4, r.getTipoMezzo());
			ps.setBoolean(5, true);
			ps.setInt(6, r.getIdRistorante());
			
			System.out.println(r.getCognome()+ r.getNome() + r.getNumeroDiTelefono() + r.getTipoMezzo());
			
			int rs = ps.executeUpdate();
			if(rs == 0) System.out.println("Rider inserito correttamente");
			else System.out.println("Rider inserito correttamente");
			risultato = rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risultato;
	}
	
	

}
