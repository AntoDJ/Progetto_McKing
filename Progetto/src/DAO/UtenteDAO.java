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
	
	DBConnection dbconnection= null;
	Connection connection= null;
	
	public void UtenteDao() {
		try {
			dbconnection= DBConnection.getInstance();
			System.out.println(dbconnection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Utente verificaAccesso(String email, String password) throws AccountNonDisponibileException  {		
		
		try { 
			dbconnection.avviaConnessione();
			
			connection = dbconnection.getConnection();		
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM \"Profilo\" WHERE \"Email\"='?' AND \"Password\"='?'");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();			
			if (rs.next()== true) {				 
				Utente profilo= new Utente(rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Indirizzo"), rs.getString("CartaDiCredito"), 
										rs.getString("NumeroDiTelefono"));
			
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
			PreparedStatement ps= connection.prepareStatement("UPDATE \"Profilo\" SET \"Indirizzo\" ='?', \"CartaDiCredito\" ='?' \"NumeroDiTelefono\" ='?' WHERE \"Email\" ='?';");
			ps.setString(1, nuovoIndirizzo);
			ps.setString(2, nuovaCartaDiCredito);
			ps.setString(3,nuovoNumeroDiTelefono);
			ps.setString(4,utente.getEmail());			
			ResultSet rs = ps.executeQuery();			
			if (rs.next()== true) {				 
				Utente profilo= new Utente(rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Indirizzo"), rs.getString("CartaDiCredito"), 
										rs.getString("NumeroDiTelefono"));
			}
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			//Avremmo potuto trattare meglio le regex
		}
		
	}

}
