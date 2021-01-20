package Utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Entità.Prodotto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RiepilogoOrdinePanel extends JPanel {
	private RiepilogoOrdinePanel selfRef = this;
	private boolean piuPremuto = false;
	private boolean menoPremuto = false;
	private Controller controller;
	/**
	 * Create the panel.
	 * @param prodotto 
	 */
	public RiepilogoOrdinePanel(Controller controller, Prodotto prodotto) {
		this.controller = controller;
		setBorder(new LineBorder(new Color(255, 204, 0), 4, true));
		setBackground(new Color(255, 255, 204));
		setBounds(10, 110, 880, 203);
		setLayout(null);
		setMaximumSize(new Dimension(880, 203));
		setMinimumSize(new Dimension(880, 203));
		
		
		JLabel quantitaProdottoLabel = new JLabel("x" + prodotto.getQuantità());
		quantitaProdottoLabel.setOpaque(true);
		quantitaProdottoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		quantitaProdottoLabel.setFont(new Font("Bell MT", Font.PLAIN, 22));
		quantitaProdottoLabel.setBounds(694, 88, 42, 25);
		add(quantitaProdottoLabel);
		
		JButton piuButton = new JButton("+");
		piuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!piuPremuto) {
					piuPremuto = true;
					if(prodotto.getQuantità() >= 20) {
						JOptionPane.showMessageDialog(piuButton, new String("Non puoi ordinare più di 20 unità!"));
					}
					else{
						prodotto.setQuantità(prodotto.getQuantità() + 1);
						controller.calcolaPrezzoTotale();
					}
					quantitaProdottoLabel.setText("x" + String.valueOf(prodotto.getQuantità()));
					piuPremuto = false;
				}
			}
		});
		piuButton.setFocusPainted(false);
		piuButton.setFocusTraversalKeysEnabled(false);
		piuButton.setFocusable(false);
		piuButton.setForeground(new Color(0, 0, 0));
		piuButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		piuButton.setBounds(811, 89, 55, 27);
		piuButton.setBackground(new Color(255, 204, 0));
		add(piuButton);
		
		JButton menoButton = new JButton("-");
		menoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!menoPremuto) {
					menoPremuto = true;
					prodotto.setQuantità(prodotto.getQuantità() - 1);
					quantitaProdottoLabel.setText("x" + String.valueOf(prodotto.getQuantità()));
					System.out.println("Quantità nuova del prodotto = " + prodotto.getQuantità());
					if (prodotto.getQuantità() <= 0) {
						controller.rimuoviDalCarrello(selfRef, prodotto);
					}
					controller.calcolaPrezzoTotale();
					menoPremuto = false;
				}
			}
		});
		menoButton.setFocusPainted(false);
		menoButton.setFocusTraversalKeysEnabled(false);
		menoButton.setFocusable(false);
		menoButton.setForeground(new Color(0, 0, 0));
		menoButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		menoButton.setBounds(746, 89, 55, 27);
		menoButton.setBackground(new Color(255, 204, 0));
		add(menoButton);
		
		JLabel fotoProdottoLabel = new JLabel();
		fotoProdottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fotoProdottoLabel.setBounds(24, 29, 206, 142);
		add(fotoProdottoLabel);
		
		Image image;
		BufferedImage bi;
		String nomeImage = new String(prodotto.getNome().replaceAll("\\s","") + ".png");
		String path = new String(System.getProperty("user.dir") + "\\src\\GUI\\icons\\" + nomeImage);
		File pathImage = new File(path);
		
		if(!pathImage.exists()) {
			try {
				URL url = new URL(prodotto.getUrl());
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
		
		fotoProdottoLabel.setIcon(new ImageIcon(ProdottoPanel.class.getResource("/GUI/icons/" + nomeImage)));
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0:");
		quantitaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quantitaLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		quantitaLabel.setBounds(606, 84, 87, 32);
		add(quantitaLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		nomeLabel.setBounds(240, 29, 133, 25);
		add(nomeLabel);
		
		JLabel dimensioneLabel = new JLabel("Dimensione:");
		dimensioneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dimensioneLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		dimensioneLabel.setBounds(240, 89, 133, 25);
		add(dimensioneLabel);
		
		JLabel prezzoLabel = new JLabel("Prezzo:");
		prezzoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		prezzoLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		prezzoLabel.setBounds(240, 146, 133, 25);
		add(prezzoLabel);
		
		JLabel nomeProdottoLabel = new JLabel(prodotto.getNome());
		nomeProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeProdottoLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
		nomeProdottoLabel.setBounds(383, 29, 206, 25);
		add(nomeProdottoLabel);
		
		JLabel dimensioneProdottoLabel = new JLabel(prodotto.getDimensione());
		dimensioneProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dimensioneProdottoLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
		dimensioneProdottoLabel.setBounds(383, 90, 206, 25);
		add(dimensioneProdottoLabel);
		
		JLabel prezzoProdottoLabel = new JLabel(prodotto.getPrezzo() + " €");
		prezzoProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoProdottoLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
		prezzoProdottoLabel.setBounds(383, 146, 206, 25);
		add(prezzoProdottoLabel);

		

	}

}
