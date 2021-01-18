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
	public JComboBox<Rider> riderComboBox ;
	private Controller controller;
	Ordine ordine;
	
	/**
	 * Create the panel.
	 */
	public OrdineDaAssegnarePanel(Ordine o, ArrayList rider, Controller controller) {
		ordine = o;
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
		indirizzoValoreLabel.setBounds(102, 78, 235, 21);
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
		
		JButton confermaButton = new JButton("Assegna");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rider r = (Rider) riderComboBox.getSelectedItem();
				o.setRider(r);
				controller.riderScelto(o);	
			}
		});
		confermaButton.setFocusPainted(false);
		confermaButton.setFocusTraversalKeysEnabled(false);
		confermaButton.setFocusable(false);
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		confermaButton.setBounds(269, 75, 85, 21);
		add(confermaButton);

		
		riderComboBox = new JComboBox(rider.toArray(new Rider [0]));		
		riderComboBox.setBackground(Color.WHITE);
		riderComboBox.setFocusTraversalKeysEnabled(false);
		riderComboBox.setFocusable(false);
		riderComboBox.setBounds(236, 48, 157, 21);
		add(riderComboBox);		

		}
		
	public Ordine getOrdine() {
		return ordine;
	}
	
	
	public OrdineDaAssegnarePanel getPanel() {
		return this;
	}
	
	
	
}
