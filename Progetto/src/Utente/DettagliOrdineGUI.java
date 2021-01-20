package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Utility.MenuButton;
import Utility.MediumFrame;
import java.awt.Color;
import javax.swing.SwingConstants;

import Controller.Controller;
import Entità.Ordine;
import Entità.Ristorante;
import Entità.Utente;

import javax.swing.JButton;

public class DettagliOrdineGUI extends MediumFrame {
	private JTextField indirizzoTextField;
	private JTextField cartaDiCreditoTextField;
	private JTextField numeroDiTelefonoTextField;
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DettagliOrdineGUI frame = new DettagliOrdineGUI();
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
	public DettagliOrdineGUI(Controller controller, Utente utenteAttivo, double prezzoTotale) {
		this.controller = controller;
		getBackButton().setVisible(false);
		getBodyPanel().setBackground(new Color(255, 255, 153));
		getBodyPanel().setBounds(0, 44, 675, 406);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBackground(new Color(240, 240, 240));
		etichettePanel.setBounds(0, 0, 180, 406);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel selezionaRistoranteLabel = new JLabel("Seleziona ristorante:");
		selezionaRistoranteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		selezionaRistoranteLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		selezionaRistoranteLabel.setBounds(0, 79, 170, 31);
		etichettePanel.add(selezionaRistoranteLabel);
		
		JLabel selezionaIndirizzoLabel = new JLabel("Indirizzo:");
		selezionaIndirizzoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		selezionaIndirizzoLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		selezionaIndirizzoLabel.setBounds(0, 127, 169, 31);
		etichettePanel.add(selezionaIndirizzoLabel);
		
		JLabel selezionaCartaLabel = new JLabel("Carta di credito:");
		selezionaCartaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		selezionaCartaLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		selezionaCartaLabel.setBounds(0, 172, 169, 31);
		etichettePanel.add(selezionaCartaLabel);
		
		JLabel selezionaOrarioLabel_1 = new JLabel("Seleziona orario:");
		selezionaOrarioLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		selezionaOrarioLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		selezionaOrarioLabel_1.setBounds(10, 218, 160, 31);
		etichettePanel.add(selezionaOrarioLabel_1);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di telefono:");
		numeroDiTelefonoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroDiTelefonoLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		numeroDiTelefonoLabel.setBounds(10, 258, 160, 31);
		etichettePanel.add(numeroDiTelefonoLabel);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo Totale:");
		prezzoTotaleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		prezzoTotaleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		prezzoTotaleLabel.setBounds(1, 30, 169, 31);
		etichettePanel.add(prezzoTotaleLabel);
		
		JComboBox selezionaRistorantecomboBox = new JComboBox();
		controller.riempiComboBoxRistorante(selezionaRistorantecomboBox);
		selezionaRistorantecomboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistorantecomboBox.setFocusable(false);
		selezionaRistorantecomboBox.setBackground(Color.white);
		selezionaRistorantecomboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaRistorantecomboBox.setBounds(249, 88, 240, 21);
		getBodyPanel().add(selezionaRistorantecomboBox);
		
		indirizzoTextField = new JTextField(utenteAttivo.getIndirizzo());
		if(!indirizzoTextField.getText().isEmpty()) indirizzoTextField.setEditable(false);;
		indirizzoTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		indirizzoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		indirizzoTextField.setBounds(249, 132, 240, 21);
		getBodyPanel().add(indirizzoTextField);
		indirizzoTextField.setColumns(10);
		
		cartaDiCreditoTextField = new JTextField(utenteAttivo.getCartaDiCredito());
		if(!cartaDiCreditoTextField.getText().isEmpty()) cartaDiCreditoTextField.setEditable(false);
		cartaDiCreditoTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		cartaDiCreditoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cartaDiCreditoTextField.setColumns(10);
		cartaDiCreditoTextField.setBounds(249, 177, 240, 21);
		getBodyPanel().add(cartaDiCreditoTextField);
		
		String [] orariConsegna = {"19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15",
				"21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"};
		JComboBox selezionaOrarioComboBox = new JComboBox(orariConsegna);
		selezionaOrarioComboBox.setSelectedIndex(1);
		selezionaOrarioComboBox.setFocusTraversalKeysEnabled(false);
		selezionaOrarioComboBox.setFocusable(false);
		selezionaOrarioComboBox.setBackground(Color.white);
		selezionaOrarioComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaOrarioComboBox.setBounds(249, 222, 240, 21);
		getBodyPanel().add(selezionaOrarioComboBox);
		
		MenuButton avantiButton = new MenuButton("Avanti");
		avantiButton.setBounds(532, 333, 110, 40);
		getBodyPanel().add(avantiButton);
		
		numeroDiTelefonoTextField = new JTextField(utenteAttivo.getNumeroDiTelefono());
		if(!numeroDiTelefonoTextField.getText().isEmpty()) numeroDiTelefonoTextField.setEditable(false);
		numeroDiTelefonoTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(249, 263, 240, 21);
		getBodyPanel().add(numeroDiTelefonoTextField);
		
		JLabel istruzioniLabel = new JLabel("* Tutti i campi sono obbligatori");
		istruzioniLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		istruzioniLabel.setBounds(249, 295, 311, 14);
		getBodyPanel().add(istruzioniLabel);
		
		MenuButton carrelloButton = new MenuButton("Carrello");
		carrelloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaAlCarrello();
			}
		});
		carrelloButton.setBounds(249, 333, 110, 40);
		getBodyPanel().add(carrelloButton);
		
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
							numeroDiTelefonoTextField.setText(utenteAttivo.getNumeroDiTelefono());
						}
					}
				}
			}
		});
		modificaTelefonoButton.setBounds(532, 263, 110, 25);
		getBodyPanel().add(modificaTelefonoButton);
		
		MenuButton modificaCartaDiCreditoButton = new MenuButton("Modifica");
		modificaCartaDiCreditoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!modificaCartaDiCreditoButton.isPressed()) {
					modificaCartaDiCreditoButton.setPressed(true);
					cartaDiCreditoTextField.setEditable(true);
					modificaCartaDiCreditoButton.setText("Salva");
				}
				else {
					modificaCartaDiCreditoButton.setPressed(false);
					cartaDiCreditoTextField.setEditable(false);
					modificaCartaDiCreditoButton.setText("Modifica");
					if(!cartaDiCreditoTextField.getText().equals(utenteAttivo.getNumeroDiTelefono())) {
						try {
							controller.modificaCartaDiCredito(cartaDiCreditoTextField.getText());
						} catch(SQLException err){
							JDialog errorDialog = new JDialog();
							errorDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							JOptionPane.showMessageDialog(errorDialog, "Carta di credito non valida");
							cartaDiCreditoTextField.setText(utenteAttivo.getCartaDiCredito());
						}
					}
				}
			}
		});
		modificaCartaDiCreditoButton.setBounds(532, 177, 110, 25);
		getBodyPanel().add(modificaCartaDiCreditoButton);
		
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
							JOptionPane.showMessageDialog(errorDialog, "Indirizzo non valido");
							indirizzoTextField.setText(utenteAttivo.getIndirizzo());
						}
					}
				}
			}
		});
		modificaIndirizzo.setBounds(532, 128, 110, 25);
		getBodyPanel().add(modificaIndirizzo);
		
		JLabel prezzoLabel = new JLabel(String.valueOf(prezzoTotale) + "€");
		prezzoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		prezzoLabel.setBounds(249, 32, 169, 31);
		getBodyPanel().add(prezzoLabel);

		avantiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selezionaOrarioComboBox.getSelectedItem().toString().isEmpty() || selezionaRistorantecomboBox.getSelectedItem().toString().isEmpty() || cartaDiCreditoTextField.getText().isEmpty() || indirizzoTextField.getText().isEmpty() || numeroDiTelefonoTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(avantiButton, "Riempire tutti i campi");
				}
				else {
					SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
					try {
						Ordine nuovoOrdine = new Ordine(new Time(formatter.parse(selezionaOrarioComboBox.getSelectedItem().toString()).getTime()), utenteAttivo.getIndirizzo(), prezzoTotale, utenteAttivo, (Ristorante)selezionaRistorantecomboBox.getSelectedItem());
						controller.completaOrdine(nuovoOrdine);
					} catch (ParseException e1) {
						System.out.println("Problemi con il parsing dell'orario");
						e1.printStackTrace();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(avantiButton, "Inserire valori validi in tutti i campi");
						e2.printStackTrace();
					}
					

			
				}
			}
		});
	}
}
