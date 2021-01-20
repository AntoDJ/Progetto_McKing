package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Controller;
import Entità.Prodotto;
import Utility.MenuButton;
import Utility.ProdottiComboBox;
import Utility.SmallFrame;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DettagliOrdineProdottoGUI extends SmallFrame {
	private Controller controller;
	private int quantitaSelezionata;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DettagliOrdineProdottoGUI frame = new DettagliOrdineProdottoGUI();
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
	public DettagliOrdineProdottoGUI(ArrayList<Prodotto> formatiProdottoDisponibili, Controller controller) {
		getExitButton().setVisible(false);
		getBackButton().setVisible(false);
		getBodyPanel().setLayout(null);
		getBodyPanel().setBackground(new Color(255, 255, 153));
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBackground(new Color(240, 240, 240));
		etichettePanel.setBounds(0, 0, 136, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel("Dettagli Ordine:");
		dettagliOrdineLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		dettagliOrdineLabel.setBounds(10, 10, 119, 22);
		etichettePanel.add(dettagliOrdineLabel);
		
		JLabel prodottoLabel = new JLabel("Prodotto:");
		prodottoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prodottoLabel.setBounds(10, 56, 119, 22);
		etichettePanel.add(prodottoLabel);
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0");
		quantitaLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		quantitaLabel.setBounds(10, 113, 119, 22);
		etichettePanel.add(quantitaLabel);
		
		JLabel dimensioneLabel = new JLabel("Dimensione");
		dimensioneLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		dimensioneLabel.setBounds(10, 165, 119, 22);
		etichettePanel.add(dimensioneLabel);
		
		JLabel nomeProdottoLabel = new JLabel(formatiProdottoDisponibili.get(0).getNome());
		nomeProdottoLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		nomeProdottoLabel.setBounds(146, 55, 294, 22);
		getBodyPanel().add(nomeProdottoLabel);
		
		String[] quantita = {"1","2","3","4","5","6","7","8","9"};
		JComboBox quantitaComboBox = new JComboBox(quantita);
		quantitaComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				quantitaSelezionata = Integer.parseInt((String) quantitaComboBox.getSelectedItem());
				System.out.println("quantità selezionata = " + quantitaSelezionata);
			}
		});
		quantitaComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		quantitaComboBox.setBackground(Color.white);
		quantitaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 16));
		quantitaComboBox.setFocusTraversalKeysEnabled(false);
		quantitaComboBox.setFocusable(false);
		quantitaComboBox.setBounds(146, 116, 48, 22);
		quantitaComboBox.setSelectedIndex(0);
		getBodyPanel().add(quantitaComboBox);
		
		ProdottiComboBox dimensioneComboBox = new ProdottiComboBox(formatiProdottoDisponibili);
		dimensioneComboBox.setBounds(146, 167, 146, 22);
		getBodyPanel().add(dimensioneComboBox);
		
		MenuButton aggiungiButton = new MenuButton("Aggiungi");
		aggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prodotto prodottoCarrello = dimensioneComboBox.getProdottoSelected();
				System.out.println(prodottoCarrello);
				controller.prodottoAggiunto(prodottoCarrello, quantitaSelezionata);
			}
		});
		aggiungiButton.setBounds(317, 210, 123, 35);
		getBodyPanel().add(aggiungiButton);
		
		MenuButton annullaButton = new MenuButton("Annulla");
		annullaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.annullaNuovoProdotto();
			}
		});
		annullaButton.setBounds(146, 210, 123, 35);
		getBodyPanel().add(annullaButton);

	}
}
