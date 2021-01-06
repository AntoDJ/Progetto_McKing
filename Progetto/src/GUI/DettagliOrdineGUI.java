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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 136, 256);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JLabel DettagliOrdineLabel = new JLabel("Dettagli Ordine:");
		DettagliOrdineLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		DettagliOrdineLabel.setBounds(10, 10, 119, 22);
		panel.add(DettagliOrdineLabel);
		
		JLabel ProdottoLabel = new JLabel("Prodotto:");
		ProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ProdottoLabel.setBounds(10, 56, 119, 22);
		panel.add(ProdottoLabel);
		
		JLabel QuantitaLabel = new JLabel("Quantit\u00E0");
		QuantitaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		QuantitaLabel.setBounds(10, 113, 119, 22);
		panel.add(QuantitaLabel);
		
		JLabel lblDimensione = new JLabel("Dimensione");
		lblDimensione.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblDimensione.setBounds(10, 174, 119, 22);
		panel.add(lblDimensione);
		
		JLabel ContenitoreProdottoLabel = new JLabel("");
		ContenitoreProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		ContenitoreProdottoLabel.setBounds(146, 55, 294, 22);
		getBodyPanel().add(ContenitoreProdottoLabel);
		
		JComboBox QuantitaComboBox = new JComboBox();
		QuantitaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 16));
		QuantitaComboBox.setFocusTraversalKeysEnabled(false);
		QuantitaComboBox.setFocusable(false);
		QuantitaComboBox.setBounds(146, 111, 294, 22);
		getBodyPanel().add(QuantitaComboBox);
		
		JComboBox DimensioneComboBox = new JComboBox();
		DimensioneComboBox.setFont(new Font("Bell MT", Font.PLAIN, 16));
		DimensioneComboBox.setFocusTraversalKeysEnabled(false);
		DimensioneComboBox.setFocusable(false);
		DimensioneComboBox.setBounds(146, 176, 294, 22);
		getBodyPanel().add(DimensioneComboBox);

	}
}
