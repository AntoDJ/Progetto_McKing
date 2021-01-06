package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RiepilogoOrdineGUI extends MediumFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiepilogoOrdineGUI frame = new RiepilogoOrdineGUI();
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
	public RiepilogoOrdineGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
