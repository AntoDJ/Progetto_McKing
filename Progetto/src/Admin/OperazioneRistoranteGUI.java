package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.OrdinePanel;


import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OperazioneRistoranteGUI extends MediumFrame {
	private Controller controller;
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
		lblNewLabel.setBounds(10, 10, 655, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		getBodyPanel().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ordini in corso:");
		lblNewLabel_1.setBounds(10, 37, 158, 33);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		getBodyPanel().add(lblNewLabel_1);
		
		
		
		JPanel ordinePanel = new JPanel();
		ordinePanel.setForeground(Color.BLACK);
		ordinePanel.setBackground(new Color(255, 255, 153));
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 80, 655, 230);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		//TODO Bisogna riempire gli ordini
		int size = 0;
		for (int i = 0; i< 4; i++) {
			size += 115;
			ordinePanel.add(new OrdinePanel());
			ordinePanel.add(Box.createVerticalStrut(10));
		}
		ordinePanel.setPreferredSize(new Dimension(100,size));
		getBodyPanel().add(scrollPane);
		
		MenuButton storicoButton = new MenuButton("Storico");
		storicoButton.setBounds(120, 338, 167, 28);
		getBodyPanel().add(storicoButton);
		
		MenuButton storicoButton_1 = new MenuButton("Gestisci rider");
		storicoButton_1.setBounds(387, 338, 167, 28);
		getBodyPanel().add(storicoButton_1);
		
	}
}
