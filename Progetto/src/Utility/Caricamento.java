package Utility;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Caricamento extends BigFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caricamento frame = new Caricamento();
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
	public Caricamento() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel Label1 = new JLabel("La preghiamo di attendere!");
		Label1.setFont(new Font("Bell MT", Font.BOLD, 20));
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(10, 131, 880, 56);
		getBodyPanel().add(Label1);
		
		JLabel Label2 = new JLabel("Sar\u00E0 immediatamente reindirizzato alla pagina precedente.");
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setFont(new Font("Bell MT", Font.BOLD, 20));
		Label2.setBounds(10, 203, 880, 56);
		getBodyPanel().add(Label2);
		
		JLabel lblCiScusiamoPer = new JLabel("Ci scusiamo per l'attesa...");
		lblCiScusiamoPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiScusiamoPer.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblCiScusiamoPer.setBounds(10, 294, 880, 56);
		getBodyPanel().add(lblCiScusiamoPer);

	}

}
