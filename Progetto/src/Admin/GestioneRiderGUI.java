package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.OrdineAssegnatoPanel;
import Utility.RiderPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestioneRiderGUI extends MediumFrame {
	private Controller controller;
	public JPanel ordinePanel;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GestioneRider frame = new GestioneRider();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GestioneRiderGUI(Controller controller) throws SQLException {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.indietroGestisciRider();
			}
		});
		this.controller = controller;
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
		
		
		ordinePanel = new JPanel();
		ordinePanel.setBackground(new Color(255, 255, 153));
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 130, 655, 230);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		//TODO Bisogna riempire gli ordini
		
		
		getBodyPanel().add(scrollPane);
		
		MenuButton aggiungiButton = new MenuButton("Aggiungi rider");
		aggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.apriInserisciRider();
			}
		});
		aggiungiButton.setBounds(120, 80, 167, 28);
		getBodyPanel().add(aggiungiButton);
		
		MenuButton storicoButton_1 = new MenuButton("Elimina rider");
		storicoButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.apriEliminazioneRider();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		storicoButton_1.setBounds(387, 80, 167, 28);
		getBodyPanel().add(storicoButton_1);
	}
}
