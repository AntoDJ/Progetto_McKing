package Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MenuButton;
import Utility.SmallFrame;
import javax.swing.JLabel;

import Controller.Controller;
import Entità.Rider;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cancella_GestioneRiderGUI extends SmallFrame {
	Controller controller;
	public JComboBox<Rider> riderDaEliminareComboBox;
	public JLabel risultatoEliminazioneLabel;
	public MenuButton eliminaButton;
	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cancella_GestioneRiderGUI frame = new Cancella_GestioneRiderGUI();
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
	public Cancella_GestioneRiderGUI(Controller controller, ArrayList<Rider> rider) {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.indietroEliminaRider();
			}
		});		
		this.controller = controller;
		getBodyPanel().setBounds(0, 44, 450, 186);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 230);
		getBodyPanel().setLayout(null);
		
		JLabel riderDaEiminareLabel = new JLabel("Scegli il rider da eliminare:");
		riderDaEiminareLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		riderDaEiminareLabel.setBounds(10, 44, 181, 26);
		getBodyPanel().add(riderDaEiminareLabel);
		
		riderDaEliminareComboBox = new JComboBox(rider.toArray(new Rider [0]));
		riderDaEliminareComboBox.setFocusTraversalKeysEnabled(false);
		riderDaEliminareComboBox.setFocusable(false);
		riderDaEliminareComboBox.setBackground(Color.white);
		riderDaEliminareComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		riderDaEliminareComboBox.setBounds(201, 48, 228, 20);
		getBodyPanel().add(riderDaEliminareComboBox);
		
		eliminaButton = new MenuButton("Elimina");
		eliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rider r = (Rider) riderDaEliminareComboBox.getSelectedItem();
				try {
					controller.eliminaRider(r);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		eliminaButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		eliminaButton.setBounds(177, 112, 85, 21);
		getBodyPanel().add(eliminaButton);
		
		risultatoEliminazioneLabel = new JLabel("New label");
		risultatoEliminazioneLabel.setForeground(Color.RED);
		risultatoEliminazioneLabel.setFont(new Font("Bell MT", Font.BOLD, 13));
		risultatoEliminazioneLabel.setBounds(201, 46, 239, 26);
		getBodyPanel().add(risultatoEliminazioneLabel);
		

	}
}
