package AdminCatena;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MediumFrame;
import Utility.MenuButton;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Aggiungi_GestioneCatalogoGUI extends MediumFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aggiungi_GestioneCatalogoGUI frame = new Aggiungi_GestioneCatalogoGUI();
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
	public Aggiungi_GestioneCatalogoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 180, 410);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JLabel completaICampiLabel = new JLabel("Completa i campi");
		completaICampiLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		completaICampiLabel.setBounds(10, 10, 160, 37);
		panel.add(completaICampiLabel);
		
		JLabel tipoProdottoLabel = new JLabel("Tipo prodotto:");
		tipoProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		tipoProdottoLabel.setBounds(10, 60, 160, 37);
		panel.add(tipoProdottoLabel);
		
		JLabel nomeProdottoLabel = new JLabel("Nome prodotto:");
		nomeProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		nomeProdottoLabel.setBounds(10, 105, 160, 37);
		panel.add(nomeProdottoLabel);
		
		JLabel dimensioneLabel = new JLabel("Dimensione:");
		dimensioneLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dimensioneLabel.setBounds(10, 151, 160, 37);
		panel.add(dimensioneLabel);
		
		JLabel prezzoLabel = new JLabel("Prezzo:");
		prezzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prezzoLabel.setBounds(10, 198, 160, 37);
		panel.add(prezzoLabel);
		
		JLabel ImmagineLabel = new JLabel("Immagine");
		ImmagineLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ImmagineLabel.setBounds(10, 245, 160, 37);
		panel.add(ImmagineLabel);
		
		JComboBox tipoProdottoComboBox = new JComboBox();
		tipoProdottoComboBox.setFocusTraversalKeysEnabled(false);
		tipoProdottoComboBox.setFocusable(false);
		tipoProdottoComboBox.setBounds(271, 65, 330, 21);
		tipoProdottoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		tipoProdottoComboBox.setBackground(Color.WHITE);
		getBodyPanel().add(tipoProdottoComboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		textField.setBounds(271, 110, 330, 25);
		getBodyPanel().add(textField);
		textField.setColumns(10);
		
		JRadioButton smallRadioButton = new JRadioButton("Small");
		smallRadioButton.setFocusable(false);
		smallRadioButton.setFocusPainted(false);
		smallRadioButton.setBackground(new Color(255, 255, 153));
		smallRadioButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		smallRadioButton.setBounds(210, 162, 103, 21);
		getBodyPanel().add(smallRadioButton);
		
		JRadioButton mediumRadioButton = new JRadioButton("Medium");
		mediumRadioButton.setFocusable(false);
		mediumRadioButton.setFocusPainted(false);
		mediumRadioButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		mediumRadioButton.setBackground(new Color(255, 255, 153));
		mediumRadioButton.setBounds(315, 162, 103, 21);
		getBodyPanel().add(mediumRadioButton);
		
		JRadioButton largeRadioButton_1 = new JRadioButton("Large");
		largeRadioButton_1.setFocusable(false);
		largeRadioButton_1.setFocusPainted(false);
		largeRadioButton_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		largeRadioButton_1.setBackground(new Color(255, 255, 153));
		largeRadioButton_1.setBounds(420, 162, 103, 21);
		getBodyPanel().add(largeRadioButton_1);
		
		JRadioButton McKINGRadioButton_1 = new JRadioButton("McKing");
		McKINGRadioButton_1.setFocusable(false);
		McKINGRadioButton_1.setFocusPainted(false);
		McKINGRadioButton_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		McKINGRadioButton_1.setBackground(new Color(255, 255, 153));
		McKINGRadioButton_1.setBounds(525, 162, 103, 21);
		getBodyPanel().add(McKINGRadioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(339, 210, 136, 25);
		getBodyPanel().add(textField_1);
		
		JLabel euroLabel = new JLabel("\u20AC");
		euroLabel.setForeground(new Color(0, 0, 0));
		euroLabel.setHorizontalAlignment(SwingConstants.LEFT);
		euroLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		euroLabel.setBounds(485, 210, 37, 21);
		getBodyPanel().add(euroLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(339, 250, 128, 128);
		getBodyPanel().add(lblNewLabel);
		
		JLabel sfogliaLabel = new JLabel("");
		sfogliaLabel.setBorder(new LineBorder(new Color(0, 0, 0)));		
		sfogliaLabel.setOpaque(true);
		sfogliaLabel.setBackground(new Color(255, 255, 255));
		sfogliaLabel.setIcon(new ImageIcon(Aggiungi_GestioneCatalogoGUI.class.getResource("/GUI/icons/cerca.png")));
		sfogliaLabel.setBounds(485, 255, 24, 25);
		getBodyPanel().add(sfogliaLabel);
		
		MenuButton btnNewButton = new MenuButton("Conferma");
		btnNewButton.setBounds(557, 370, 103, 21);
		getBodyPanel().add(btnNewButton);
		
		JLabel sfogliaLabel2 = new JLabel("Sfoglia");
		sfogliaLabel2.setFont(new Font("Bell MT", Font.PLAIN, 14));
		sfogliaLabel2.setBounds(518, 256, 71, 21);
		getBodyPanel().add(sfogliaLabel2);

	}
}
