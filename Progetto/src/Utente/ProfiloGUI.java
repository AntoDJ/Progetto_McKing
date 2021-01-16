package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.Controller;
import Entità.Utente;
import Utility.MenuButton;
import Utility.SmallFrame;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProfiloGUI extends SmallFrame {
	private JTextField numeroDiTelefonoTextField;
	private JTextField indirizzoTextField;
	private JTextField cartaDiCreditoTextField;
	private JTextField countryCodeTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProfiloGUI frame = new ProfiloGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param controller 
	 * @param utenteAttivo 
	 */
	public ProfiloGUI(Utente utenteAttivo, Controller controller) {
		this.controller = controller;
		getBodyPanel().setLayout(null);
		getBodyPanel().setBackground(new Color(255, 255, 153));
		
		//TODO inserire dati profilo
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBounds(0, 0, 146, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel infoLabel = new JLabel("I tuoi dati:");
		infoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		infoLabel.setBounds(10, 10, 93, 19);
		etichettePanel.add(infoLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeLabel.setBounds(10, 39, 93, 19);
		etichettePanel.add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cognomeLabel.setBounds(10, 68, 93, 19);
		etichettePanel.add(cognomeLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		emailLabel.setBounds(10, 96, 93, 19);
		etichettePanel.add(emailLabel);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di telefono");
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		numeroDiTelefonoLabel.setBounds(10, 125, 136, 19);
		etichettePanel.add(numeroDiTelefonoLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo");
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		indirizzoLabel.setBounds(10, 154, 93, 19);
		etichettePanel.add(indirizzoLabel);
		
		JLabel cartaDiCreditoLabel = new JLabel("Carta di credito");
		cartaDiCreditoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cartaDiCreditoLabel.setBounds(10, 183, 129, 19);
		etichettePanel.add(cartaDiCreditoLabel);
		
		JPanel dettagliPanel = new JPanel();
		dettagliPanel.setBackground(new Color(255, 255, 153));
		dettagliPanel.setBounds(147, 0, 303, 256);
		getBodyPanel().add(dettagliPanel);
		dettagliPanel.setLayout(null);
		
		JLabel contenitoreNomeLabel = new JLabel(utenteAttivo.getNome());
		contenitoreNomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreNomeLabel.setBounds(10, 35, 283, 19);
		dettagliPanel.add(contenitoreNomeLabel);
		
		JLabel contenitoreCognomeLabel = new JLabel(utenteAttivo.getCognome());
		contenitoreCognomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreCognomeLabel.setBounds(10, 60, 283, 19);
		dettagliPanel.add(contenitoreCognomeLabel);
		
		JLabel contenitoreEmailLabel = new JLabel(utenteAttivo.getEmail());
		contenitoreEmailLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreEmailLabel.setBounds(10, 88, 283, 19);
		dettagliPanel.add(contenitoreEmailLabel);
		
		numeroDiTelefonoTextField = new JTextField("");
		if(!utenteAttivo.getNumeroDiTelefono().isBlank()) numeroDiTelefonoLabel.setText(utenteAttivo.getNumeroDiTelefono());
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.ITALIC, 16));
		numeroDiTelefonoTextField.setToolTipText("Esempio Numero di telefono: 3658965845");
		numeroDiTelefonoTextField.setBounds(93, 127, 200, 19);
		dettagliPanel.add(numeroDiTelefonoTextField);
		numeroDiTelefonoTextField.setColumns(10);
		
		indirizzoTextField = new JTextField("");
		if(!utenteAttivo.getIndirizzo().isBlank()) indirizzoLabel.setText(utenteAttivo.getIndirizzo());
		indirizzoTextField.setToolTipText("Esempio Indirizzo: Via Roma, 7");
		indirizzoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		indirizzoTextField.setColumns(10);
		indirizzoTextField.setBounds(10, 156, 283, 19);
		dettagliPanel.add(indirizzoTextField);
		
		cartaDiCreditoTextField = new JTextField("");
		if(!utenteAttivo.getCartaDiCredito().isBlank()) cartaDiCreditoLabel.setText(utenteAttivo.getCartaDiCredito());
		cartaDiCreditoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		cartaDiCreditoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cartaDiCreditoTextField.setColumns(10);
		cartaDiCreditoTextField.setBounds(10, 185, 50, 19);
		dettagliPanel.add(cartaDiCreditoTextField);
		
		MenuButton btnNewButton = new MenuButton("Modifica");
		btnNewButton.setBounds(195, 225, 98, 21);
		dettagliPanel.add(btnNewButton);
		
		countryCodeTextField = new JTextField();
		countryCodeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		countryCodeTextField.setBounds(42, 127, 41, 19);
		dettagliPanel.add(countryCodeTextField);
		countryCodeTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(4, 117, 41, 37);
		dettagliPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(87, 185, 50, 19);
		dettagliPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(164, 185, 50, 19);
		dettagliPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Bell MT", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(241, 185, 50, 19);
		dettagliPanel.add(textField_2);
		
		JLabel trattinoNewLabel = new JLabel("-");
		trattinoNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trattinoNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		trattinoNewLabel.setBounds(52, 185, 45, 12);
		dettagliPanel.add(trattinoNewLabel);
		
		JLabel trattinoNewLabel_1 = new JLabel("-");
		trattinoNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		trattinoNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		trattinoNewLabel_1.setBounds(130, 185, 45, 12);
		dettagliPanel.add(trattinoNewLabel_1);
		
		JLabel trattinoNewLabel_2 = new JLabel("-");
		trattinoNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		trattinoNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		trattinoNewLabel_2.setFont(new Font("Bell MT", Font.PLAIN, 16));
		trattinoNewLabel_2.setBounds(204, 185, 45, 15);
		dettagliPanel.add(trattinoNewLabel_2);

	}
}