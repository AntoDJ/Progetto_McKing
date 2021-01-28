package Utility;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Entità.Rider;
import java.awt.Font;

public class RiderPanel extends JPanel {

	/**
	 * Create the panel.z
	 */
	public RiderPanel(Rider rider) {
		setBorder(new LineBorder(new Color(0, 204, 102), 10, true));
		setBackground(new Color(255, 255, 102));
		setBounds(10, 10, 655, 115);
		setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeLabel.setBounds(49, 10, 77, 28);
		add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cognomeLabel.setBounds(49, 61, 77, 28);
		add(cognomeLabel);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di telefono:");
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		numeroDiTelefonoLabel.setBounds(349, 10, 167, 28);
		add(numeroDiTelefonoLabel);
		
		JLabel tipoMezzoLabel = new JLabel("Tipo Mezzo:");
		tipoMezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		tipoMezzoLabel.setBounds(349, 61, 94, 28);
		add(tipoMezzoLabel);
		
		JLabel valoreNomeLabel = new JLabel(rider.getNome());
		valoreNomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		valoreNomeLabel.setBounds(107, 10, 187, 28);
		add(valoreNomeLabel);
		
		JLabel valoreCognomeLabel = new JLabel(rider.getCognome());
		valoreCognomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		valoreCognomeLabel.setBounds(131, 61, 163, 28);
		add(valoreCognomeLabel);
		
		JLabel valoreNumeroDiTelefonoLabel = new JLabel(rider.getNumeroDiTelefono());
		valoreNumeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		valoreNumeroDiTelefonoLabel.setBounds(503, 10, 128, 28);
		add(valoreNumeroDiTelefonoLabel);
		
		JLabel valoreTipoMezzoLabel = new JLabel(rider.getTipoMezzo());
		valoreTipoMezzoLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		valoreTipoMezzoLabel.setBounds(444, 61, 187, 28);
		add(valoreTipoMezzoLabel);
		

	}
}
