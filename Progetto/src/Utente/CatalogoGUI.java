package Utente;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;

import Controller.Controller;
import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.ModernScrollPane;
import Utility.ProdottoPanel;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatalogoGUI extends MediumFrame {	
	private Controller controller;
	private String tipoAttivo;
	public JPanel catalogoPanel;

	public String getTipoAttivo() {
		return tipoAttivo;
	}
	public JPanel getCatalogoPanel() {
		return catalogoPanel;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CatalogoGUI frame = new CatalogoGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CatalogoGUI(Controller controller) throws IOException {
		this.controller = controller;
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
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hai premuto " + paniniLabel.getText() + " e tipo attivo = " + tipoAttivo);
				if(!paniniLabel.getText().equals(tipoAttivo)) {
					tipoAttivo = paniniLabel.getText();
					controller.popolaCatalogo(tipoAttivo, catalogoPanel);
				}
			}
		});
		paniniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paniniLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		paniniLabel.setBounds(0, 0, 127, 72);
		prodottiPanel.add(paniniLabel);
		
		patatineLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				patatineLabel.setVisible(true);
				//patatineImage.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				patatineLabel.setVisible(true);
				//patatineImage.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hai premuto " + patatineLabel.getText() + " e tipo attivo = " + tipoAttivo);
				if(!patatineLabel.getText().equals(tipoAttivo)) {
					tipoAttivo = patatineLabel.getText();
					controller.popolaCatalogo(tipoAttivo, catalogoPanel);
				}
			}
		});
		
		bevandeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bevandeLabel.setVisible(true);
				//bevandeImage.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				patatineLabel.setVisible(true);
				//bevandeImage.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hai premuto " + bevandeLabel.getText() + " e tipo attivo = " + tipoAttivo);
				if(!bevandeLabel.getText().equals(tipoAttivo)) {
					tipoAttivo = bevandeLabel.getText();
					controller.popolaCatalogo(tipoAttivo, catalogoPanel);
				}
			}
		});
		
		dessertsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dessertsLabel.setVisible(true);
				//dessertsImage.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dessertsLabel.setVisible(true);
				//dessertsImage.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hai premuto " + dessertsLabel.getText() + " e tipo attivo = " + tipoAttivo);
				if(!dessertsLabel.getText().equals(tipoAttivo)) {
					tipoAttivo = dessertsLabel.getText();
					controller.popolaCatalogo(tipoAttivo, catalogoPanel);
				}
			}
		});
		
		altroLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				altroLabel.setVisible(true);
				//altroImage.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				altroLabel.setVisible(true);
				//altroImage.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hai premuto " + altroLabel.getText() + " e tipo attivo = " + tipoAttivo);
				if(!altroLabel.getText().equals(tipoAttivo)) {
					tipoAttivo = altroLabel.getText();
					controller.popolaCatalogo(tipoAttivo, catalogoPanel);
				}
			}
		});
		
		// inizializzo lo scroll pane e lo popolo attraverso il controller
		catalogoPanel = new JPanel();
		catalogoPanel.setBackground(new Color(255, 255, 224));
		catalogoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 35, 25));

		// inizializzo il tipoAttivo per riempire il catalogo dal controller
		tipoAttivo = paniniLabel.getText();
		
		ModernScrollPane scrollPane = new ModernScrollPane(catalogoPanel);
		scrollPane.setBounds(147, 38, 518, 362);
		scrollPane.setViewportView(catalogoPanel);
		getBodyPanel().add(scrollPane);
		
		MenuButton CarrelloButton = new MenuButton("Visualizza Carrello");
		CarrelloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostraCarrello();
			}
		});
		CarrelloButton.setBounds(497, 10, 168, 23);
		getBodyPanel().add(CarrelloButton);
		
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
		profiloMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostraProfilo();
			}
		});
		profiloMenu.add(profiloMenuItem);
		
		JMenuItem profiloMenuItem_1 = new JMenuItem("Esci");
		profiloMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.logoutUtente();
			}
		});
		profiloMenu.add(profiloMenuItem_1);
		
	}
}
