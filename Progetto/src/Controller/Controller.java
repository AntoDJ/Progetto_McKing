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
	private UtenteDAO utenteDao;
	
	public Controller(){
		try {
		    utenteDao = new UtenteDAO();
		    utenteDao.verificaAccesso("pinco.pallo@gmail.com", "Pincolo02");
		    System.out.println(utenteDao);
		} catch (AccountNonDisponibileException e) {
				e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}