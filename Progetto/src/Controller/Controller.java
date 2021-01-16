package Controller;

import java.awt.Container;
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

import javax.swing.JPanel;


import Admin.OperazioneRistoranteGUI;
import AdminCatena.OperazioniCatenaGUI;
import Entit�.Admin;
import Entit�.Prodotto;
import Entit�.Rider;
import Entit�.Utente;
import ExceptionsSQL.AccountNonDisponibileException;
import General.AccessoGUI;
import General.LoginFormGUI;
import Utente.CatalogoGUI;
import Utente.DettagliOrdineProdottoGUI;
import Utente.ProfiloGUI;
import Utility.RiderPanel;

import Utility.ModernScrollPane;
import Utility.ProdottoPanel;


public class Controller {
	private UtenteDAO utenteDao;
	private Utente utenteAttivo;
	private AdminDAO adminDao;
	private Admin adminAttivo;
	private String tipoAccesso;
	private ProdottoDAO prodottoDao;
	private RiderDAO riderDao;
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Prodotto> carrello;
// GUI
	private AccessoGUI accessoGui;
	private LoginFormGUI loginFormGui;
	private CatalogoGUI catalogoGui;
	private ProfiloGUI profiloGui;
	private DettagliOrdineProdottoGUI dettagliOrdineProdottoGui;
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
			catalogoGui = new CatalogoGUI(this); 			
			loginFormGui.setVisible(false);
			//Preparo la finestra prima di aprirla e creo il carrello dell'utente
			popolaCatalogo(catalogoGui.getTipoAttivo(), catalogoGui.getCatalogoPanel());
			carrello = new ArrayList<Prodotto>();
			catalogoGui.setVisible(true);
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

	public void popolaCatalogo(String tipoProdotto, JPanel catalogoPanel) {
		catalogoPanel.removeAll();
		int size = 0;
		prodotti = prodottoDao.getProdottiAttivi(tipoProdotto);
		for(int i = 0 ; i < prodotti.size(); i++) {
			if(i%2 == 0) size += 170;
			try {
				catalogoGui.catalogoPanel.add(new ProdottoPanel(prodotti.get(i).getNome(), prodotti.get(i).getUrl(), this));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catalogoPanel.revalidate();
		catalogoPanel.repaint();
		catalogoPanel.setPreferredSize(new Dimension(518,size));
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

	public void prodottoSelezionato(String nomeProdotto) {
		ArrayList<Prodotto> dimensioniProdottoSelezionato = prodottoDao.getProdotto(nomeProdotto);
		dettagliOrdineProdottoGui = new DettagliOrdineProdottoGUI(dimensioniProdottoSelezionato, this);
		dettagliOrdineProdottoGui.setVisible(true);
	}

	public void prodottoAggiunto(Prodotto prodottoCarrello) {
		carrello.add(prodottoCarrello);
		System.out.println("Prodotto Aggiunto Al Carrello");
		//chiudi
	}

	public void mostraProfilo() {
		catalogoGui.setVisible(false);
		profiloGui = new ProfiloGUI(utenteAttivo,this);
		profiloGui.setVisible(true);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	

