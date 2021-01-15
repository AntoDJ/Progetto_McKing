package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Utility.SmallFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;

public class DettagliOrdineProdottoGUI extends SmallFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DettagliOrdineProdottoGUI frame = new DettagliOrdineProdottoGUI();
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
	public DettagliOrdineProdottoGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getBodyPanel().setLayout(null);
		getBodyPanel().setBackground(new Color(255, 255, 153));
		
		//TODO inserire dati prodotto
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBackground(new Color(240, 240, 240));
		etichettePanel.setBounds(0, 0, 136, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel("Dettagli Ordine:");
		dettagliOrdineLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dettagliOrdineLabel.setBounds(10, 10, 119, 22);
		etichettePanel.add(dettagliOrdineLabel);
		
		JLabel prodottoLabel = new JLabel("Prodotto:");
		prodottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottoLabel.setBounds(10, 56, 119, 22);
		etichettePanel.add(prodottoLabel);
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0");
		quantitaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		quantitaLabel.setBounds(10, 113, 119, 22);
		etichettePanel.add(quantitaLabel);
		
		JLabel dimensioneLabel = new JLabel("Dimensione");
		dimensioneLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dimensioneLabel.setBounds(10, 174, 119, 22);
		etichettePanel.add(dimensioneLabel);
		
		JLabel contenitoreProdottoLabel = new JLabel("");
		contenitoreProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreProdottoLabel.setBounds(146, 55, 294, 22);
		getBodyPanel().add(contenitoreProdottoLabel);
		
		JComboBox quantitaComboBox = new JComboBox();
		quantitaComboBox.setBackground(Color.white);
		quantitaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		quantitaComboBox.setFocusTraversalKeysEnabled(false);
		quantitaComboBox.setFocusable(false);
		quantitaComboBox.setBounds(146, 116, 294, 22);
		getBodyPanel().add(quantitaComboBox);
		
		JComboBox dimensioneComboBox = new JComboBox();
		dimensioneComboBox.setBackground(Color.white);
		dimensioneComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		dimensioneComboBox.setFocusTraversalKeysEnabled(false);
		dimensioneComboBox.setFocusable(false);
		dimensioneComboBox.setBounds(146, 176, 294, 22);
		getBodyPanel().add(dimensioneComboBox);

	}
}
