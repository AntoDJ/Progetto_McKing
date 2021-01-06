package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class DettagliOrdineGUI extends SmallFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DettagliOrdineGUI frame = new DettagliOrdineGUI();
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
	public DettagliOrdineGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel etichettePanel = new JPanel();
		etichettePanel.setBounds(0, 0, 136, 256);
		getBodyPanel().add(etichettePanel);
		etichettePanel.setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel("Dettagli Ordine:");
		dettagliOrdineLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dettagliOrdineLabel.setBounds(10, 10, 119, 22);
		etichettePanel.add(dettagliOrdineLabel);
		
		JLabel prodottoLabel = new JLabel("Prodotto:");
		prodottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottoLabel.setBounds(10, 56, 119, 22);
		etichettePanel.add(prodottoLabel);
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0");
		quantitaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		quantitaLabel.setBounds(10, 113, 119, 22);
		etichettePanel.add(quantitaLabel);
		
		JLabel dimensioneLabel = new JLabel("Dimensione");
		dimensioneLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dimensioneLabel.setBounds(10, 174, 119, 22);
		etichettePanel.add(dimensioneLabel);
		
		JLabel contenitoreProdottoLabel = new JLabel("");
		contenitoreProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		contenitoreProdottoLabel.setBounds(146, 55, 294, 22);
		getBodyPanel().add(contenitoreProdottoLabel);
		
		JComboBox quantitaComboBox = new JComboBox();
		quantitaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 16));
		quantitaComboBox.setFocusTraversalKeysEnabled(false);
		quantitaComboBox.setFocusable(false);
		quantitaComboBox.setBounds(146, 111, 294, 22);
		getBodyPanel().add(quantitaComboBox);
		
		JComboBox dimensioneComboBox = new JComboBox();
		dimensioneComboBox.setFont(new Font("Bell MT", Font.PLAIN, 16));
		dimensioneComboBox.setFocusTraversalKeysEnabled(false);
		dimensioneComboBox.setFocusable(false);
		dimensioneComboBox.setBounds(146, 176, 294, 22);
		getBodyPanel().add(dimensioneComboBox);

	}
}
