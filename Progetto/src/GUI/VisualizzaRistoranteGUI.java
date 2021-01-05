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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class VisualizzaRistoranteGUI extends MyFrame {



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

	JComboBox CittaComboBox;
	
	
	public VisualizzaRistoranteGUI() {

		getBodyPanel().setLayout(null);
		
		JLabel SceltaRistoranteLabel = new JLabel("Di quale ristorante vuoi avere informazioni?");
		SceltaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		SceltaRistoranteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SceltaRistoranteLabel.setBounds(62, 50, 364, 34);
		getBodyPanel().add(SceltaRistoranteLabel);
		
		String [] citta= {"    - - - Seleziona - - -","Napoli","Pisa","Verona"};
		CittaComboBox = new JComboBox(citta);
		CittaComboBox.setBackground(Color.white);
		CittaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		CittaComboBox.setBounds(149, 99, 168, 21);
		getBodyPanel().add(CittaComboBox);
				
		JLabel InformazioniRistoranteLabel = new JLabel("//Far comparire le informazioni //");
		InformazioniRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		InformazioniRistoranteLabel.setBounds(43, 130, 245, 123);
		getBodyPanel().add(InformazioniRistoranteLabel);
		
		JLabel CercaSullaMappaButton = new JLabel(new ImageIcon(VisualizzaRistoranteGUI.class.getResource("/GUI/mappa.png")));
		CercaSullaMappaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Par o cazz");
				try {
					Desktop desktop = Desktop.getDesktop();
					desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		CercaSullaMappaButton.setBounds(387, 201, 40, 40);
		CercaSullaMappaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getBodyPanel().add(CercaSullaMappaButton);
		
//		Mettere questo come azione nel Controller:
//		Desktop desktop = Desktop.getDesktop();
//		desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
//
//		Bisogna importare:
//		import java.awt.Desktop;
//		import java.net.URI;
		
	}
}
