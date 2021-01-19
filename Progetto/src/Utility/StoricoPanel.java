package Utility;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Entità.Ordine;

public class StoricoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StoricoPanel(Ordine o) {
		setBorder(new LineBorder(new Color(255, 200, 0), 4, true));
		setBackground(new Color(255, 255, 102));
		setBounds(10, 10, 880, 115);
		setLayout(null);
		
		JLabel nomeUtenteLabel = new JLabel("Cliente:");
		nomeUtenteLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeUtenteLabel.setBounds(20, 10, 69, 28);
		add(nomeUtenteLabel);
		
		JLabel indirizzoUtenteLabel = new JLabel("Indirizzo utente:");
		indirizzoUtenteLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		indirizzoUtenteLabel.setBounds(20, 42, 127, 28);
		add(indirizzoUtenteLabel);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prezzoTotaleLabel.setBounds(20, 75, 105, 28);
		add(prezzoTotaleLabel);
		
		JLabel nomeRider = new JLabel("Nome rider:");
		nomeRider.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeRider.setBounds(445, 10, 145, 28);
		add(nomeRider);
		
		JLabel tipoMezzoLabel = new JLabel("Tipo mezzo:");
		tipoMezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		tipoMezzoLabel.setBounds(445, 42, 92, 28);
		add(tipoMezzoLabel);
		
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		dataLabel.setBounds(445, 75, 57, 28);
		add(dataLabel);
		
		JLabel nomeUtenteValoreLabel = new JLabel(o.getUtente().getCognome() + " " + o.getUtente().getNome());
		nomeUtenteValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeUtenteValoreLabel.setBounds(98, 10, 236, 28);
		add(nomeUtenteValoreLabel);
		
		JLabel indirizzoUtenteValoreLabel = new JLabel(o.getUtente().getIndirizzo());
		indirizzoUtenteValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		indirizzoUtenteValoreLabel.setBounds(162, 42, 145, 28);
		add(indirizzoUtenteValoreLabel);
		
		JLabel cartaDiCreditoUtenteValoreLabel = new JLabel(o.getUtente().getCartaDiCredito());
		cartaDiCreditoUtenteValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cartaDiCreditoUtenteValoreLabel.setBounds(140, 75, 145, 28);
		add(cartaDiCreditoUtenteValoreLabel);
		
		JLabel nomeRiderValoreLabel = new JLabel(o.getRider().getNome() + " " +o.getRider().getCognome());
		nomeRiderValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeRiderValoreLabel.setBounds(551, 10, 265, 28);
		add(nomeRiderValoreLabel);
		
		JLabel tipoMezzoValoreLabel = new JLabel(o.getRider().getTipoMezzo());
		tipoMezzoValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		tipoMezzoValoreLabel.setBounds(551, 42, 191, 28);
		add(tipoMezzoValoreLabel);

		
		SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
		JLabel dataValoreLabel = new JLabel(sdfr.format(o.getDataOrdine()));
		dataValoreLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		dataValoreLabel.setBounds(515, 75, 179, 28);
		add(dataValoreLabel);

	}
}
