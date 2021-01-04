package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

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
		setResizable(false);
		setUndecorated(true);
		setBounds(550, 280, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		

		JLabel DomandaLable = new JLabel("Come desideri accedere?");
		DomandaLable.setBounds(130, 10, 198, 84);
		DomandaLable.setFont(new Font("Bell MT", Font.PLAIN, 18));
		getBodyPanel().add(DomandaLable);
		
		JButton UtenteButton = new JButton("Utente");
		UtenteButton.setBounds(140, 95, 158, 34);
		UtenteButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		getBodyPanel().add(UtenteButton);
		
		JButton AdminButton = new JButton("Admin");
		AdminButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		AdminButton.setBounds(140, 152, 158, 34);
		getBodyPanel().add(AdminButton);
		
		JButton VisualizzaRistorantiButton = new JButton("Visualizza Ristoranti");
		VisualizzaRistorantiButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		VisualizzaRistorantiButton.setBounds(10, 232, 145, 21);
		getBodyPanel().add(VisualizzaRistorantiButton);

		


	}

}