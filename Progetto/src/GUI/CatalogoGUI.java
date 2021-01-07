package GUI;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.FlowLayout;

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
		paniniImage.setIcon(new ImageIcon(CatalogoGUI.class.getResource("/GUI/icons/panini.jpg")));
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
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
		panel.setPreferredSize(new Dimension(100,2000));
		
		//TODO riempire catalogo
		for(int i = 0 ; i < 1000; i++) {
			panel.add(new JButton());
		}
		ModernScrollPane scrollPane = new ModernScrollPane(panel);
		scrollPane.setBounds(147, 38, 518, 362);
		scrollPane.add(panel);
		scrollPane.setViewportView(panel);
		getBodyPanel().add(scrollPane);
		
		getBackButton().setVisible(false);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 5, 42, 38);
		menuBar.setBackground(null);
		menuBar.setBorder(null);
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getTitoloPanel().add(menuBar);
		
		JMenu profiloMenu = new JMenu("");
		profiloMenu.setIcon(new ImageIcon(CatalogoGUI.class.getResource("/GUI/icons/profilo.png")));
		menuBar.add(profiloMenu);
		
		JMenuItem profiloMenuItem = new JMenuItem("Profilo");
		profiloMenu.add(profiloMenuItem);
		
		JMenuItem profiloMenuItem_1 = new JMenuItem("Esci");
		profiloMenu.add(profiloMenuItem_1);
		
		
	}
}
