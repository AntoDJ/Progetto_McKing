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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Admin.Aggiungi_GestioneRiderGUI;
import Admin.Cancella_GestioneRiderGUI;
import Admin.GestioneRiderGUI;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Admin.OperazioneRistoranteGUI;
import Admin.VisualizzaStoricoGUI;
import AdminCatena.Aggiungi_GestioneCatalogoGUI;
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
import Utility.StoricoPanel;
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
	private VisualizzaStoricoGUI visualizzaStoricoGui;
	private Cancella_GestioneRiderGUI cancella_gestioneRiderGui;
	private Aggiungi_GestioneRiderGUI aggiungi_gestioneRiderGui;
	

	
	
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

	
	public void apriGestisciRider() {
		try {
			gestioneRiderGui = new GestioneRiderGUI(this);
			popolaRider();
			operazioneRistoranteGui.setVisible(false);		
			gestioneRiderGui.setVisible(true);	
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
	
	public void indietroGrstisciRider() {
		gestioneRiderGui.dispose();
		operazioneRistoranteGui.setVisible(true);				
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
	
	public void riempiOrdiniDaAssegnare(int IdRistorante) {
		ArrayList<Rider> rider = null;
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		int size = 0;
		ordini = ordineDao.getOrdiniDaAssegnare(IdRistorante);
		try {
			rider = riderDao.getRider(adminAttivo);
		} catch (SQLException e1) {
			System.out.println("Nessun Rider Disponibile");
		}
		for (int i = 0; i< ordini.size(); i++) {
			size += 115;
			operazioneRistoranteGui.ordiniDaAssegnarePanel.add(new OrdineDaAssegnarePanel(ordini.get(i), rider, this));
			operazioneRistoranteGui.add(Box.createVerticalStrut(10));
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
	
	
	public void popolaStoricoOrdini(int idRistorante, String anno, String tipoMezzo, double prezzo) {
		ArrayList<Ordine> ordini = null;
		int size = 0;
		ordini = ordineDao.getStoricoRistorante(adminAttivo.getIdRistorante(), anno, tipoMezzo, prezzo);		
		for (int i = 0; i< ordini.size(); i++) {
			size += 115;
			visualizzaStoricoGui.ordinePanel.add(new StoricoPanel(ordini.get(i)));
			visualizzaStoricoGui.ordinePanel.add(Box.createVerticalStrut(10));
		}
		visualizzaStoricoGui.ordinePanel.setPreferredSize(new Dimension(100,size));
	}
	
	public void apriStorico(){
		visualizzaStoricoGui = new VisualizzaStoricoGUI(this, adminAttivo);
		popolaStoricoOrdini(adminAttivo.getIdRistorante(), null, null, 0);
		operazioneRistoranteGui.setVisible(false);
		visualizzaStoricoGui.setVisible(true);
	}

	
	public void indietroStorico() {
		visualizzaStoricoGui.dispose();
		operazioneRistoranteGui.setVisible(true);		
	}
	
	public void ricercaPersonalizzata(int idRistorante, String anno, String tipoMezzo, double prezzo){
		visualizzaStoricoGui = new VisualizzaStoricoGUI(this, adminAttivo);	
		popolaStoricoOrdini(adminAttivo.getIdRistorante(), anno, tipoMezzo, prezzo);		
		chiudiVisibilitaComponentiVisualizzaStoricoGui();		
		visualizzaStoricoGui.setVisible(true);
	}
	
	public void chiudiVisibilitaComponentiVisualizzaStoricoGui() {
		visualizzaStoricoGui.indietroLabel.setVisible(true);
		visualizzaStoricoGui.getBackButton().setVisible(false);
		visualizzaStoricoGui.annoLabel.setVisible(false);
		visualizzaStoricoGui.annoComboBox.setVisible(false);
		visualizzaStoricoGui.tipoMezzoComboBox.setVisible(false);
		visualizzaStoricoGui.tipoMezzoLabel.setVisible(false);
		visualizzaStoricoGui.prezzoComboBox.setVisible(false);
		visualizzaStoricoGui.prezzoLabel.setVisible(false);
		visualizzaStoricoGui.cercaLabel.setVisible(false);
		visualizzaStoricoGui.maggioreDiLabel.setVisible(false);
	}
	
	public void apriEliminazioneRider() throws SQLException {
		ArrayList<Rider> rider;			
			
		rider = riderDao.getAllRiderDisponibili(adminAttivo);
		cancella_gestioneRiderGui = new Cancella_GestioneRiderGUI(this, rider);	
		gestioneRiderGui.setVisible(false);
		cancella_gestioneRiderGui.setVisible(true);
		cancella_gestioneRiderGui.risultatoEliminazioneLabel.setVisible(false);
	}
	
	
	public void indietroEliminaRider() {
		cancella_gestioneRiderGui.dispose();
		gestioneRiderGui.setVisible(true);				
	}
	
	public void eliminaRider(Rider r) throws SQLException {
		int flag;
		ArrayList<Rider> rider;			
		flag = riderDao.elimiaRider(r);
		if(flag == 0) {			
			cancella_gestioneRiderGui.riderDaEliminareComboBox.setVisible(false);
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setText("Non è stato possibile eliminare il rider");
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setVisible(true);
			cancella_gestioneRiderGui.eliminaButton.setVisible(false);
			}
		else if (flag == 1){
			
			cancella_gestioneRiderGui.riderDaEliminareComboBox.setVisible(false);
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setText("Il rider è stato cancellato correttamente");
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setVisible(true);
			cancella_gestioneRiderGui.eliminaButton.setVisible(false);
		}
		else {
			cancella_gestioneRiderGui.riderDaEliminareComboBox.setVisible(false);
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setText("Errore!!");
			cancella_gestioneRiderGui.risultatoEliminazioneLabel.setVisible(true);
			cancella_gestioneRiderGui.eliminaButton.setVisible(false);
		}
	}
	
	
	public void apriInserisciRider() {
		aggiungi_gestioneRiderGui = new Aggiungi_GestioneRiderGUI(this);
		gestioneRiderGui.setVisible(false);
		aggiungi_gestioneRiderGui.setVisible(true);
	}
	
	public void indietroInserisciRider() {
		aggiungi_gestioneRiderGui.dispose();
		gestioneRiderGui.setVisible(true);		
	}
	
	public void inserisciRider(String cognome,String nome, String numeroDiTelefono, String tipoMezzo) {
		String mezzoDiTrasporto;
		int ritorno;
		mezzoDiTrasporto = verificaValore(tipoMezzo);		
		if(cognome != null && nome != null && numeroDiTelefono != null && mezzoDiTrasporto != null) {
			Rider r = new Rider(0, cognome, nome, numeroDiTelefono, mezzoDiTrasporto, true, adminAttivo.getIdRistorante());
			ritorno = riderDao.inserisciRider(r);
			if(ritorno == 0)
				aggiungi_gestioneRiderGui.risultatoLabel.setText("Non è stato possibile inserire il rider");
			else if (ritorno == 1)
				aggiungi_gestioneRiderGui.risultatoLabel.setText("Il nuovo rider è stato inserito correttamente");
			else	aggiungi_gestioneRiderGui.risultatoLabel.setText("Errore!!");
		}
	}
	
	
	// VERIFICO SE IL VALORE PRESO DALLA COMBOBOX E' UGUALE A "  -- SELEZIONA -- " O MENO	
	public String verificaValore (String valore) {
		if (valore.equals("  --Seleziona--"))
			return null;
		else return valore;
	}
	
}
	
	

