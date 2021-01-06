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
		EtichettePanel.setBackground(new Color(255, 255, 153));
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
		
		JPanel DettagliPanel = new JPanel();
		DettagliPanel.setBounds(147, 0, 303, 256);
		getBodyPanel().add(DettagliPanel);
		DettagliPanel.setLayout(null);
		
		JLabel ContenitoreNomeLabel = new JLabel("");
		ContenitoreNomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreNomeLabel.setBounds(0, 35, 293, 19);
		DettagliPanel.add(ContenitoreNomeLabel);
		
		JLabel ContenitoreCognomeLabel = new JLabel("");
		ContenitoreCognomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreCognomeLabel.setBounds(0, 60, 293, 19);
		DettagliPanel.add(ContenitoreCognomeLabel);
		
		JLabel ContenitoreEmailLabel = new JLabel("");
		ContenitoreEmailLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreEmailLabel.setBounds(0, 88, 293, 19);
		DettagliPanel.add(ContenitoreEmailLabel);
		
		JLabel ContenitoreNumeroDiTelefonoLabel = new JLabel("");
		ContenitoreNumeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreNumeroDiTelefonoLabel.setBounds(0, 117, 293, 19);
		DettagliPanel.add(ContenitoreNumeroDiTelefonoLabel);
		
		JLabel ContenitoreIndirizzoLabel = new JLabel("");
		ContenitoreIndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreIndirizzoLabel.setBounds(0, 156, 293, 19);
		DettagliPanel.add(ContenitoreIndirizzoLabel);
		
		JLabel ContenitoreCartaDiCreditoLabel = new JLabel("");
		ContenitoreCartaDiCreditoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreCartaDiCreditoLabel.setBounds(0, 185, 293, 19);
		DettagliPanel.add(ContenitoreCartaDiCreditoLabel);

	}
}
