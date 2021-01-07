package GUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ProdottoButton extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public ProdottoButton(String nomeProdotto) {
		super();		
				
		setBounds( 0, 0, 206, 142);		
		setPreferredSize(new Dimension(206,142));
		setLayout(null);
		
		JLabel prodottoLabel = new JLabel(nomeProdotto);
		prodottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prodottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottoLabel.setBounds(0, 102, 206, 40);
		add(prodottoLabel);
		
		JLabel lblNewLabel = new JLabel("immagine panino");
		//TODO seleziona percorso immagine
		//lblNewLabel.setIcon(new ImageIcon(ProdottoButton.class.getResource("/GUI/icons")));  
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 206, 142);
		add(lblNewLabel);

	}

}
