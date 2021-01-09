package Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.SmallFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Aggiungi_GestioneRiderGUI extends SmallFrame {
	private JTextField cognomeTextField;
	private JTextField nomeTextField;
	private JTextField numeroDiTelefonoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aggiungi_GestioneRiderGUI frame = new Aggiungi_GestioneRiderGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aggiungi_GestioneRiderGUI() {
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
		cognomeTextField.setBounds(222, 49, 206, 25);
		getBodyPanel().add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(222, 94, 206, 25);
		getBodyPanel().add(nomeTextField);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(222, 139, 206, 25);
		getBodyPanel().add(numeroDiTelefonoTextField);
		
		//Abbiamo supposto che non possano essere inseriti altri mezzi di trasporto		
		String [] mezziDiTrasporto= {"          - - - Seleziona - - -   ", "Bicicletta", "Moto", "Auto"};
		JComboBox tipoMezzoComboBox = new JComboBox(mezziDiTrasporto);
		tipoMezzoComboBox.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox.setFocusable(false);
		tipoMezzoComboBox.setBounds(222, 186, 206, 25);
		tipoMezzoComboBox.setBackground(Color.white);
		tipoMezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		getBodyPanel().add(tipoMezzoComboBox);

	}
}
