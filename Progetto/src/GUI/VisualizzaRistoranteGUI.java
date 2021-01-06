package GUI;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VisualizzaRistoranteGUI extends SmallFrame {



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaRistoranteGUI frame = new VisualizzaRistoranteGUI();
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

	JComboBox cittaComboBox;
	String luogo;
	
	
	
	public VisualizzaRistoranteGUI() {

		getBodyPanel().setLayout(null);
		
		JLabel sceltaRistoranteLabel = new JLabel("Di quale ristorante vuoi avere informazioni?");
		sceltaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		sceltaRistoranteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sceltaRistoranteLabel.setBounds(62, 50, 364, 34);
		getBodyPanel().add(sceltaRistoranteLabel);
		
		String [] citta= {"    - - - Seleziona - - -","Napoli","Pisa","Verona"};
		cittaComboBox = new JComboBox(citta);
		cittaComboBox.setFocusable(false);
		cittaComboBox.setFocusTraversalKeysEnabled(false);
		cittaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				luogo=(String)cittaComboBox.getSelectedItem();
				
			}
		});
		cittaComboBox.setBackground(Color.white);
		cittaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		cittaComboBox.setBounds(149, 99, 168, 21);
		getBodyPanel().add(cittaComboBox);
				
		JLabel informazioniRistoranteLabel = new JLabel("//Far comparire le informazioni //");
		informazioniRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		informazioniRistoranteLabel.setBounds(43, 130, 245, 123);
		getBodyPanel().add(informazioniRistoranteLabel);
		
		JLabel cercaSullaMappaButton = new JLabel(new ImageIcon(VisualizzaRistoranteGUI.class.getResource("/GUI/mappa.png")));
		cercaSullaMappaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {	
						switch(luogo) {
						case "Napoli":{
							Desktop desktop = Desktop.getDesktop();
							desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
							break;
						}
						case "Pisa":{							
							Desktop desktop = Desktop.getDesktop();
							desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
							break;						
						}
						case "Verona":{							
							Desktop desktop = Desktop.getDesktop();
							desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
							break;						
						}
						
						}
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		cercaSullaMappaButton.setBounds(387, 201, 40, 40);
		cercaSullaMappaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getBodyPanel().add(cercaSullaMappaButton);
		
//		Mettere questo come azione nel Controller:
//		Desktop desktop = Desktop.getDesktop();
//		desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
//
//		Bisogna importare:
//		import java.awt.Desktop;
//		import java.net.URI;
		
	}
	
	
}
