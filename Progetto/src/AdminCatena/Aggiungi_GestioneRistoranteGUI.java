package AdminCatena;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.Controller;
import Entità.Admin;
import Entità.Ristorante;
import Utility.BigFrame;
import Utility.MenuButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class Aggiungi_GestioneRistoranteGUI extends BigFrame {
	private Controller controller;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField emailTextField;
	private JTextField passwordTextField;
	private JTextField cittaTextField;
	private JTextField indirizzoTextField;
	private JTextField numeroDiTelefonoTextField;
	private JTextField orarioAperturaTextField;
	private JTextField orarioChiusuraTextField;
	public MenuButton creaAdminButton;
	public JLabel risultatoAdminLabel;
	public JLabel risultatoRistoranteLabel;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Aggiungi_GestioneRistoranteGUI frame = new Aggiungi_GestioneRistoranteGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Aggiungi_GestioneRistoranteGUI(Controller controller) {
		getBodyPanel().setLocation(0, 44);
		this.controller = controller;
		getBodyPanel().setLayout(null);
		
		JLabel aggiungiAdminLabel = new JLabel("Aggiungi Admin:");
		aggiungiAdminLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		aggiungiAdminLabel.setBounds(10, 10, 422, 44);
		getBodyPanel().add(aggiungiAdminLabel);
		
		JLabel aggiungiRistoranteLabel = new JLabel("Aggiungi ristorante:");
		aggiungiRistoranteLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		aggiungiRistoranteLabel.setBounds(442, 10, 436, 44);
		getBodyPanel().add(aggiungiRistoranteLabel);
		
		JLabel nomeLabel = new JLabel("Nome: ");
		nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeLabel.setBounds(10, 85, 80, 34);
		getBodyPanel().add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome: ");
		cognomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cognomeLabel.setBounds(10, 160, 80, 34);
		getBodyPanel().add(cognomeLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		emailLabel.setBounds(10, 241, 80, 34);
		getBodyPanel().add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		passwordLabel.setBounds(10, 324, 80, 34);
		getBodyPanel().add(passwordLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(100, 87, 294, 34);
		getBodyPanel().add(nomeTextField);
		nomeTextField.setColumns(10);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setColumns(10);
		cognomeTextField.setBounds(100, 160, 294, 34);
		getBodyPanel().add(cognomeTextField);
		
		emailTextField = new JTextField();
		emailTextField.setToolTipText("es. antonio@gmail.com");
		emailTextField.setColumns(10);
		emailTextField.setBounds(100, 243, 294, 34);
		getBodyPanel().add(emailTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setToolTipText("Deve contenere almeno 8 caratteri di cui 1 Maiuscolo,  1 Minuscolo, 1 Numero");
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(100, 324, 294, 34);
		getBodyPanel().add(passwordTextField);
		
		JLabel lblCitt = new JLabel("Citt\u00E0 ");
		lblCitt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCitt.setFont(new Font("Bell MT", Font.BOLD, 16));
		lblCitt.setBounds(442, 85, 133, 34);
		getBodyPanel().add(lblCitt);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIndirizzo.setFont(new Font("Bell MT", Font.BOLD, 16));
		lblIndirizzo.setBounds(442, 160, 133, 34);
		getBodyPanel().add(lblIndirizzo);
		
		JLabel lblNumeroDiTelefono = new JLabel("Numero di telefono:");
		lblNumeroDiTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDiTelefono.setFont(new Font("Bell MT", Font.BOLD, 14));
		lblNumeroDiTelefono.setBounds(442, 241, 133, 34);
		getBodyPanel().add(lblNumeroDiTelefono);
		
		JLabel lblOrarioApertura = new JLabel("Orario apertura:");
		lblOrarioApertura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioApertura.setFont(new Font("Bell MT", Font.BOLD, 16));
		lblOrarioApertura.setBounds(442, 324, 133, 34);
		getBodyPanel().add(lblOrarioApertura);
		
		JLabel lblOrarioChiusura = new JLabel("Orario chiusura:");
		lblOrarioChiusura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioChiusura.setFont(new Font("Bell MT", Font.BOLD, 16));
		lblOrarioChiusura.setBounds(442, 410, 133, 34);
		getBodyPanel().add(lblOrarioChiusura);
		
		cittaTextField = new JTextField();
		cittaTextField.setColumns(10);
		cittaTextField.setBounds(585, 87, 294, 34);
		getBodyPanel().add(cittaTextField);
		
		indirizzoTextField = new JTextField();
		indirizzoTextField.setToolTipText("es. Via Roma, 7");
		indirizzoTextField.setColumns(10);
		indirizzoTextField.setBounds(585, 160, 294, 34);
		getBodyPanel().add(indirizzoTextField);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(585, 243, 294, 34);
		getBodyPanel().add(numeroDiTelefonoTextField);
		
		orarioAperturaTextField = new JTextField();
		orarioAperturaTextField.setToolTipText("formato: hh:mm:ss");
		orarioAperturaTextField.setColumns(10);
		orarioAperturaTextField.setBounds(585, 324, 294, 34);
		getBodyPanel().add(orarioAperturaTextField);
		
		orarioChiusuraTextField = new JTextField();
		orarioChiusuraTextField.setToolTipText("formato: hh:mm:ss");
		orarioChiusuraTextField.setColumns(10);
		orarioChiusuraTextField.setBounds(585, 410, 294, 34);
		getBodyPanel().add(orarioChiusuraTextField);
		
		creaAdminButton = new MenuButton("Crea");
		creaAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome;
				String cognome;
				String email;
				String password;
				String citta;
				String indirizzo;
				String numeroDiTelefono;
				String orarioApertura;
				String orarioChiusura;
				int idAdmin;
				
				Admin admin = null;
				Ristorante ristorante = null;
				
				//Admin
				nome = nomeTextField.getText();
				cognome = cognomeTextField.getText();
				email = emailTextField.getText();
				password = passwordTextField.getText();
				// Ristorante
				int idRistorante = 0;
				citta = cittaTextField.getText();
				indirizzo = indirizzoTextField.getText();
				numeroDiTelefono = numeroDiTelefonoTextField.getText();
				orarioApertura = orarioAperturaTextField.getText();
				orarioChiusura = orarioChiusuraTextField.getText();
				
				if(nome.equals("") || cognome.equals("") || email.equals("") || password.equals("") || citta.equals("") || indirizzo.equals("") || numeroDiTelefono.equals("") || orarioApertura.equals("") || orarioChiusura.equals("")) 
					risultatoAdminLabel.setText("''Bisogna inserire prima tutti i campi''");				
				else {
					admin = new Admin(false, cognome, nome, email,password, true, 0);					
					controller.creaAdminRistorante(admin);
					idAdmin = controller.getAdminDao().getIdAdmin(admin);	
										
					ristorante = new Ristorante(citta, indirizzo, numeroDiTelefono, Time.valueOf(orarioApertura), Time.valueOf(orarioChiusura), idAdmin);
					controller.creaRistorante(ristorante);
					
					idRistorante = controller.getIdRistornate(ristorante);
					controller.modificaIdRistorante(admin, idRistorante);
				}
				
			}
		});
		creaAdminButton.setFont(new Font("Bell MT", Font.BOLD, 16));
		creaAdminButton.setFocusPainted(false);
		creaAdminButton.setFocusTraversalKeysEnabled(false);
		creaAdminButton.setFocusable(false);
		creaAdminButton.setBounds(676, 510, 202, 22);
		getBodyPanel().add(creaAdminButton);
		
		risultatoAdminLabel = new JLabel("");
		risultatoAdminLabel.setBackground(new Color(255, 255, 153));
		risultatoAdminLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
		risultatoAdminLabel.setBounds(316, 472, 290, 22);		
		getBodyPanel().add(risultatoAdminLabel);
		
		JLabel lblNewLabel = new JLabel("N.B. E' necessario riempire tutti i campi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 12));
		lblNewLabel.setBounds(-26, 509, 321, 26);
		getBodyPanel().add(lblNewLabel);
		
		risultatoRistoranteLabel = new JLabel("");
		risultatoRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
		risultatoRistoranteLabel.setBackground(new Color(255, 255, 153));
		risultatoRistoranteLabel.setBounds(316, 495, 290, 22);
		getBodyPanel().add(risultatoRistoranteLabel);
		
	}
}
