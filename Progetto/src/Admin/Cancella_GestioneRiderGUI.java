package Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MenuButton;
import Utility.SmallFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Cancella_GestioneRiderGUI extends SmallFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancella_GestioneRiderGUI frame = new Cancella_GestioneRiderGUI();
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
	public Cancella_GestioneRiderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 230);
		getBodyPanel().setLayout(null);
		
		JLabel riderDaEiminareLabel = new JLabel("Scegli il rider da eliminare:");
		riderDaEiminareLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		riderDaEiminareLabel.setBounds(10, 44, 181, 26);
		getBodyPanel().add(riderDaEiminareLabel);
		
		JComboBox riderDaEliminareComboBox = new JComboBox();
		riderDaEliminareComboBox.setFocusTraversalKeysEnabled(false);
		riderDaEliminareComboBox.setFocusable(false);
		riderDaEliminareComboBox.setBackground(Color.white);
		riderDaEliminareComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		riderDaEliminareComboBox.setBounds(201, 48, 228, 20);
		getBodyPanel().add(riderDaEliminareComboBox);
		
		MenuButton eliminaButton = new MenuButton("Elimina");
		eliminaButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		eliminaButton.setBounds(177, 112, 85, 21);
		getBodyPanel().add(eliminaButton);
		

	}
}
