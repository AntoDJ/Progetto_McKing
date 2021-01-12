package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.UtenteDAO;
import DBConnection.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;

import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class Controller {
	
	public static void main(String[] args) throws SQLException {
		UtenteDAO u1;
		DBConnection dbconnection= null;
		Connection connection= null;
				try {
					dbconnection = DBConnection.getInstance();
		            connection = dbconnection.getConnection();
		            System.out.println(connection);
		            u1 = new UtenteDAO(connection);
		            u1.verificaAccesso("pinco.pallo@gmail.com", "Pincolo02");
		            System.out.println(u1);
			
		} catch (AccountNonDisponibileException e) {
				e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
