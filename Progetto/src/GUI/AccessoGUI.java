package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;


public class AccessoGUI extends JFrame {

	private JPanel AccessoGUIPane;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 300);
		AccessoGUIPane = new JPanel();
		AccessoGUIPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AccessoGUIPane);
		AccessoGUIPane.setLayout(null);
		
		
		JLabel DomandaLable = new JLabel("Come desideri accedere?");
		DomandaLable.setBounds(115, 10, 213, 84);
		DomandaLable.setFont(new Font("Bell MT", Font.PLAIN, 18));
		AccessoGUIPane.add(DomandaLable);
		
		JButton UtenteButton = new JButton("Utente");
		UtenteButton.setBounds(125, 98, 158, 34);
		UtenteButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		AccessoGUIPane.add(UtenteButton);
		
		JButton AdminButton = new JButton("Admin");
		AdminButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		AdminButton.setBounds(125, 152, 158, 34);
		AccessoGUIPane.add(AdminButton);
		
		JButton VisualizzaRistorantiButton = new JButton("Visualizza Ristoranti");
		VisualizzaRistorantiButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		VisualizzaRistorantiButton.setBounds(10, 232, 145, 21);
		AccessoGUIPane.add(VisualizzaRistorantiButton);

	}
}
