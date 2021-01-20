package Utility;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Utility.MediumFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Controller.Controller;
import Entità.Ordine;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdineAssegnatoPanel extends JPanel {
	Controller controller;
	/**
	 * Create the panel.
	 */
	public OrdineAssegnatoPanel(Ordine o, Controller controller) {
		this.controller = controller;
		setBorder(new LineBorder(new Color(255, 204, 51), 10, true));
		setBackground(new Color(255, 255, 204));			
		setMaximumSize(new java.awt.Dimension(840, 120));
		setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel();
		dettagliOrdineLabel.setBounds(10, 103, 340, 2);
		add(dettagliOrdineLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(35, 21, 92, 21);
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setBounds(35, 52, 92, 21);
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(cognomeLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo:");
		indirizzoLabel.setBounds(204, 21, 106, 21);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(indirizzoLabel);
		
		JLabel nomeValoreLabel = new JLabel(o.getUtente().getNome());
		nomeValoreLabel.setBounds(102, 21, 92, 21);
		nomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(nomeValoreLabel);
		
		JLabel cognomeValoreLabel = new JLabel(o.getUtente().getCognome());
		cognomeValoreLabel.setBounds(119, 52, 84, 21);
		cognomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(cognomeValoreLabel);
		
		JLabel indirizzoValoreLabel = new JLabel(o.getUtente().getIndirizzo());
		indirizzoValoreLabel.setBounds(283, 21, 138, 21);
		indirizzoValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(indirizzoValoreLabel);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prezzoTotaleLabel.setBounds(204, 52, 106, 21);
		add(prezzoTotaleLabel);
		
		JLabel prezzoTotaleValoreLabel = new JLabel(String.valueOf(o.getPrezzoTotale()));
		prezzoTotaleValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prezzoTotaleValoreLabel.setBounds(315, 52, 106, 21);
		add(prezzoTotaleValoreLabel);
		
		JLabel riderLabel = new JLabel("Rider:");
		riderLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		riderLabel.setBounds(35, 83, 56, 21);
		add(riderLabel);
		
		JLabel riderValoreLabel = new JLabel(o.getRider().getCognome() + " " + o.getRider().getNome());
		riderValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		riderValoreLabel.setBounds(83, 83, 211, 21);
		add(riderValoreLabel);
		
		JLabel lblConsegnato = new JLabel("Consegnato:");
		lblConsegnato.setFont(new Font("Bell MT", Font.BOLD, 12));
		lblConsegnato.setBounds(287, 83, 84, 21);
		add(lblConsegnato);
		
		JCheckBox confermaCheckBox = new JCheckBox("");
		confermaCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(confermaCheckBox.isSelected()) {
					controller.cambiaStatoConsegna(o);	
					confermaCheckBox.setVisible(false);
				}
			}
		});
		confermaCheckBox.setBackground(new Color(255, 255, 204));
		confermaCheckBox.setBounds(362, 86, 21, 15);
		add(confermaCheckBox);

	}
}
