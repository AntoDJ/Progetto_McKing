package AdminCatena;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import General.VisualizzaRistoranteGUI;
import Utility.MediumFrame;
import Utility.MenuButton;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GestioneRistorantiGUI extends MediumFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneRistorantiGUI frame = new GestioneRistorantiGUI();
					frame.setVisible(true);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GestioneRistorantiGUI() {
		getBodyPanel().setLayout(null);
		
		JLabel visualizzaLabel = new JLabel("Seleziona il ristorante");
		visualizzaLabel.setBounds(53, 43, 164, 21);
		visualizzaLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		getBodyPanel().add(visualizzaLabel);
		
		JComboBox ristorantiComboBox = new JComboBox();
		ristorantiComboBox.setFocusTraversalKeysEnabled(false);
		ristorantiComboBox.setFocusable(false);
		ristorantiComboBox.setBounds(251, 43, 191, 22);
		getBodyPanel().add(ristorantiComboBox);
		
		JLabel storicoLabel = new JLabel("Visualizza storico ->");
		storicoLabel.setFont(new Font("Bell MT", Font.BOLD, 12));
		storicoLabel.setBounds(465, 43, 127, 26);
		getBodyPanel().add(storicoLabel);
		
		JLabel visualizzaIcon = new JLabel("");
		visualizzaIcon.setIcon(new ImageIcon(GestioneRistorantiGUI.class.getResource("/GUI/icons/visualizza.png")));
		visualizzaIcon.setBounds(590, 43, 27, 26);
		getBodyPanel().add(visualizzaIcon);
		
		JLabel cittaLabel = new JLabel("Citt\u00E0:");
		cittaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cittaLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		cittaLabel.setBounds(120, 83, 98, 14);
		getBodyPanel().add(cittaLabel);
		
		JLabel cittaRistoranteLabel = new JLabel("citt\u00E0 del Ristorante");
		cittaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		cittaRistoranteLabel.setBounds(251, 83, 164, 14);
		getBodyPanel().add(cittaRistoranteLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo:");
		indirizzoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		indirizzoLabel.setBounds(120, 116, 98, 14);
		getBodyPanel().add(indirizzoLabel);
		
		JLabel indirizzoRistoranteLabel = new JLabel("Indirizzo del Ristorante");
		indirizzoRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		indirizzoRistoranteLabel.setBounds(251, 116, 164, 14);
		getBodyPanel().add(indirizzoRistoranteLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		telefonoLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		telefonoLabel.setBounds(120, 150, 98, 14);
		getBodyPanel().add(telefonoLabel);
		
		JLabel telefonoRistorante = new JLabel("1234567890");
		telefonoRistorante.setBounds(251, 150, 127, 14);
		telefonoRistorante.setFont(new Font("Bell MT", Font.PLAIN, 12));
		telefonoRistorante.setLabelFor(telefonoLabel);
		getBodyPanel().add(telefonoRistorante);
		
		JLabel adminLabel = new JLabel("Admin:");
		adminLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		adminLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		adminLabel.setBounds(120, 184, 98, 14);
		getBodyPanel().add(adminLabel);
		
		JLabel adminRistoranteLabel = new JLabel("Nome e Cognome Admin");
		adminRistoranteLabel.setBounds(251, 184, 191, 14);
		adminRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		getBodyPanel().add(adminRistoranteLabel);
		
		JLabel attivoLabel = new JLabel("Attivo");
		attivoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		attivoLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		attivoLabel.setBounds(84, 218, 133, 14);
		getBodyPanel().add(attivoLabel);
		
		
		String[] campiAttivo = {"Attivo", "Non attivo"};
		JComboBox attivoComboBox = new JComboBox(campiAttivo);
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
		attivoComboBox.setBounds(251, 218, 100, 22);
		getBodyPanel().add(attivoComboBox);
		
		MenuButton confermaModificheButton = new MenuButton("Conferma");
		confermaModificheButton.setFont(new Font("Bell MT", Font.PLAIN, 10));
		confermaModificheButton.setBounds(361, 218, 81, 22);
		getBodyPanel().add(confermaModificheButton);
		
		JLabel operazioniLabel = new JLabel("Oppure:");
		operazioniLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		operazioniLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		operazioniLabel.setBounds(36, 356, 183, 21);
		getBodyPanel().add(operazioniLabel);
		
		MenuButton aggiungiRistoranteButton = new MenuButton("Aggiungi nuovo Ristorante");
		aggiungiRistoranteButton.setFont(new Font("Bell MT", Font.BOLD, 12));
		aggiungiRistoranteButton.setBounds(251, 354, 191, 23);
		getBodyPanel().add(aggiungiRistoranteButton);
		
	}
}
