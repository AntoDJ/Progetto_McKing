package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.AdminDAO;
import DAO.ProdottoDAO;
import DAO.RiderDAO;
import DAO.UtenteDAO;
import DBConnection.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;

import Admin.GestioneRiderGUI;
import Admin.OperazioneRistoranteGUI;
import AdminCatena.OperazioniCatenaGUI;
import Entità.Admin;
import Entità.Prodotto;
import Entità.Rider;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;
import General.AccessoGUI;
import General.LoginFormGUI;
import Utente.CatalogoGUI;
import Utility.RiderPanel;

public class Controller {
	private UtenteDAO utenteDao;
	private Utente utenteAttivo;
	private AdminDAO adminDao;
	private Admin adminAttivo;
	private String tipoAccesso;
	private ProdottoDAO prodottoDao;
	private RiderDAO riderDao;
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
// GUI
	private AccessoGUI accessoGui;
	private LoginFormGUI loginFormGui;
	private CatalogoGUI catalogoGui;
	private OperazioneRistoranteGUI operazioneRistoranteGui;
	private OperazioniCatenaGUI operazioniCatenaGui;
	private GestioneRiderGUI gestioneRiderGui;
	

	
	
	public Controller(){
		try {
			accessoGui = new AccessoGUI(this);
			accessoGui.setVisible(true);
		    utenteDao = new UtenteDAO();
		    adminDao = new AdminDAO();
		    prodottoDao = new ProdottoDAO();
		    riderDao = new RiderDAO();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void sceltaTipoAccesso(String tipoAccesso) {		
		loginFormGui = new LoginFormGUI(this);
		this.tipoAccesso = tipoAccesso;	
		accessoGui.setVisible(false);		
		loginFormGui.setVisible(true);	
	}
	
		
	public void verificaAccesso(String email, String password) throws AccountNonDisponibileException, IOException{
		System.out.println("Tipo " + tipoAccesso + "   Email " + email + "   Password " + password);
		if(tipoAccesso.equals("Utente")) {
			utenteAttivo= utenteDao.verificaAccesso(email, password);
			prodotti = prodottoDao.getProdottiAttivi();
			catalogoGui = new CatalogoGUI(this); 			
			loginFormGui.setVisible(false);			
			catalogoGui.setVisible(true);
			
			for(Prodotto i: prodotti) {
				System.out.println(i.getNome() + i.getUrl());				
			}
		}
		else { 
			adminAttivo= adminDao.verificaAccesso(email, password);
			loginFormGui.setVisible(false);
			if(adminAttivo.isAdminCatena()) {
				operazioniCatenaGui = new OperazioniCatenaGUI(this);
				operazioniCatenaGui.setVisible(true);						
			}
			else { 
				operazioneRistoranteGui = new OperazioneRistoranteGUI(this);
				operazioneRistoranteGui.setVisible(true);
			}							
		}
	}
	
	public ArrayList<Prodotto> getProdotti(){
		return prodotti;
	}
	
	public void gestisciRider() {
		try {
			gestioneRiderGui = new GestioneRiderGUI(this);
			popolaRider();
			operazioneRistoranteGui.setVisible(false);		
			gestioneRiderGui.setVisible(true);	
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
	
	public void popolaRider() throws SQLException {
		ArrayList<Rider> riderDisponibili = new ArrayList<Rider>();
		int size = 0;
		riderDisponibili = riderDao.getAllRiderDisponibili(adminAttivo);		
		for (int i=0; i<riderDisponibili.size(); i++) {
			size += 115;
			gestioneRiderGui.ordinePanel.add(new RiderPanel(riderDisponibili.get(i)));
			gestioneRiderGui.ordinePanel.add(Box.createVerticalStrut(10));			
		}
		gestioneRiderGui.ordinePanel.setPreferredSize(new Dimension(100,size));
		
		
	}
	
	

}
	
	

