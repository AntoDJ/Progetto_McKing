package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import Utility.BigFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.OrdineAssegnatoPanel;


import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OperazioneRistoranteGUI extends BigFrame {
	private Controller controller;
	public JPanel ordiniAssegnatiPanel;
	public JPanel ordiniDaAssegnarePanel;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OperazioneRistoranteGUI frame = new OperazioneRistoranteGUI();
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
	public OperazioneRistoranteGUI(Controller controller) {
		getBackButton().setVisible(false);
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informazioni ristorante");
		lblNewLabel.setBounds(10, 10, 880, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		getBodyPanel().add(lblNewLabel);
		
		JLabel ordiniAssegnati = new JLabel("Ordini assegnati:");
		ordiniAssegnati.setBounds(10, 37, 158, 33);
		ordiniAssegnati.setFont(new Font("Bell MT", Font.BOLD, 16));
		getBodyPanel().add(ordiniAssegnati);
		
		
		
		ordiniAssegnatiPanel = new JPanel();
		ordiniAssegnatiPanel.setForeground(Color.BLACK);
		ordiniAssegnatiPanel.setBackground(new Color(255, 255, 153));
		ordiniAssegnatiPanel.setLayout(new BoxLayout(ordiniAssegnatiPanel, BoxLayout.Y_AXIS));

		
		ModernScrollPane scrollPane = new ModernScrollPane(ordiniAssegnatiPanel);
		scrollPane.setBounds(10, 80, 420, 400);
		scrollPane.setViewportView(ordiniAssegnatiPanel);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		getBodyPanel().add(scrollPane);
		
		
		ordiniDaAssegnarePanel = new JPanel();
		ordiniDaAssegnarePanel.setForeground(Color.BLACK);
		ordiniDaAssegnarePanel.setBackground(new Color(255, 255, 153));		
		ordiniDaAssegnarePanel.setLayout(new BoxLayout(ordiniDaAssegnarePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane2 = new ModernScrollPane(ordiniDaAssegnarePanel);
		scrollPane2.setBounds(470, 80, 420, 400);
		scrollPane2.setViewportView(ordiniDaAssegnarePanel);
		scrollPane2.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		getBodyPanel().add(scrollPane2);
		
		MenuButton storicoButton = new MenuButton("Storico");
		storicoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.apriStorico();
			}
		});
		storicoButton.setBounds(95, 498, 167, 28);
		getBodyPanel().add(storicoButton);
		
		MenuButton gestisciRiderButton_1 = new MenuButton("Gestisci rider");
		gestisciRiderButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.apriGestisciRider();
			}
		});
		gestisciRiderButton_1.setBounds(580, 498, 167, 28);
		getBodyPanel().add(gestisciRiderButton_1);
		
		JLabel ordiniDaAssegnareLabel = new JLabel("Ordini da assegnare:");
		ordiniDaAssegnareLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		ordiniDaAssegnareLabel.setBounds(470, 37, 158, 33);
		getBodyPanel().add(ordiniDaAssegnareLabel);
		
	}
}
