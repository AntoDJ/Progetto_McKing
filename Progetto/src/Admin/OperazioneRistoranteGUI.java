package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import Utility.MediumFrame;
import Utility.ModernScrollPane;
import Utility.OrdineButton;


import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class OperazioneRistoranteGUI extends MediumFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperazioneRistoranteGUI frame = new OperazioneRistoranteGUI();
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
	public OperazioneRistoranteGUI() {
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
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 80, 655, 230);
		
		//TODO Bisogna riempire gli ordini
		int size = 0;
		for (int i = 0; i< 4; i++) {
			size += 115;
			ordinePanel.add(new OrdineButton());
		}
		ordinePanel.setPreferredSize(new Dimension(100,size));
		getBodyPanel().add(scrollPane);
		
		JButton storicoButton = new JButton("Storico");
		storicoButton.setBorderPainted(false);
		storicoButton.setFocusPainted(false);
		storicoButton.setFocusTraversalKeysEnabled(false);
		storicoButton.setFocusable(false);
		storicoButton.setBackground(new Color(255, 204, 51));
		storicoButton.setForeground(new Color(0, 0, 0));
		storicoButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		storicoButton.setBounds(120, 338, 167, 28);
		getBodyPanel().add(storicoButton);
		
		JButton storicoButton_1 = new JButton("Gestisci rider");
		storicoButton_1.setBorderPainted(false);
		storicoButton_1.setFocusPainted(false);
		storicoButton_1.setFocusTraversalKeysEnabled(false);
		storicoButton_1.setFocusable(false);
		storicoButton_1.setBackground(new Color(255, 204, 51));
		storicoButton_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		storicoButton_1.setBounds(387, 338, 167, 28);
		getBodyPanel().add(storicoButton_1);
		
	}
}
