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
import General.AccessoGUI;

public class Controller {
	private UtenteDAO utenteDao;
	private Utente utenteAttivo;
	
	private AccessoGUI accessogui;
	
	public Controller(){
		try {
			accessogui = new AccessoGUI(this);
			accessogui.setVisible(true);
			
		    utenteDao = new UtenteDAO();
		    utenteAttivo = utenteDao.verificaAccesso("pinco.pallo@gmail.com", "Pincolo02");
		    System.out.println(utenteAttivo);
		    utenteDao.modificaDati(utenteAttivo, "+3132131422146", null, "Via Boccone, 10");
		    System.out.println(utenteAttivo);
		} catch (AccountNonDisponibileException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.print("Errore inserimento");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
