package Controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import DAO.RistorantiDAO;
import DAO.UtenteDAO;
import DBConnection.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Admin.GestioneRiderGUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Admin.OperazioneRistoranteGUI;
import AdminCatena.OperazioniCatenaGUI;
import Entità.Admin;
import Entità.Ordine;
import Entità.Prodotto;
import Entità.Rider;
import Entità.Ristorante;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;
import General.AccessoGUI;
import General.LoginFormGUI;
import Utente.CatalogoGUI;
import Utente.DettagliOrdineGUI;
import Utente.DettagliOrdineProdottoGUI;
import Utente.ProfiloGUI;
import Utente.RiepilogoOrdineGUI;
import Utility.RiderPanel;
import Utility.RiepilogoOrdinePanel;
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
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Prodotto> carrello;
	private RistorantiDAO ristoranteDao;
// GUI
	private AccessoGUI accessoGui;
	private LoginFormGUI loginFormGui;
	private CatalogoGUI catalogoGui;
	private ProfiloGUI profiloGui;
	private DettagliOrdineProdottoGUI dettagliOrdineProdottoGui;
	private OperazioneRistoranteGUI operazioneRistoranteGui;
	private OperazioniCatenaGUI operazioniCatenaGui;
	private GestioneRiderGUI gestioneRiderGui;
	private RiepilogoOrdineGUI riepilogoOrdineGui;
	private DettagliOrdineGUI dettagliOrdineGui;

	

	
	
	public Controller(){
		try {
			accessoGui = new AccessoGUI(this);
			accessoGui.setVisible(true);
		    utenteDao = new UtenteDAO();
		    adminDao = new AdminDAO();
		    prodottoDao = new ProdottoDAO();
		    riderDao = new RiderDAO();
		    ordineDao = new OrdineDAO();
		    ristoranteDao = new RistorantiDAO();
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
			loginFormGui.dispose();
			accessoGui.dispose();
			//Preparo la finestra prima di aprirla e creo il carrello dell'utente
			popolaCatalogo(catalogoGui.getTipoAttivo(), catalogoGui.getCatalogoPanel());
			carrello = new ArrayList<Prodotto>();
			catalogoGui.setVisible(true);
		}
		else { 
			adminAttivo= adminDao.verificaAccesso(email, password);
			loginFormGui.dispose();
			accessoGui.dispose();
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

	public void prodottoSelezionato(String nomeProdotto) {
		ArrayList<Prodotto> dimensioniProdottoSelezionato = prodottoDao.getProdotto(nomeProdotto);
		dettagliOrdineProdottoGui = new DettagliOrdineProdottoGUI(dimensioniProdottoSelezionato, this);
		catalogoGui.setEnabled(false);
		dettagliOrdineProdottoGui.setVisible(true);
	}

	public void prodottoAggiunto(Prodotto prodottoCarrello, int quantitaSelezionata) {
		if(carrello.contains(prodottoCarrello)) {
			carrello.get(carrello.indexOf(prodottoCarrello)).setQuantità(carrello.get(carrello.indexOf(prodottoCarrello)).getQuantità() + quantitaSelezionata);
			if(carrello.get(carrello.indexOf(prodottoCarrello)).getQuantità() >= 20) {
				carrello.get(carrello.indexOf(prodottoCarrello)).setQuantità(20);
			}
		}
		else {
			prodottoCarrello.setQuantità(quantitaSelezionata);
			carrello.add(prodottoCarrello);
		}
		System.out.println("Prodotto Aggiunto Al Carrello");
		dettagliOrdineProdottoGui.setVisible(false);
		catalogoGui.setEnabled(true);
		catalogoGui.setVisible(true);
		//chiudi
	}

	public void mostraProfilo() {
		catalogoGui.setVisible(false);
		profiloGui = new ProfiloGUI(utenteAttivo,this);
		profiloGui.setVisible(true);
	}

	public void modificaNumeroDiTelefono(String text) throws SQLException {
		utenteDao.modificaNumero(utenteAttivo.getEmail(), text);
		utenteAttivo.setNumeroDiTelefono(text);
	}

	public void modificaIndirizzo(String text) throws SQLException{
		utenteDao.modificaIndirizzo(utenteAttivo.getEmail(), text);
		utenteAttivo.setIndirizzo(text);
	}
	
	public void modificaCartaDiCredito(String text) throws SQLException{
		utenteDao.modificaCarta(utenteAttivo.getEmail(), text);
		utenteAttivo.setIndirizzo(text);
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

	public void mostraCarrello() {
		catalogoGui.setVisible(false);
		riepilogoOrdineGui = new RiepilogoOrdineGUI(this);
		aggiornaCarrello();
		calcolaPrezzoTotale();
		riepilogoOrdineGui.setVisible(true);
	}
	public void aggiornaCarrello() {
		if(carrello.isEmpty()) {
			JLabel carrelloVuotoLabel = new JLabel("Il Carrello è vuoto");
			carrelloVuotoLabel.setFont(new Font("Bell MT", Font.BOLD, 24));
			carrelloVuotoLabel.setBounds(10, 40, 880, 428);
			carrelloVuotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			carrelloVuotoLabel.setVerticalAlignment(SwingConstants.CENTER);
			
			riepilogoOrdineGui.riepilogoOrdinePanel.add(carrelloVuotoLabel);
		}
		else {
			int size = 0;
			for (int i = 0; i< carrello.size(); i++) {
				size += 203;
				riepilogoOrdineGui.riepilogoOrdinePanel.add(new RiepilogoOrdinePanel(this, carrello.get(i)));
			}
			riepilogoOrdineGui.riepilogoOrdinePanel.setPreferredSize(new Dimension(100,size));
		}
	}

	public ArrayList<Prodotto> getCarrello() {
		return carrello;
	}

	public void rimuoviDalCarrello(RiepilogoOrdinePanel panelDaEliminare, Prodotto prodottoDaEliminare) {
		boolean rim = carrello.remove(prodottoDaEliminare);
		System.out.println( rim == true ? "Rimosso" : "Non Rimosso");
		riepilogoOrdineGui.aggiornaScrollPane();
	}
	
	public void calcolaPrezzoTotale() {
		double prezzoTotale = 0;
		for(Prodotto p: carrello) {
			prezzoTotale += (p.getPrezzo() * p.getQuantità());
		}
		riepilogoOrdineGui.getValorePrezzoTotaleLabel().setText(String.valueOf(prezzoTotale)+ "€");;
	}

	public void annullaNuovoProdotto() {
		dettagliOrdineProdottoGui.dispose();
		catalogoGui.setEnabled(true);
		catalogoGui.setVisible(true);
	}

	public void logoutUtente() {
		catalogoGui.dispose();
		utenteAttivo = null;
		carrello = null;
		prodotti = null;
		accessoGui = new AccessoGUI(this);
	}

	public void tornaAlCatalogoDaProfiloGUI() {
		profiloGui.dispose();
		catalogoGui.setVisible(true);
	}
	
	public void tornaAlCatalogoDaRiepilogoOrdineGUI() {
		riepilogoOrdineGui.dispose();
		catalogoGui.setVisible(true);
	}

	public void inserisciDatiPagamento(Double prezzoTotale) {
		riepilogoOrdineGui.setVisible(false);
		dettagliOrdineGui = new DettagliOrdineGUI(this, utenteAttivo, prezzoTotale);
		dettagliOrdineGui.setVisible(true);
	}

	public void tornaAlCarrello() {
		dettagliOrdineGui.dispose();
		riepilogoOrdineGui.setVisible(true);
	}

	public void completaOrdine(Ordine nuovoOrdine) throws SQLException {
		ordineDao.inserisciOrdine(nuovoOrdine);
		JOptionPane.showMessageDialog(dettagliOrdineGui, "L'ordine è stato effettuato");
		dettagliOrdineGui.dispose();
		carrello.clear();
		catalogoGui.setVisible(true);
		
	}

	public void riempiComboBoxRistorante(JComboBox selezionaRistorantecomboBox) {
		ArrayList<Ristorante> ristorantiDisponibili = ristoranteDao.getRistorantiConsegna();
		for(Ristorante r: ristorantiDisponibili) selezionaRistorantecomboBox.addItem(r);
		selezionaRistorantecomboBox.setSelectedIndex(0);
	}

}
	
	

