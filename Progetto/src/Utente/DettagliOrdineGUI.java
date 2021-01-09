package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Utility.SmallFrame;
import java.awt.Color;

public class DettagliOrdineGUI extends SmallFrame {
	private JTextField selezionaIndirizzoField;
	private JTextField selezionaCartaField;

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
		getBodyPanel().setBounds(0, 44, 450, 256);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBackground(new Color(240, 240, 240));
		etichettePanel.setBounds(0, 0, 180, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel titoloLabel = new JLabel("DettagliOrdine:");
		titoloLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		titoloLabel.setBounds(10, 10, 169, 31);
		etichettePanel.add(titoloLabel);
		
		JLabel selezionaRistoranteLabel = new JLabel("Seleziona ristorante:");
		selezionaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaRistoranteLabel.setBounds(10, 60, 169, 31);
		etichettePanel.add(selezionaRistoranteLabel);
		
		JLabel selezionaIndirizzoLabel = new JLabel("Seleziona indirizzo:");
		selezionaIndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoLabel.setBounds(10, 105, 169, 31);
		etichettePanel.add(selezionaIndirizzoLabel);
		
		JLabel selezionaCartaLabel = new JLabel("Seleziona carta:");
		selezionaCartaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaLabel.setBounds(10, 150, 169, 31);
		etichettePanel.add(selezionaCartaLabel);
		
		JLabel selezionaOrarioLabel_1 = new JLabel("Seleziona orario:");
		selezionaOrarioLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaOrarioLabel_1.setBounds(10, 195, 169, 31);
		etichettePanel.add(selezionaOrarioLabel_1);
		
		JComboBox selezionaRistorantecomboBox = new JComboBox();
		selezionaRistorantecomboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistorantecomboBox.setFocusable(false);
		selezionaRistorantecomboBox.setBounds(220, 60, 212, 21);
		getBodyPanel().add(selezionaRistorantecomboBox);
		
		selezionaIndirizzoField = new JTextField();
		selezionaIndirizzoField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoField.setBounds(220, 105, 212, 21);
		getBodyPanel().add(selezionaIndirizzoField);
		selezionaIndirizzoField.setColumns(10);
		
		selezionaCartaField = new JTextField();
		selezionaCartaField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaField.setColumns(10);
		selezionaCartaField.setBounds(220, 154, 212, 21);
		getBodyPanel().add(selezionaCartaField);
		
		JComboBox selezionaOrariocomboBox = new JComboBox();
		selezionaOrariocomboBox.setFocusTraversalKeysEnabled(false);
		selezionaOrariocomboBox.setFocusable(false);
		selezionaOrariocomboBox.setBounds(220, 200, 212, 21);
		getBodyPanel().add(selezionaOrariocomboBox);

	}
}
