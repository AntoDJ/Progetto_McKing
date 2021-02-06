package Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Entità.Prodotto;
import Utility.BigFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.RiepilogoOrdinePanel;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RiepilogoOrdineGUI extends BigFrame {
	private Controller controller;
	public JPanel riepilogoOrdinePanel;
	private JLabel valorePrezzoTotaleLabel;
	private ModernScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RiepilogoOrdineGUI frame = new RiepilogoOrdineGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}



	public JLabel getValorePrezzoTotaleLabel() {
		return valorePrezzoTotaleLabel;
	}



	/**
	 * Create the frame.
	 */
	public RiepilogoOrdineGUI(Controller controller) {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaAlCatalogoDaRiepilogoOrdineGUI();
			}
		});
		this.controller = controller;
		getBodyPanel().setSize(900, 570);
		getBodyPanel().setLocation(0, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel prezzoPanel = new JPanel();
		prezzoPanel.setBackground(Color.WHITE);
		prezzoPanel.setBorder(new LineBorder(new Color(255, 153, 0), 2, true));
		prezzoPanel.setBounds(10, 479, 880, 48);
		getBodyPanel().add(prezzoPanel);
		prezzoPanel.setLayout(null);
		
		JLabel prezzoTotaleLabel = new JLabel("Prezzo totale:");
		prezzoTotaleLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prezzoTotaleLabel.setBounds(10, 10, 146, 31);
		prezzoPanel.add(prezzoTotaleLabel);
		
		valorePrezzoTotaleLabel = new JLabel();
		valorePrezzoTotaleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		valorePrezzoTotaleLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		valorePrezzoTotaleLabel.setBounds(688, 10, 158, 31);
		prezzoPanel.add(valorePrezzoTotaleLabel);
		
		MenuButton confermaButton = new MenuButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!controller.getCarrello().isEmpty()) controller.inserisciDatiPagamento(Double.valueOf(valorePrezzoTotaleLabel.getText().substring(0,valorePrezzoTotaleLabel.getText().length()-1)));
				else JOptionPane.showMessageDialog(getBodyPanel(), "Il carrello è vuoto");
			}
		});
		confermaButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setForeground(Color.BLACK);
		confermaButton.setBorderPainted(false);
		confermaButton.setFocusPainted(false);
		confermaButton.setFocusTraversalKeysEnabled(false);
		confermaButton.setFocusable(false);
		confermaButton.setBounds(763, 538, 127, 21);
		getBodyPanel().add(confermaButton);
		
		riepilogoOrdinePanel = new JPanel();
		
		riepilogoOrdinePanel.setLayout(new BoxLayout(riepilogoOrdinePanel, BoxLayout.Y_AXIS));
		
		scrollPane = new ModernScrollPane(riepilogoOrdinePanel);
		scrollPane.setBounds(10, 40, 880, 428);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		getBodyPanel().add(scrollPane);
		
		JLabel euroLabel = new JLabel("€");
		euroLabel.setFont(new Font("Arial", Font.BOLD, 14));
		euroLabel.setBounds(850,10,20,31);
		prezzoPanel.add(euroLabel);
	}

	public void aggiornaScrollPane() {
		scrollPane.remove(riepilogoOrdinePanel);
		
		riepilogoOrdinePanel = new JPanel();
		riepilogoOrdinePanel.setLayout(new BoxLayout(riepilogoOrdinePanel, BoxLayout.Y_AXIS));
		controller.aggiornaCarrello();
//		riepilogoOrdinePanel.revalidate();
//		riepilogoOrdinePanel.repaint();
		scrollPane.setViewportView(riepilogoOrdinePanel);
		scrollPane.getViewport().revalidate();;
	}
}
