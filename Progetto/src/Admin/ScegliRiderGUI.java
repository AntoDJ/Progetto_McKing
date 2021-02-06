package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MenuButton;
import Utility.OrdineDaAssegnarePanel;
import Utility.SmallFrame;
import javax.swing.JTextField;

import Controller.Controller;
import Entità.Ordine;
import Entità.Rider;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class ScegliRiderGUI extends SmallFrame {
	Controller controller;
	public MenuButton confermaButton;


//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ScegliRiderGUI frame = new ScegliRiderGUI();
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
	public ScegliRiderGUI(Controller controller, ArrayList rider, Ordine ordine, OrdineDaAssegnarePanel panel) {
		getBodyPanel().setBackground(new Color(255, 255, 102));
		getBodyPanel().setBounds(0, 44, 450, 136);
		this.controller = controller;
		setBounds(100, 100, 450, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JComboBox riderComboBox = new JComboBox(rider.toArray(new Rider [0]));
		riderComboBox.setBackground(Color.WHITE);
		riderComboBox.setFocusTraversalKeysEnabled(false);
		riderComboBox.setFocusable(false);		
		riderComboBox.setBounds(212, 43, 194, 22);
		getBodyPanel().add(riderComboBox);
		
		confermaButton = new MenuButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rider r = (Rider) riderComboBox.getSelectedItem();
				ordine.setRider(r);
				controller.riderScelto(ordine);
				panel.confermaButton.setVisible(false);				
			}
		});
		confermaButton.setBounds(152, 105, 108, 21);
		getBodyPanel().add(confermaButton);
		
		JLabel lblNewLabel = new JLabel("Scegli il rider:");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 43, 134, 22);
		getBodyPanel().add(lblNewLabel);

	}
}