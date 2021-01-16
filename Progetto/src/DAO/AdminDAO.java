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
				Admin profilo = new Admin(rs.getBoolean("AdminCatena"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Email"), rs.getBoolean("Attivo"), rs.getInt("IdRistorante"));
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

}
