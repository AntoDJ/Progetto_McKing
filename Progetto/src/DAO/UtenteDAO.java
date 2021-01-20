package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBConnection;
import Entità.Ordine;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class UtenteDAO {
	private Connection connection = null;
	private DBConnection dbconnection = null;
	
	public UtenteDAO() {
		try {
			dbconnection = DBConnection.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Utente verificaAccesso(String email, String password) throws AccountNonDisponibileException  {		
		
		try { 
		    connection = dbconnection.getConnection();
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM \"Profilo\" WHERE \"Email\"=? AND \"Password\"=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();			
			if (rs.next()== true) {				 
				Utente profilo= new Utente(rs.getInt("IdProfilo"), rs.getString("Cognome"), rs.getString("Nome"), rs.getString("Indirizzo"), rs.getString("Email"), rs.getString("CartaDiCredito"), 
										rs.getString("NumeroDiTelefono"), rs.getBoolean("Attivo"));
			
				if(profilo.isAttivo()==true) {
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
	
	
	public void modificaDati(Utente utente, String nuovoNumeroDiTelefono, String nuovaCartaDiCredito, String nuovoIndirizzo) {
		try { 
			connection = dbconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE \"Profilo\" SET \"Indirizzo\" = ?, \"CartaDiCredito\" = ?, \"NumeroDiTelefono\" = ? WHERE \"Email\" = ?;");
			ps.setString(1, nuovoIndirizzo == null ? utente.getIndirizzo() : nuovoIndirizzo);
			ps.setString(2, nuovaCartaDiCredito == null ? utente.getCartaDiCredito(): nuovaCartaDiCredito);
			ps.setString(3, nuovoNumeroDiTelefono == null ? utente.getNumeroDiTelefono() : nuovoNumeroDiTelefono);
			ps.setString(4, utente.getEmail());			
			int updateEffettuato = ps.executeUpdate();
			System.out.println();
			if (updateEffettuato == 1) {				 
				utente.setIndirizzo(nuovoIndirizzo == null ? utente.getIndirizzo() : nuovoIndirizzo);
				utente.setCartaDiCredito(nuovaCartaDiCredito == null ? utente.getCartaDiCredito(): nuovaCartaDiCredito);
				utente.setNumeroDiTelefono(nuovoNumeroDiTelefono == null ? utente.getNumeroDiTelefono() : nuovoNumeroDiTelefono);
			}
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			//Avremmo potuto trattare meglio le regex
		}
		
	}
	



	public void modificaNumero(String email, String nuovoNumeroDiTelefono) throws SQLException {
		connection = dbconnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("UPDATE \"Profilo\" SET \"NumeroDiTelefono\" = ? WHERE \"Email\" = ?;");
		ps.setString(1, nuovoNumeroDiTelefono);
		ps.setString(2, email);
		int updateEffettuato = ps.executeUpdate();
		System.out.println(updateEffettuato == 1 ? "Update eseguito" : "Update non eseguito");
		ps.close();
		connection.close();
	}
	public void modificaCarta(String email, String nuovoCartaDiCredito) throws SQLException {
		connection = dbconnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("UPDATE \"Profilo\" SET \"CartaDiCredito\" = ? WHERE \"Email\" = ?;");
		ps.setString(1, nuovoCartaDiCredito);
		ps.setString(2, email);
		int updateEffettuato = ps.executeUpdate();
		System.out.println(updateEffettuato == 1 ? "Update eseguito" : "Update non eseguito");
		ps.close();
		connection.close();
	}
	public void modificaIndirizzo(String email, String nuovoIndirizzo) throws SQLException {
		connection = dbconnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("UPDATE \"Profilo\" SET \"Indirizzo\" = ? WHERE \"Email\" = ?;");
		ps.setString(1, nuovoIndirizzo);
		ps.setString(2, email);
		int updateEffettuato = ps.executeUpdate();
		System.out.println(updateEffettuato == 1 ? "Update eseguito" : "Update non eseguito");
		ps.close();
		connection.close();
	}

}
