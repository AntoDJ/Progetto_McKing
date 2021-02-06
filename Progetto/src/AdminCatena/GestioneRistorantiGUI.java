package AdminCatena;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import General.VisualizzaRistoranteGUI;
import Utility.MediumFrame;
import Utility.MenuButton;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.Controller;
import Entità.Admin;
import Entità.Ristorante;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class GestioneRistorantiGUI extends MediumFrame {
	private Ristorante ristoranteSelezionato;
	private String adminRistoranteSelezionato;
	private Controller controller;
	private JLabel indirizzoRistoranteLabel;
	private JLabel telefonoRistoranteLabel;
	private JLabel adminRistoranteLabel;
	private JLabel cittaRistoranteLabel;
	private JComboBox attivoComboBox;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GestioneRistorantiGUI frame = new GestioneRistorantiGUI();
//					frame.setVisible(true);				
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public GestioneRistorantiGUI(Controller controller) {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaAdAccessoGUIDaGestioneRistorantiGUI();
			}
		});
		getBodyPanel().setLayout(null);
		this.controller = controller;
		
		JLabel visualizzaLabel = new JLabel("Seleziona il ristorante");
		visualizzaLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		visualizzaLabel.setBounds(26, 43, 191, 21);
		visualizzaLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(visualizzaLabel);
		
		
		JLabel storicoLabel = new JLabel("Visualizza storico ->");
		storicoLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		storicoLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		storicoLabel.setBounds(36, 269, 181, 26);
		getBodyPanel().add(storicoLabel);
		
		JLabel visualizzaIcon = new JLabel("");
		visualizzaIcon.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				controller.apriStoricoRistoranteSelezionato(ristoranteSelezionato.getId());
			}
		});
		visualizzaIcon.setIcon(new ImageIcon(GestioneRistorantiGUI.class.getResource("/GUI/icons/visualizza.png")));
		visualizzaIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		visualizzaIcon.setBounds(251, 269, 27, 26);
		getBodyPanel().add(visualizzaIcon);
		
		JLabel cittaLabel = new JLabel("Citt\u00E0:");
		cittaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cittaLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		cittaLabel.setBounds(120, 83, 98, 14);
		getBodyPanel().add(cittaLabel);
		
		cittaRistoranteLabel = new JLabel();
		cittaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		cittaRistoranteLabel.setBounds(251, 76, 221, 33);
		getBodyPanel().add(cittaRistoranteLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo:");
		indirizzoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		indirizzoLabel.setBounds(120, 116, 98, 14);
		getBodyPanel().add(indirizzoLabel);
		
		indirizzoRistoranteLabel = new JLabel();
		indirizzoRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		indirizzoRistoranteLabel.setBounds(251, 109, 221, 29);
		getBodyPanel().add(indirizzoRistoranteLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		telefonoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		telefonoLabel.setBounds(120, 150, 98, 14);
		getBodyPanel().add(telefonoLabel);
		
		telefonoRistoranteLabel = new JLabel();
		telefonoRistoranteLabel.setBounds(251, 141, 221, 30);
		telefonoRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		telefonoRistoranteLabel.setLabelFor(telefonoLabel);
		getBodyPanel().add(telefonoRistoranteLabel);
		
		JLabel adminLabel = new JLabel("Admin:");
		adminLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		adminLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		adminLabel.setBounds(120, 184, 98, 14);
		getBodyPanel().add(adminLabel);
		
		adminRistoranteLabel = new JLabel();
		adminRistoranteLabel.setBounds(251, 174, 221, 33);
		adminRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		getBodyPanel().add(adminRistoranteLabel);
		
		JLabel attivoLabel = new JLabel("Attivo");
		attivoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		attivoLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		attivoLabel.setBounds(84, 218, 133, 14);
		getBodyPanel().add(attivoLabel);
		
		
		String[] campiAttivo = {"Attivo", "Non attivo"};
		attivoComboBox = new JComboBox(campiAttivo);
		attivoComboBox.setForeground(Color.yellow);
		attivoComboBox.setFont(new Font("Bell MT", Font.BOLD, 14));
		
		if(attivoComboBox.getSelectedItem() == "Attivo") attivoComboBox.setBackground(new Color(0, 204, 102));
		else attivoComboBox.setBackground(new Color(255, 51, 0));
		attivoComboBox.setFocusTraversalKeysEnabled(false);
		attivoComboBox.setFocusable(false);
		attivoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(attivoComboBox.getSelectedItem() == "Attivo") attivoComboBox.setBackground(new Color(0, 204, 102));
				else attivoComboBox.setBackground(new Color(255, 51, 0));
			}
		});
		attivoComboBox.setBounds(251, 218, 124, 22);
		getBodyPanel().add(attivoComboBox);
		
		MenuButton confermaModificheButton = new MenuButton("Conferma");
		confermaModificheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.modificaStatoRistorante(ristoranteSelezionato.getId() , attivoComboBox.getSelectedItem().toString().equals("Attivo") ? true : false);
				ristoranteSelezionato.setAttivo(attivoComboBox.getSelectedItem().toString().equals("Attivo") ? true : false);
			}
		});
		confermaModificheButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		confermaModificheButton.setBounds(413, 218, 119, 22);
		getBodyPanel().add(confermaModificheButton);
		
		JLabel operazioniLabel = new JLabel("Oppure:");
		operazioniLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		operazioniLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		operazioniLabel.setBounds(36, 356, 183, 21);
		getBodyPanel().add(operazioniLabel);
		
		MenuButton aggiungiRistoranteButton = new MenuButton("Aggiungi nuovo Ristorante");
		aggiungiRistoranteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aggiungiNuovoRistorante();
			}
		});
		aggiungiRistoranteButton.setFont(new Font("Bell MT", Font.BOLD, 14));
		aggiungiRistoranteButton.setBounds(251, 354, 281, 23);
		getBodyPanel().add(aggiungiRistoranteButton);
		
		JComboBox selezionaRistoranteComboBox = new JComboBox();
		
		selezionaRistoranteComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ristoranteSelezionato = (Ristorante)selezionaRistoranteComboBox.getSelectedItem();
				adminRistoranteSelezionato = controller.getAdminRistorante(ristoranteSelezionato.getId());
				aggiornaLabels();
			}
		});
		
		controller.riempiComboBoxRistorante(selezionaRistoranteComboBox, false);
		selezionaRistoranteComboBox.setFocusable(false);
		selezionaRistoranteComboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistoranteComboBox.setBackground(Color.white);
		selezionaRistoranteComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaRistoranteComboBox.setBounds(251, 43, 281, 22);
		selezionaRistoranteComboBox.setSelectedIndex(0);
		getBodyPanel().add(selezionaRistoranteComboBox);
		
	}
	private void aggiornaLabels() {
		indirizzoRistoranteLabel.setText(ristoranteSelezionato.getIndirizzo());  
		telefonoRistoranteLabel.setText(ristoranteSelezionato.getNumeroDiTelefono());   
		adminRistoranteLabel.setText(adminRistoranteSelezionato);      
		cittaRistoranteLabel.setText(ristoranteSelezionato.getCitta());
		attivoComboBox.setSelectedIndex(ristoranteSelezionato.isAttivo() ? 0 : 1);
	}
}
