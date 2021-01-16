package Utility;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controller.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdottoPanel extends JPanel {
	private Controller controller;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	
	
	public ProdottoPanel(String nomeProdotto, String URL, Controller controller) throws IOException {
		super();
		this.controller = controller;
		
		setBounds( 0, 0, 206, 142);		
		setPreferredSize(new Dimension(206,142));
		setLayout(null);
		
		JLabel prodottoLabel = new JLabel(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>",nomeProdotto));
		prodottoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.prodottoSelezionato(nomeProdotto);
			}
		});
		prodottoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prodottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prodottoLabel.setBackground(Color.white);
		prodottoLabel.setOpaque(true);
		prodottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottoLabel.setBounds(0, 102, 206, 40);
		add(prodottoLabel);
		
		JLabel immagineProdottoLabel = new JLabel("");
		
		Image image;
		BufferedImage bi;
		String nomeImage = new String(nomeProdotto.replaceAll("\\s","") + ".png");
		String path = new String(System.getProperty("user.dir") + "\\src\\GUI\\icons\\" + nomeImage);
		File pathImage = new File(path);
		
		if(!pathImage.exists()) {
			try {
				URL url = new URL(URL);
				image = ImageIO.read(url);

				ImageIcon ii = new ImageIcon(image);
				bi = new BufferedImage(206, 142, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = (Graphics2D)bi.createGraphics();
				g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY));
				boolean b = g2d.drawImage(ii.getImage(), 0, 0, 206, 142, null);
				System.out.println(b);
				ImageIO.write(bi, "png", pathImage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		immagineProdottoLabel.setIcon(new ImageIcon(ProdottoPanel.class.getResource("/GUI/icons/" + nomeImage)));
		//image.getScaledInstance(128, 128, java.awt.Image.SCALE_REPLICATE);
			
		immagineProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		immagineProdottoLabel.setBounds(0, 0, 206, 142);
		add(immagineProdottoLabel);

	}

}
