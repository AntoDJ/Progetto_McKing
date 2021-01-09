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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Aggiungi_GestioneRiderGUI extends MediumFrame {
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
		
		JLabel fotoLabel = new JLabel("Foto");
		fotoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		fotoLabel.setBounds(10, 229, 192, 35);
		panel.add(fotoLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		cognomeTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cognomeTextField.setBounds(287, 50, 260, 25);
		getBodyPanel().add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		nomeTextField = new JTextField();
		nomeTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(287, 95, 260, 25);
		getBodyPanel().add(nomeTextField);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(287, 140, 260, 25);
		getBodyPanel().add(numeroDiTelefonoTextField);
		
		//Abbiamo supposto che non possano essere inseriti altri mezzi di trasporto		
		String [] mezziDiTrasporto= {"          - - - Seleziona - - -   ", "Bicicletta", "Moto", "Auto"};
		JComboBox tipoMezzoComboBox = new JComboBox(mezziDiTrasporto);
		tipoMezzoComboBox.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox.setFocusable(false);
		tipoMezzoComboBox.setBounds(287, 187, 260, 25);
		tipoMezzoComboBox.setBackground(Color.white);
		tipoMezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		getBodyPanel().add(tipoMezzoComboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(287, 245, 140, 140);
		getBodyPanel().add(lblNewLabel);
		
		JButton button = new JButton("New button");
		button.setBounds(580, 363, 8, -18);
		getBodyPanel().add(button);
		
		MenuButton btnNewButton = new MenuButton("Avanti");
		btnNewButton.setBounds(568, 370, 97, 21);
		getBodyPanel().add(btnNewButton);
		
		JLabel sfogliaLabel = new JLabel("");
		sfogliaLabel.setBackground(new Color(255, 255, 255));
		sfogliaLabel.setOpaque(true);
		sfogliaLabel.setIcon(new ImageIcon(Aggiungi_GestioneRiderGUI.class.getResource("/GUI/icons/cerca.png")));
		sfogliaLabel.setBounds(437, 245, 24, 25);
		getBodyPanel().add(sfogliaLabel);
		
		JLabel sfogliaLabel2 = new JLabel("Sfoglia");
		sfogliaLabel2.setFont(new Font("Bell MT", Font.PLAIN, 14));
		sfogliaLabel2.setBounds(471, 245, 68, 25);
		getBodyPanel().add(sfogliaLabel2);

	}
}
