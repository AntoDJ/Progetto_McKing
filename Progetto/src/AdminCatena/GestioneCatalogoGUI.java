package AdminCatena;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.ProdottoPanel;

public class GestioneCatalogoGUI extends MediumFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneCatalogoGUI frame = new GestioneCatalogoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GestioneCatalogoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		MenuButton nuovoProdottoButton = new MenuButton();
		nuovoProdottoButton.setText("Aggiungi prodotto");
		nuovoProdottoButton.setFont(new Font("Bell MT", Font.ITALIC, 18));
		nuovoProdottoButton.setBounds(10, 5, 210, 30);
		getBodyPanel().add(nuovoProdottoButton);
		
		JPanel prodottiPanel = new JPanel();
		prodottiPanel.setBounds(10, 38, 127, 362);
		getBodyPanel().add(prodottiPanel);
		prodottiPanel.setLayout(null);
		
		JLabel paniniImage = new JLabel("");
		paniniImage.setIcon(new ImageIcon(GestioneCatalogoGUI.class.getResource("/GUI/icons/panini.jpg")));
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
		panel.setBackground(new Color(255, 255, 224));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 35, 25));

		
		//TODO riempire catalogo e aggiungere size variabile
		int size = 0;
		for(int i = 0 ; i < 10; i++) {
			if(i%2 == 0) size += 170;
			//panel.add(new ProdottoPanel("Panino #" + i));
		}
		panel.setPreferredSize(new Dimension(500,size));
		ModernScrollPane scrollPane = new ModernScrollPane(panel);
		scrollPane.setBounds(147, 38, 518, 362);
		scrollPane.add(panel);
		scrollPane.setViewportView(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		getBodyPanel().add(scrollPane);
	}
}
