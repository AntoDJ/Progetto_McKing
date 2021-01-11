package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DBConnection;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class UtenteDAO {
	
	DBConnection dbconnection= null;
	Connection connection= null;
	
	
	
	
	public Utente verificaAccesso(String email, String password) throws AccountNonDisponibileException  {		
		
		try { 
			dbconnection= DBConnection.getInstance();
			connection = dbconnection.getConnection();		
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM \"Profilo\" WHERE \"Email\"='" + email + "' AND \"Password\"='"  + password + "'");			
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
			dbconnection= DBConnection.getInstance();
			connection = dbconnection.getConnection();		
			Statement st= connection.createStatement();
			ResultSet rs = st.executeQuery("UPDATE \"Profilo\" SET \"Indirizzo\" ='"+ nuovoIndirizzo + "', \"CartaDiCredito\" ='" +
											nuovaCartaDiCredito + "\"NumeroDiTelefono\" ='" + nuovoNumeroDiTelefono+ "' WHERE \"Email\" ='"+ utente.getEmail() + "';" );			
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
