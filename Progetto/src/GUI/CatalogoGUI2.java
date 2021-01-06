package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class CatalogoGUI2 extends MediumFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoGUI2 frame = new CatalogoGUI2();
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
	public CatalogoGUI2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel PresentazioneLabel = new JLabel("Ecco i nostri prodotti:");
		PresentazioneLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		getBodyPanel().add(PresentazioneLabel);
		
		JPanel ProdottiPanel = new JPanel();
		ProdottiPanel.setBounds(10, 38, 127, 362);
		getBodyPanel().add(ProdottiPanel);
		ProdottiPanel.setLayout(null);
		
		JLabel PaniniLabel = new JLabel("");
		PaniniLabel.setIcon(new ImageIcon(CatalogoGUI2.class.getResource("/GUI/panini.jpg")));
		PaniniLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PaniniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PaniniLabel.setBounds(0, 0, 127, 72);
		PaniniLabel.setVisible(false);
		ProdottiPanel.add(PaniniLabel);
		
		JLabel PatatineLabel = new JLabel("Patatine");
		PatatineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PatatineLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PatatineLabel.setBounds(0, 70, 127, 72);
		ProdottiPanel.add(PatatineLabel);
		
		JLabel BevandeLabel = new JLabel("Bevande");
		BevandeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BevandeLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		BevandeLabel.setBounds(0, 147, 127, 72);
		ProdottiPanel.add(BevandeLabel);
		
		JLabel DessertsLabel = new JLabel("Desserts");
		DessertsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DessertsLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		DessertsLabel.setBounds(0, 219, 127, 72);
		ProdottiPanel.add(DessertsLabel);
		
		JLabel AltroLabel = new JLabel("Altro");
		AltroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AltroLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		AltroLabel.setBounds(0, 289, 127, 72);
		ProdottiPanel.add(AltroLabel);
		
		JLabel Panini2 = new JLabel("Panini");
		Panini2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Panini2.setVisible(true);
				PaniniLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panini2.setVisible(true);
				PaniniLabel.setVisible(false);
			}
		});
		Panini2.setHorizontalAlignment(SwingConstants.CENTER);
		Panini2.setFont(new Font("Bell MT", Font.PLAIN, 18));
		Panini2.setBounds(0, 0, 127, 72);
		ProdottiPanel.add(Panini2);
		
		JPanel panel = new JPanel();
		panel.setBounds(147, 38, 518, 362);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
	}
}
