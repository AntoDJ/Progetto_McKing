package AdminCatena;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.Controller;
import Entità.Admin;
import Utility.BigFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aggiungi_GestioneRistoranteGUI extends BigFrame {
	private Controller controller;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField emailTextField;
	private JTextField passwordTextField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(585, 87, 294, 34);
		getBodyPanel().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("es. Via Roma, 7");
		textField_3.setColumns(10);
		textField_3.setBounds(585, 160, 294, 34);
		getBodyPanel().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(585, 243, 294, 34);
		getBodyPanel().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(585, 324, 294, 34);
		getBodyPanel().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(585, 410, 294, 34);
		getBodyPanel().add(textField_6);
		
		JButton creaAdminButton = new JButton("Crea Admin ");
		creaAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome;
				String cognome;
				String email;
				String password;
				Admin admin;
				
				nome = nomeTextField.getText();
				cognome = cognomeTextField.getText();
				email = emailTextField.getText();
				password = passwordTextField.getText();
				admin = new Admin(false, cognome, nome, email, true, 0);
				System.out.println(admin);
				
				nomeTextField.setText(null);
				cognomeTextField.setText(null);
				emailTextField.setText(null);
				passwordTextField.setText(null);				
				
				//CHIAMARE METODO CONTROLLER

				
				
				
				
				
			}
		});
		creaAdminButton.setBackground(Color.WHITE);
		creaAdminButton.setFont(new Font("Bell MT", Font.BOLD, 14));
		creaAdminButton.setFocusPainted(false);
		creaAdminButton.setFocusTraversalKeysEnabled(false);
		creaAdminButton.setFocusable(false);
		creaAdminButton.setBounds(150, 498, 202, 22);
		getBodyPanel().add(creaAdminButton);
		
		JButton creaRistoranteButton = new JButton("Crea ristorante");
		creaRistoranteButton.setBackground(Color.WHITE);
		creaRistoranteButton.setFont(new Font("Bell MT", Font.BOLD, 14));
		creaRistoranteButton.setFocusPainted(false);
		creaRistoranteButton.setFocusTraversalKeysEnabled(false);
		creaRistoranteButton.setFocusable(false);
		creaRistoranteButton.setBounds(631, 498, 202, 22);
		getBodyPanel().add(creaRistoranteButton);
		
	}
}
