package Utility;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Entità.Ordine;
import Entità.Rider;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdineDaAssegnarePanel extends JPanel {
	private Controller controller;
	private Ordine ordine;
	public OrdineDaAssegnarePanel panel;
	public JButton confermaButton;
	
	/**
	 * Create the panel.
	 */
	public OrdineDaAssegnarePanel(Ordine o,  Controller controller) {
		this.ordine = o;
		this.controller = controller;
		panel = this;
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
		cognomeLabel.setBounds(35, 47, 92, 21);
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(cognomeLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo:");
		indirizzoLabel.setBounds(35, 78, 92, 21);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(indirizzoLabel);
		
		JLabel nomeValoreLabel = new JLabel(o.getUtente().getNome());
		nomeValoreLabel.setBounds(102, 21, 92, 21);
		nomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(nomeValoreLabel);
		
		JLabel cognomeValoreLabel = new JLabel(o.getUtente().getCognome());
		cognomeValoreLabel.setBounds(115, 47, 91, 21);
		cognomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(cognomeValoreLabel);
		
		JLabel indirizzoValoreLabel = new JLabel(o.getUtente().getIndirizzo());
		indirizzoValoreLabel.setBounds(102, 78, 166, 21);
		indirizzoValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(indirizzoValoreLabel);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prezzoTotaleLabel.setBounds(236, 21, 101, 21);
		add(prezzoTotaleLabel);
		
		JLabel prezzoTotaleValoreLabel = new JLabel(String.valueOf(o.getPrezzoTotale()));
		prezzoTotaleValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prezzoTotaleValoreLabel.setBounds(336, 21, 92, 21);
		add(prezzoTotaleValoreLabel);
		
		confermaButton = new JButton("Assegna");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.apriSelezioneRider(o, panel);
				
			}
		});
		confermaButton.setFocusPainted(false);
		confermaButton.setFocusTraversalKeysEnabled(false);
		confermaButton.setFocusable(false);
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		confermaButton.setBounds(265, 55, 85, 21);
		add(confermaButton);

		}
	public Ordine getOrdine() {
		return ordine;
	}

	}
		
