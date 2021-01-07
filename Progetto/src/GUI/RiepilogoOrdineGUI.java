package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class RiepilogoOrdineGUI extends BigFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiepilogoOrdineGUI frame = new RiepilogoOrdineGUI();
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
	public RiepilogoOrdineGUI() {
		getBodyPanel().setLocation(0, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel prezzoPanel = new JPanel();
		prezzoPanel.setBounds(10, 444, 880, 48);
		getBodyPanel().add(prezzoPanel);
		prezzoPanel.setLayout(null);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prezzoTotaleLabel.setBounds(10, 10, 98, 31);
		prezzoPanel.add(prezzoTotaleLabel);
		
		JLabel valorePrezzoTotaleLabel = new JLabel("");
		valorePrezzoTotaleLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		valorePrezzoTotaleLabel.setBounds(724, 10, 146, 31);
		prezzoPanel.add(valorePrezzoTotaleLabel);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBackground(Color.WHITE);
		annullaButton.setForeground(Color.BLACK);
		annullaButton.setBorderPainted(false);
		annullaButton.setFocusPainted(false);
		annullaButton.setFocusTraversalKeysEnabled(false);
		annullaButton.setFocusable(false);
		annullaButton.setBounds(10, 515, 113, 21);
		getBodyPanel().add(annullaButton);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setForeground(Color.BLACK);
		confermaButton.setBorderPainted(false);
		confermaButton.setFocusPainted(false);
		confermaButton.setFocusTraversalKeysEnabled(false);
		confermaButton.setFocusable(false);
		confermaButton.setBounds(786, 515, 104, 21);
		getBodyPanel().add(confermaButton);
		
		JPanel riepilogoOrdinePanel = new JPanel();
		
		riepilogoOrdinePanel.setLayout(new BoxLayout(riepilogoOrdinePanel, BoxLayout.Y_AXIS));
		riepilogoOrdinePanel.setPreferredSize(new Dimension(100,2000));
		ModernScrollPane scrollPane = new ModernScrollPane(riepilogoOrdinePanel);
		scrollPane.setBounds(10, 40, 880, 377);
		
		//TODO riempire riepilogo ordine
		for (int i = 0; i< 4; i++) {
			riepilogoOrdinePanel.add(new RiepilogoOrdinePanel());
		}
		getBodyPanel().add(scrollPane);

	}
}
