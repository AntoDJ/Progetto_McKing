package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DBConnection;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class UtenteDAO {
	Connection connection;
	
	public UtenteDAO(Connection connection2) {
		this.connection= connection2;
	}

	
	public Utente verificaAccesso(String email, String password) throws AccountNonDisponibileException  {		
		
		try { 
			
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM \"Profilo\" WHERE \"Email\"=? AND \"Password\"=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();			
			if (rs.next()== true) {				 
				Utente profilo= new Utente(rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Indirizzo"), rs.getString("CartaDiCredito"), 
										rs.getString("NumeroDiTelefono"), rs.getBoolean("Attivo"));
			
				if(profilo.isAttivo()==true) {
					connection.close();
					return profilo;
				}				
			}
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		throw new AccountNonDisponibileException();		
	}
	
	
	public void modificaDati(Utente utente, String nuovoNumeroDiTelefono, String nuovaCartaDiCredito, String nuovoIndirizzo) {
		try { 
			
			PreparedStatement ps= connection.prepareStatement("UPDATE \"Profilo\" SET \"Indirizzo\" =?, \"CartaDiCredito\" =? \"NumeroDiTelefono\" =? WHERE \"Email\" =?;");
			ps.setString(1, nuovoIndirizzo);
			ps.setString(2, nuovaCartaDiCredito);
			ps.setString(3,nuovoNumeroDiTelefono);
			ps.setString(4,utente.getEmail());			
			ResultSet rs = ps.executeQuery();			
			if (rs.next()== true) {				 
				Utente profilo= new Utente(rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Indirizzo"), rs.getString("CartaDiCredito"), 
										rs.getString("NumeroDiTelefono"), rs.getBoolean("Attivo"));
			}
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			//Avremmo potuto trattare meglio le regex
		}
		
	}

}
