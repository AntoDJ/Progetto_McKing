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
		
		//TODO inserire dati profilo
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBackground(new Color(255, 255, 153));
		etichettePanel.setBounds(0, 0, 146, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel infoLabel = new JLabel("I tuoi dati:");
		infoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		infoLabel.setBounds(10, 10, 93, 19);
		etichettePanel.add(infoLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		nomeLabel.setBounds(10, 39, 93, 19);
		etichettePanel.add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cognomeLabel.setBounds(10, 68, 93, 19);
		etichettePanel.add(cognomeLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		emailLabel.setBounds(10, 96, 93, 19);
		etichettePanel.add(emailLabel);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di telefono");
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		numeroDiTelefonoLabel.setBounds(10, 125, 136, 19);
		etichettePanel.add(numeroDiTelefonoLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo");
		indirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		indirizzoLabel.setBounds(10, 154, 93, 19);
		etichettePanel.add(indirizzoLabel);
		
		JLabel cartaDiCreditoLabel = new JLabel("Carta di credito");
		cartaDiCreditoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cartaDiCreditoLabel.setBounds(10, 183, 129, 19);
		etichettePanel.add(cartaDiCreditoLabel);
		
		JPanel dettagliPanel = new JPanel();
		dettagliPanel.setBounds(147, 0, 303, 256);
		getBodyPanel().add(dettagliPanel);
		dettagliPanel.setLayout(null);
		
		JLabel contenitoreNomeLabel = new JLabel("");
		contenitoreNomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreNomeLabel.setBounds(0, 35, 293, 19);
		dettagliPanel.add(contenitoreNomeLabel);
		
		JLabel contenitoreCognomeLabel = new JLabel("");
		contenitoreCognomeLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreCognomeLabel.setBounds(0, 60, 293, 19);
		dettagliPanel.add(contenitoreCognomeLabel);
		
		JLabel contenitoreEmailLabel = new JLabel("");
		contenitoreEmailLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreEmailLabel.setBounds(0, 88, 293, 19);
		dettagliPanel.add(contenitoreEmailLabel);
		
		JLabel contenitoreNumeroDiTelefonoLabel = new JLabel("");
		contenitoreNumeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreNumeroDiTelefonoLabel.setBounds(0, 117, 293, 19);
		dettagliPanel.add(contenitoreNumeroDiTelefonoLabel);
		
		JLabel contenitoreIndirizzoLabel = new JLabel("");
		contenitoreIndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreIndirizzoLabel.setBounds(0, 156, 293, 19);
		dettagliPanel.add(contenitoreIndirizzoLabel);
		
		JLabel contenitoreCartaDiCreditoLabel = new JLabel("");
		contenitoreCartaDiCreditoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreCartaDiCreditoLabel.setBounds(0, 185, 293, 19);
		dettagliPanel.add(contenitoreCartaDiCreditoLabel);

	}
}