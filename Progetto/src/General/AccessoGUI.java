package General;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controller.Controller;
import Utility.MenuButton;
import Utility.SmallFrame;

public class AccessoGUI extends SmallFrame {

	private Controller controller;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccessoGUI frame = new AccessoGUI();
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
	public AccessoGUI(Controller controller) {
		
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		

		JLabel domandaLabel = new JLabel("Come desideri accedere?");
		domandaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		domandaLabel.setBounds(71, 11, 293, 84);
		domandaLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		getBodyPanel().add(domandaLabel);
		
		MenuButton utenteButton = new MenuButton("Utente");
		utenteButton.setBounds(140, 95, 158, 34);

		getBodyPanel().add(utenteButton);
		
		MenuButton adminButton = new MenuButton("Admin");
		adminButton.setBounds(140, 152, 158, 34);
		getBodyPanel().add(adminButton);
		
		MenuButton visualizzaRistorantiButton = new MenuButton("Visualizza Ristoranti");
		visualizzaRistorantiButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		visualizzaRistorantiButton.setBounds(10, 232, 145, 21);
		getBodyPanel().add(visualizzaRistorantiButton);

		


	}
}