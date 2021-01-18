package Utility;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Utility.MediumFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Entità.Ordine;
import java.awt.Font;

public class OrdineAssegnatoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrdineAssegnatoPanel(Ordine o) {
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
		indirizzoLabel.setBounds(204, 21, 65, 21);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		add(indirizzoLabel);
		
		JLabel nomeValoreLabel = new JLabel(o.getUtente().getNome());
		nomeValoreLabel.setBounds(102, 21, 92, 21);
		nomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(nomeValoreLabel);
		
		JLabel cognomeValoreLabel = new JLabel(o.getUtente().getCognome());
		cognomeValoreLabel.setBounds(112, 52, 91, 21);
		cognomeValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		add(cognomeValoreLabel);
		
		JLabel indirizzoValoreLabel = new JLabel(o.getUtente().getIndirizzo());
		indirizzoValoreLabel.setBounds(276, 21, 145, 21);
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
		
		JLabel riderLabel = new JLabel("Rider");
		riderLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		riderLabel.setBounds(122, 84, 56, 21);
		add(riderLabel);
		
		JLabel riderValoreLabel = new JLabel(o.getRider().getCognome() + " " + o.getRider().getNome());
		riderValoreLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		riderValoreLabel.setBounds(170, 84, 211, 21);
		add(riderValoreLabel);

	}
}
