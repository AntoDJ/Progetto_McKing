package Utility;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ProdottoPanel extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	
	
	public ProdottoPanel(String nomeProdotto, String URL) throws IOException {
		super();
				
		setBounds( 0, 0, 206, 142);		
		setPreferredSize(new Dimension(206,142));
		setLayout(null);
		
		JLabel prodottoLabel = new JLabel(nomeProdotto);
		prodottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prodottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottoLabel.setBounds(0, 102, 206, 40);
		add(prodottoLabel);
		
		JLabel immagineProdottoLabel = new JLabel("");			
		URL url = new URL(URL);
		Image image = ImageIO.read(url);
		image.getScaledInstance(128, 128, java.awt.Image.SCALE_REPLICATE);
		immagineProdottoLabel.setIcon(new ImageIcon(image));		
		immagineProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		immagineProdottoLabel.setBounds(0, 0, 206, 142);
		add(immagineProdottoLabel);

	}

}
