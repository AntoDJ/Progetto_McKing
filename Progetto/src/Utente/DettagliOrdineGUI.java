package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Utility.MenuButton;
import Utility.MediumFrame;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DettagliOrdineGUI extends MediumFrame {
	private JTextField selezionaIndirizzoField;
	private JTextField selezionaCartaField;
	private JTextField numeroDiTelefonoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DettagliOrdineGUI frame = new DettagliOrdineGUI();
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
	public DettagliOrdineGUI() {
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
		selezionaRistoranteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selezionaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaRistoranteLabel.setBounds(10, 79, 169, 31);
		etichettePanel.add(selezionaRistoranteLabel);
		
		JLabel selezionaIndirizzoLabel = new JLabel("Seleziona indirizzo:");
		selezionaIndirizzoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selezionaIndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoLabel.setBounds(10, 124, 169, 31);
		etichettePanel.add(selezionaIndirizzoLabel);
		
		JLabel selezionaCartaLabel = new JLabel("Carta di credito:");
		selezionaCartaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selezionaCartaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaLabel.setBounds(10, 169, 169, 31);
		etichettePanel.add(selezionaCartaLabel);
		
		JLabel selezionaOrarioLabel_1 = new JLabel("Seleziona orario:");
		selezionaOrarioLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		selezionaOrarioLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaOrarioLabel_1.setBounds(10, 214, 169, 31);
		etichettePanel.add(selezionaOrarioLabel_1);
		
		JLabel titoloLabel = new JLabel("Completa i campi:");
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titoloLabel.setBounds(10, 10, 169, 31);
		etichettePanel.add(titoloLabel);
		titoloLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di telefono");
		numeroDiTelefonoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoLabel.setBounds(10, 255, 169, 31);
		etichettePanel.add(numeroDiTelefonoLabel);
		
		JComboBox selezionaRistorantecomboBox = new JComboBox();
		selezionaRistorantecomboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistorantecomboBox.setFocusable(false);
		selezionaRistorantecomboBox.setBackground(Color.white);
		selezionaRistorantecomboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaRistorantecomboBox.setBounds(249, 79, 311, 21);
		getBodyPanel().add(selezionaRistorantecomboBox);
		
		selezionaIndirizzoField = new JTextField();
		selezionaIndirizzoField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoField.setBounds(249, 124, 311, 21);
		getBodyPanel().add(selezionaIndirizzoField);
		selezionaIndirizzoField.setColumns(10);
		
		selezionaCartaField = new JTextField();
		selezionaCartaField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaField.setColumns(10);
		selezionaCartaField.setBounds(249, 169, 311, 21);
		getBodyPanel().add(selezionaCartaField);
		
		JComboBox selezionaOrariocomboBox = new JComboBox();
		selezionaOrariocomboBox.setFocusTraversalKeysEnabled(false);
		selezionaOrariocomboBox.setFocusable(false);
		selezionaOrariocomboBox.setBackground(Color.white);
		selezionaOrariocomboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaOrariocomboBox.setBounds(249, 214, 311, 21);
		getBodyPanel().add(selezionaOrariocomboBox);
		
		MenuButton avantiButton = new MenuButton("Avanti");
		avantiButton.setBounds(580, 375, 85, 21);
		getBodyPanel().add(avantiButton);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoTextField.setColumns(10);
		numeroDiTelefonoTextField.setBounds(249, 255, 311, 21);
		getBodyPanel().add(numeroDiTelefonoTextField);

	}
}
