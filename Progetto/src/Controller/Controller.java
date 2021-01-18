package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.AdminDAO;
import DAO.OrdineDAO;
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
import javax.swing.SwingUtilities;

import Admin.OperazioneRistoranteGUI;
import AdminCatena.OperazioniCatenaGUI;
import Entità.Admin;
import Entità.Ordine;
import Entità.Prodotto;
import Entità.Rider;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;
import General.AccessoGUI;
import General.LoginFormGUI;
import Utente.CatalogoGUI;

import Utility.RiderPanel;
import Utility.Caricamento;
import Utility.ModernScrollPane;
import Utility.OrdineAssegnatoPanel;
import Utility.OrdineDaAssegnarePanel;
import Utility.ProdottoPanel;


public class Controller {
	private UtenteDAO utenteDao;
	private Utente utenteAttivo;
	private AdminDAO adminDao;
	private Admin adminAttivo;
	private String tipoAccesso;
	private ProdottoDAO prodottoDao;
	private RiderDAO riderDao;
	private OrdineDAO ordineDao;
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
		    ordineDao = new OrdineDAO();
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
			popolaCatalogo(catalogoGui.getTipoAttivo(), catalogoGui.getCatalogoPanel());
			catalogoGui.setVisible(true);
		}
		else { 
			adminAttivo= adminDao.verificaAccesso(email, password);
			loginFormGui.setVisible(false);
			if(adminAttivo.isAdminCatena()) {
				operazioniCatenaGui = new OperazioniCatenaGUI(this);
				operazioniCatenaGui.setVisible(true);						
			}
			else { //QUIIIIII
				creaOperazioneRistoranteGUI();
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
				catalogoGui.catalogoPanel.add(new ProdottoPanel(prodotti.get(i).getNome(), prodotti.get(i).getUrl()));
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
	
	
	//PROVA
	public void creaOperazioneRistoranteGUI() {
		operazioneRistoranteGui = new OperazioneRistoranteGUI(this);
		riempiOrdiniAssegnati(adminAttivo.getIdRistorante());
		riempiOrdiniDaAssegnare(adminAttivo.getIdRistorante());
		operazioneRistoranteGui.setVisible(true);
	}
	
	
	
	public void riempiOrdiniAssegnati(int IdRistorante) {
		ArrayList<Ordine> ordini ;
		int size = 0;
		ordini = ordineDao.getOrdiniAssegnati(IdRistorante);
		for (int i = 0; i< ordini.size(); i++) {
			size += 115;
			operazioneRistoranteGui.ordiniAssegnatiPanel.add(new OrdineAssegnatoPanel(ordini.get(i), this));
			operazioneRistoranteGui.add(Box.createVerticalStrut(10));
		}
		  operazioneRistoranteGui.ordiniAssegnatiPanel.setPreferredSize(new Dimension(100,size));
		
	}
	
	public void riempiOrdiniDaAssegnare(int IdRistorante)  {
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		int size = 0;
		ordini = ordineDao.getOrdiniDaAssegnare(IdRistorante);
		for (int i = 0; i< ordini.size(); i++) {
			size += 115;
			try {
				operazioneRistoranteGui.ordiniDaAssegnarePanel.add(new OrdineDaAssegnarePanel(ordini.get(i), riderDao.getRider(adminAttivo), this));
				operazioneRistoranteGui.add(Box.createVerticalStrut(10));
			} catch (SQLException e) {				
				e.printStackTrace();
				System.out.println("Non ci sono rider disponibili");
			}
		}
		  operazioneRistoranteGui.ordiniDaAssegnarePanel.setPreferredSize(new Dimension(100,size));
		
	}
	
	
	public void riderScelto(Ordine ordine) {
		riderDao.aggiungiRider(ordine);
		operazioneRistoranteGui.dispose();
		creaOperazioneRistoranteGUI();
		
		
	}
	
	
	public void cambiaStatoConsegna(Ordine ordine) {
		ordineDao.cambioStatoConsegna(ordine);
		operazioneRistoranteGui.dispose();
		creaOperazioneRistoranteGUI();
		
	}
	
	
}
	
	

