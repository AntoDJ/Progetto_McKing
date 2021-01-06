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
import javax.swing.JButton;

public class CatalogoGUI extends MediumFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoGUI frame = new CatalogoGUI();
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
	public CatalogoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel presentazioneLabel = new JLabel("Ecco i nostri prodotti:");
		presentazioneLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		presentazioneLabel.setBounds(10, 0, 201, 37);
		getBodyPanel().add(presentazioneLabel);
		
		JPanel prodottiPanel = new JPanel();
		prodottiPanel.setBounds(10, 38, 127, 362);
		getBodyPanel().add(prodottiPanel);
		prodottiPanel.setLayout(null);
		
		JLabel paniniImage = new JLabel("");
		paniniImage.setIcon(new ImageIcon(CatalogoGUI.class.getResource("/GUI/panini.jpg")));
		paniniImage.setFont(new Font("Bell MT", Font.PLAIN, 18));
		paniniImage.setHorizontalAlignment(SwingConstants.CENTER);
		paniniImage.setBounds(0, 0, 127, 72);
		paniniImage.setVisible(false);
		prodottiPanel.add(paniniImage);
		
		JLabel patatineLabel = new JLabel("Patatine");
		patatineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patatineLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		patatineLabel.setBounds(0, 70, 127, 72);
		prodottiPanel.add(patatineLabel);
		
		JLabel bevandeLabel = new JLabel("Bevande");
		bevandeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bevandeLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		bevandeLabel.setBounds(0, 147, 127, 72);
		prodottiPanel.add(bevandeLabel);
		
		JLabel dessertsLabel = new JLabel("Desserts");
		dessertsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dessertsLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		dessertsLabel.setBounds(0, 219, 127, 72);
		prodottiPanel.add(dessertsLabel);
		
		JLabel altroLabel = new JLabel("Altro");
		altroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		altroLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		altroLabel.setBounds(0, 289, 127, 72);
		prodottiPanel.add(altroLabel);
		
		JLabel paniniLabel = new JLabel("Panini");
		paniniLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paniniLabel.setVisible(true);
				paniniImage.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paniniLabel.setVisible(true);
				paniniImage.setVisible(false);
			}
		});
		paniniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paniniLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		paniniLabel.setBounds(0, 0, 127, 72);
		prodottiPanel.add(paniniLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(147, 38, 518, 362);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 89, 23);
		getContentPane().add(btnNewButton);
		
	}
}
