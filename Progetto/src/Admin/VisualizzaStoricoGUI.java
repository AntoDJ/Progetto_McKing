package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.BigFrame;
import Utility.ModernScrollPane;
import Utility.OrdineAssegnatoPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Entità.Admin;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.cert.URICertStoreParameters;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizzaStoricoGUI extends BigFrame {
	public JPanel ordinePanel;
	Controller controller;
	Admin admin;
	public JLabel indietroLabel;
	public JComboBox annoComboBox;
	public JComboBox tipoMezzoComboBox;
	public JComboBox prezzoComboBox;
	public JLabel cercaLabel;
	public JLabel maggioreDiLabel;
	public JLabel visualizzaStoricoLabel;
	public JLabel annoLabel;
	public JLabel tipoMezzoLabel;
	public JLabel prezzoLabel;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VisualizzaStoricoGUI frame = new VisualizzaStoricoGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VisualizzaStoricoGUI(Controller controller, Admin admin) {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.indietroStorico();
			}
		});
		this.admin = admin;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		visualizzaStoricoLabel = new JLabel("Visualizza storico");
		visualizzaStoricoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		visualizzaStoricoLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		visualizzaStoricoLabel.setBounds(10, 10, 880, 35);
		getBodyPanel().add(visualizzaStoricoLabel);
		
		
		annoLabel = new JLabel("Anno:");
		annoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		annoLabel.setBounds(15, 87, 48, 29);
		getBodyPanel().add(annoLabel);
		
		String [] anni = {"  --Seleziona--", "2016", "2017", "2018", "2019", "2020", "2021"};
		annoComboBox = new JComboBox(anni);
		annoComboBox.setBounds(68, 90, 115, 21);
		annoComboBox.setFocusTraversalKeysEnabled(false);
		annoComboBox.setFocusable(false);
		annoComboBox.setBackground(Color.white);
		annoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		getBodyPanel().add(annoComboBox);
		
		
		ordinePanel = new JPanel();
		ordinePanel.setForeground(Color.BLACK);
		ordinePanel.setBackground(new Color(255, 255, 153));
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 130, 880, 416);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		//TODO Bisogna riempire gli ordini
		getBodyPanel().add(scrollPane);
		
		
		String [] mezziDiTrasporto= {"  --Seleziona--", "Bicicletta", "Moto", "Auto"};
		tipoMezzoComboBox = new JComboBox(mezziDiTrasporto);
		tipoMezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		tipoMezzoComboBox.setFocusable(false);
		tipoMezzoComboBox.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox.setBackground(Color.WHITE);
		tipoMezzoComboBox.setBounds(333, 90, 115, 21);
		getBodyPanel().add(tipoMezzoComboBox);
		
		tipoMezzoLabel = new JLabel("Tipo Mezzo:");
		tipoMezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		tipoMezzoLabel.setBounds(229, 87, 94, 29);
		getBodyPanel().add(tipoMezzoLabel);
		
		prezzoLabel = new JLabel("Prezzo");
		prezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		prezzoLabel.setBounds(508, 87, 64, 29);
		getBodyPanel().add(prezzoLabel);
		
		String [] prezzi = {"  --Seleziona--", "20", "50", "80", "100", "120", "150"};
		prezzoComboBox = new JComboBox(prezzi);
		prezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		prezzoComboBox.setFocusable(false);
		prezzoComboBox.setFocusTraversalKeysEnabled(false);
		prezzoComboBox.setBackground(Color.WHITE);
		prezzoComboBox.setBounds(578, 90, 115, 21);
		getBodyPanel().add(prezzoComboBox);
		
		cercaLabel = new JLabel("");
		cercaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cercaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String anno;
				String tipoMezzo;
				String prezzo;
				double prezzodouble;
				
				anno = verificaValore(annoComboBox.getSelectedItem().toString());
				tipoMezzo = verificaValore(tipoMezzoComboBox.getSelectedItem().toString());
				prezzo = verificaValore(prezzoComboBox.getSelectedItem().toString());
				System.out.println(anno + " " + tipoMezzo + " " + prezzo);
				if(prezzo == null)
					prezzodouble = 0.0;
				else 
					prezzodouble = Double.parseDouble(prezzo);				
				controller.ricercaPersonalizzata(admin.getIdRistorante(), anno, tipoMezzo, prezzodouble);
			}
		});
		cercaLabel.setOpaque(true);
		cercaLabel.setFocusTraversalKeysEnabled(false);
		cercaLabel.setFocusable(false);
		cercaLabel.setBackground(Color.WHITE);
		cercaLabel.setIcon(new ImageIcon(VisualizzaStoricoGUI.class.getResource("/GUI/icons/cerca.png")));
		cercaLabel.setBounds(785, 84, 28, 30);
		getBodyPanel().add(cercaLabel);
		
		indietroLabel = new JLabel("NB: Chiudere la finestra per visualizzare nuovamente tutti gli ordini");
		indietroLabel.setForeground(Color.RED);
		indietroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		indietroLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		indietroLabel.setBounds(20, 42, 851, 43);
		getBodyPanel().add(indietroLabel);
		
		maggioreDiLabel = new JLabel("(maggiore di...)");
		maggioreDiLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		maggioreDiLabel.setBounds(491, 103, 81, 29);
		getBodyPanel().add(maggioreDiLabel);
		indietroLabel.setVisible(false);

	}
	


	public String verificaValore (String valore) {
		if (valore.equals("  --Seleziona--"))
			return null;
		else return valore;
	}
}
