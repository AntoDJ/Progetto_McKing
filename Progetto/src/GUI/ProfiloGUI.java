package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;

public class ProfiloGUI extends SmallFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfiloGUI frame = new ProfiloGUI();
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
	public ProfiloGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel EtichettePanel = new JPanel();
		EtichettePanel.setBackground(new Color(244, 244, 244));
		EtichettePanel.setBounds(0, 0, 146, 256);
		getBodyPanel().add(EtichettePanel);
		EtichettePanel.setLayout(null);
		
		JLabel TitleLabel = new JLabel("I tuoi dati:");
		TitleLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		TitleLabel.setBounds(10, 10, 93, 19);
		EtichettePanel.add(TitleLabel);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		NomeLabel.setBounds(10, 39, 93, 19);
		EtichettePanel.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		CognomeLabel.setBounds(10, 68, 93, 19);
		EtichettePanel.add(CognomeLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		EmailLabel.setBounds(10, 96, 93, 19);
		EtichettePanel.add(EmailLabel);
		
		JLabel NumeroDiTelefonoLabel = new JLabel("Numero di telefono");
		NumeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		NumeroDiTelefonoLabel.setBounds(10, 125, 136, 19);
		EtichettePanel.add(NumeroDiTelefonoLabel);
		
		JLabel IndirizzoLabel = new JLabel("Indirizzo");
		IndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		IndirizzoLabel.setBounds(10, 154, 93, 19);
		EtichettePanel.add(IndirizzoLabel);
		
		JLabel CartaDiCreditoLabel = new JLabel("Carta di credito");
		CartaDiCreditoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		CartaDiCreditoLabel.setBounds(10, 183, 129, 19);
		EtichettePanel.add(CartaDiCreditoLabel);

	}
}
