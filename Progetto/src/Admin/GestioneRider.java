package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.OrdinePanel;
import Utility.RiderPanel;
import java.awt.Color;

public class GestioneRider extends MediumFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneRider frame = new GestioneRider();
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
	public GestioneRider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel riderLabel = new JLabel("Riders");
		riderLabel.setBounds(10, 10, 655, 28);
		riderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riderLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		getBodyPanel().add(riderLabel);
		
		JLabel domandaLabel = new JLabel("Cosa intendi fare:");
		domandaLabel.setBounds(10, 37, 158, 33);
		domandaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		getBodyPanel().add(domandaLabel);
		
		
		
		JPanel ordinePanel = new JPanel();
		ordinePanel.setBackground(new Color(255, 255, 153));
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 130, 655, 230);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		//TODO Bisogna riempire gli ordini
		int size = 0;
		for (int i = 0; i< 4; i++) {
			size += 115;
			ordinePanel.add(new RiderPanel());
			ordinePanel.add(Box.createVerticalStrut(10));
		}
		ordinePanel.setPreferredSize(new Dimension(100,size));
		getBodyPanel().add(scrollPane);
		
		MenuButton aggiungiButton = new MenuButton("Aggiungi rider");
		aggiungiButton.setBounds(120, 80, 167, 28);
		getBodyPanel().add(aggiungiButton);
		
		MenuButton storicoButton_1 = new MenuButton("Elimina rider");
		storicoButton_1.setBounds(387, 80, 167, 28);
		getBodyPanel().add(storicoButton_1);
	}
}
