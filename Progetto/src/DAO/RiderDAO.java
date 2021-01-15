package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Admin;
import Entità.Rider;

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
				Rider r = new Rider(rs.getString("Cognome"), rs.getString("Nome"), rs.getString("NumeroDiTelefono"), rs.getString("TipoMezzo"), rs.getBoolean("Attivo"), rs.getInt("IdRistorante"));
				rider.add(r);
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return rider;
	}

}
