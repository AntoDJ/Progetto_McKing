package Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MediumFrame;
import Utility.MenuButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Controller.Controller;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aggiungi_GestioneRiderGUI extends MediumFrame {
	Controller controller;
	private JTextField cognomeTextField;
	private JTextField nomeTextField;
	private JTextField numeroDiTelefonoTextField;
	public JLabel risultatoLabel;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Aggiungi_GestioneRiderGUI frame = new Aggiungi_GestioneRiderGUI();
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
	public Aggiungi_GestioneRiderGUI(Controller controller) {
		getBodyPanel().setBounds(0, 44, 675, 410);
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.indietroInserisciRider();
			}
		});
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		getBodyPanel().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 212, 410);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cognomeLabel.setBounds(10, 49, 192, 35);
		panel.add(cognomeLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		nomeLabel.setBounds(10, 94, 192, 35);
		panel.add(nomeLabel);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero Di Telefono:");
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoLabel.setBounds(10, 139, 192, 35);
		panel.add(numeroDiTelefonoLabel);
		
		JLabel tipoMezzoLabel = new JLabel("Tipo mezzo");
		tipoMezzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		tipoMezzoLabel.setBounds(10, 184, 192, 35);
		panel.add(tipoMezzoLabel);
		
		JLabel titoloLabel = new JLabel("Inserisci informazioni:");
		titoloLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		titoloLabel.setBounds(10, 10, 192, 29);
		panel.add(titoloLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cognomeTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cognomeTextField.setBounds(222, 48, 260, 25);
		getBodyPanel().add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		nomeTextField = new JTextField();
		nomeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nomeTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(222, 93, 260, 25);
		getBodyPanel().add(nomeTextField);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(222, 138, 260, 25);
		getBodyPanel().add(numeroDiTelefonoTextField);
		
		//Abbiamo supposto che non possano essere inseriti altri mezzi di trasporto		
		String [] mezziDiTrasporto= {"          - - - Seleziona - - -   ", "Bicicletta", "Moto", "Auto"};
		JComboBox tipoMezzoComboBox = new JComboBox(mezziDiTrasporto);
		tipoMezzoComboBox.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox.setFocusable(false);
		tipoMezzoComboBox.setBounds(222, 185, 260, 25);
		tipoMezzoComboBox.setBackground(Color.white);
		tipoMezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		getBodyPanel().add(tipoMezzoComboBox);
		
		JButton button = new JButton("New button");
		button.setBounds(580, 363, 8, -18);
		getBodyPanel().add(button);
		
		MenuButton btnNewButton = new MenuButton("Avanti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cognome;
				String nome;
				String numeroDiTelefono;
				String tipoMezzo;
				cognome = cognomeTextField.getText();
				nome = nomeTextField.getText();
				numeroDiTelefono = numeroDiTelefonoTextField.getText();
				tipoMezzo = (String) tipoMezzoComboBox.getSelectedItem();
				controller.inserisciRider(cognome, nome,  numeroDiTelefono,  tipoMezzo);				
			}
		});
		btnNewButton.setBounds(565, 370, 97, 21);
		getBodyPanel().add(btnNewButton);
		
		risultatoLabel = new JLabel("");
		risultatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		risultatoLabel.setFont(new Font("Bell MT", Font.PLAIN, 15));
		risultatoLabel.setForeground(Color.RED);
		risultatoLabel.setBounds(222, 287, 443, 58);
		getBodyPanel().add(risultatoLabel);

	}
}
