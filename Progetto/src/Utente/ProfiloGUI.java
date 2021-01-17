package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfiloGUI extends SmallFrame {
	private JTextField numeroDiTelefonoTextField;
	private JTextField indirizzoTextField;
	private JTextField cartaDiCreditoTextField;
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
		etichettePanel.setBounds(0, 0, 152, 256);
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
		numeroDiTelefonoLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		numeroDiTelefonoLabel.setBounds(10, 137, 136, 19);
		etichettePanel.add(numeroDiTelefonoLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo");
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		indirizzoLabel.setBounds(10, 167, 93, 19);
		etichettePanel.add(indirizzoLabel);
		
		JLabel cartaDiCreditoLabel = new JLabel("Carta di credito");
		cartaDiCreditoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cartaDiCreditoLabel.setBounds(10, 208, 129, 19);
		etichettePanel.add(cartaDiCreditoLabel);
		
		JPanel dettagliPanel = new JPanel();
		dettagliPanel.setBackground(new Color(255, 255, 153));
		dettagliPanel.setBounds(150, 0, 300, 256);
		getBodyPanel().add(dettagliPanel);
		dettagliPanel.setLayout(null);
		
		JLabel contenitoreNomeLabel = new JLabel(utenteAttivo.getNome());
		contenitoreNomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreNomeLabel.setBounds(10, 38, 283, 19);
		dettagliPanel.add(contenitoreNomeLabel);
		
		JLabel contenitoreCognomeLabel = new JLabel(utenteAttivo.getCognome());
		contenitoreCognomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreCognomeLabel.setBounds(10, 64, 283, 19);
		dettagliPanel.add(contenitoreCognomeLabel);
		
		JLabel contenitoreEmailLabel = new JLabel(utenteAttivo.getEmail());
		contenitoreEmailLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		contenitoreEmailLabel.setBounds(10, 92, 283, 19);
		dettagliPanel.add(contenitoreEmailLabel);
		
		numeroDiTelefonoTextField = new JTextField("");
		numeroDiTelefonoTextField.setEditable(false);
		if(utenteAttivo.getNumeroDiTelefono() != null) numeroDiTelefonoTextField.setText(utenteAttivo.getNumeroDiTelefono());
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.ITALIC, 16));
		numeroDiTelefonoTextField.setToolTipText("Esempio Numero di telefono: 3658965845");
		numeroDiTelefonoTextField.setBounds(10, 137, 173, 22);
		dettagliPanel.add(numeroDiTelefonoTextField);
		numeroDiTelefonoTextField.setColumns(10);
		
		indirizzoTextField = new JTextField("");
		indirizzoTextField.setEditable(false);
		if(utenteAttivo.getIndirizzo() != null) indirizzoTextField.setText(utenteAttivo.getIndirizzo());
		indirizzoTextField.setToolTipText("Esempio Indirizzo: Via Roma, 7");
		indirizzoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		indirizzoTextField.setColumns(10);
		indirizzoTextField.setBounds(10, 170, 173, 22);
		dettagliPanel.add(indirizzoTextField);
		
		cartaDiCreditoTextField = new JTextField("");
		cartaDiCreditoTextField.setEditable(false);
		if(utenteAttivo.getCartaDiCredito() != null) cartaDiCreditoTextField.setText(utenteAttivo.getCartaDiCredito());
		cartaDiCreditoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		cartaDiCreditoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cartaDiCreditoTextField.setColumns(10);
		cartaDiCreditoTextField.setBounds(10, 209, 173, 19);
		dettagliPanel.add(cartaDiCreditoTextField);
		
		MenuButton modificaTelefonoButton = new MenuButton("Modifica");
		modificaTelefonoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!modificaTelefonoButton.isPressed()) {
					modificaTelefonoButton.setPressed(true);
					numeroDiTelefonoTextField.setEditable(true);
					modificaTelefonoButton.setText("Salva");
				}
				else {
					modificaTelefonoButton.setPressed(false);
					numeroDiTelefonoTextField.setEditable(false);
					modificaTelefonoButton.setText("Modifica");
					if(!numeroDiTelefonoTextField.getText().equals(utenteAttivo.getNumeroDiTelefono())) {
						try {
							controller.modificaNumeroDiTelefono(numeroDiTelefonoTextField.getText());
						} catch(SQLException err){
							JDialog errorDialog = new JDialog();
							errorDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							JOptionPane.showMessageDialog(errorDialog, "Numero inserito non valido");
						}
					}
				}
			}
		});
		modificaTelefonoButton.setBounds(193, 138, 92, 21);
		dettagliPanel.add(modificaTelefonoButton);
		
		MenuButton modificaIndirizzo = new MenuButton("Modifica");
		modificaIndirizzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!modificaIndirizzo.isPressed()) {
					modificaIndirizzo.setPressed(true);
					indirizzoTextField.setEditable(true);
					modificaIndirizzo.setText("Salva");
				}
				else {
					modificaIndirizzo.setPressed(false);
					indirizzoTextField.setEditable(false);
					modificaIndirizzo.setText("Modifica");
					if(!indirizzoTextField.getText().equals(utenteAttivo.getNumeroDiTelefono())) {
						try {
							controller.modificaIndirizzo(indirizzoTextField.getText());
						} catch(SQLException err){
							JDialog errorDialog = new JDialog();
							errorDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							JOptionPane.showMessageDialog(errorDialog, "Numero inserito non valido");
						}
					}
				}
			}
		});
		modificaIndirizzo.setBounds(193, 171, 92, 21);
		dettagliPanel.add(modificaIndirizzo);
		
		MenuButton modificaCartaDiCredito = new MenuButton("Modifica");
		modificaCartaDiCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!modificaCartaDiCredito.isPressed()) {
					modificaCartaDiCredito.setPressed(true);
					cartaDiCreditoTextField.setEditable(true);
					modificaCartaDiCredito.setText("Salva");
				}
				else {
					modificaCartaDiCredito.setPressed(false);
					cartaDiCreditoTextField.setEditable(false);
					modificaCartaDiCredito.setText("Modifica");
					if(!cartaDiCreditoTextField.getText().equals(utenteAttivo.getNumeroDiTelefono())) {
						try {
							controller.modificaCartaDiCredito(cartaDiCreditoTextField.getText());
						} catch(SQLException err){
							JDialog errorDialog = new JDialog();
							errorDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							JOptionPane.showMessageDialog(errorDialog, "Numero inserito non valido");
						}
					}
				}
			}
		});
		modificaCartaDiCredito.setBounds(193, 208, 92, 21);
		dettagliPanel.add(modificaCartaDiCredito);

	}
}