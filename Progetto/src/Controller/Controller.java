package Controller;

import DAO.UtenteDAO;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;

public class Controller {
	
	public static void main(String[] args) {
		UtenteDAO u1= new UtenteDAO();
		try {
			Utente utente = u1.verificaAccesso("pinco.pallo@gmail.com", "Pincolo02");
			System.out.println(utente.getCognome());
		} catch (AccountNonDisponibileException e) {
				e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
