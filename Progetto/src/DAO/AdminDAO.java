package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConnection;
import Entità.Admin;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class AdminDAO {
	private Connection connection = null;
	private DBConnection dbconnection = null;
	
	public AdminDAO() {
		try {
			dbconnection = DBConnection.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Admin verificaAccesso(String email, String password) throws AccountNonDisponibileException  {		
			
		try { 
			connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM \"Admin\" WHERE \"Email\"=? AND \"Password\"=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();			
			if (rs.next() == true) {				 
				Admin profilo = new Admin(rs.getBoolean("AdminCatena"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Email"), null ,rs.getBoolean("Attivo"), rs.getInt("IdRistorante"));
				if(profilo.isAttivo() == true) {
					connection.close();
					return profilo;
				}				
			}
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		throw new AccountNonDisponibileException();		
	}
	
	
	public void creaAdminCatenaDao(Admin admin)throws SQLException{ 
			connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("INSERT INTO \"Admin\"(\"AdminCatena\", \"Cognome\", \"Nome\", \"Email\", \"Password\", \"Attivo\", \"IdRistorante\") VALUES ( ?, ?, ?, ?, ?, ?, ?);");
			ps.setBoolean(1, admin.isAdminCatena());
			ps.setString(2, admin.getCognome());
			ps.setString(3, admin.getNome());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getPassword());
			ps.setBoolean(6, admin.isAttivo());
			ps.setInt(7, 0);
			ps.executeUpdate();			
			ps.close();
			connection.close();
	}
	
	public int getIdAdmin(Admin admin) {
		int id = 0;
		try { 
			connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("select \"IdAdmin\" from \"Admin\" where \"Email\" = ? ");
			ps.setString(1, admin.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next() == true)
				id = rs.getInt("IdAdmin");
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void modificaIdRistoranteDao(Admin admin, int id) throws SQLException {
		
			connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("UPDATE \"Admin\" SET \"IdRistorante\" = ? WHERE \"Email\" = ? ;");
			ps.setInt(1, id);
			ps.setString(2, admin.getEmail());
			ps.executeUpdate();			
			ps.close();
			connection.close();
	
	}

	public String getAdminFromId(int idAdmin) {
		String admin = new String("");
		try { 
			connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("select \"Nome\", \"Cognome\" from \"Admin\" where \"IdRistorante\" = ? ");
			ps.setInt(1, idAdmin);
			ResultSet rs = ps.executeQuery();
			if(rs.next() == true)
				admin = rs.getString("Nome") + " " + rs.getString("Cognome");
			System.out.println("Admin e' " + admin);
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
}