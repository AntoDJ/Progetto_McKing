package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AccessoGUI extends MyFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoGUI frame = new AccessoGUI();
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
	public AccessoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		

		JLabel DomandaLable = new JLabel("Come desideri accedere?");
		DomandaLable.setHorizontalAlignment(SwingConstants.CENTER);
		DomandaLable.setBounds(71, 11, 293, 84);
		DomandaLable.setFont(new Font("Bell MT", Font.PLAIN, 18));
		getBodyPanel().add(DomandaLable);
		
		MenuButton UtenteButton = new MenuButton("Utente");
		UtenteButton.setBounds(140, 95, 158, 34);

		getBodyPanel().add(UtenteButton);
		
		MenuButton AdminButton = new MenuButton("Admin");
		AdminButton.setBounds(140, 152, 158, 34);
		getBodyPanel().add(AdminButton);
		
		MenuButton VisualizzaRistorantiButton = new MenuButton("Visualizza Ristoranti");
		VisualizzaRistorantiButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		VisualizzaRistorantiButton.setBounds(10, 232, 145, 21);
		getBodyPanel().add(VisualizzaRistorantiButton);

		


	}

}