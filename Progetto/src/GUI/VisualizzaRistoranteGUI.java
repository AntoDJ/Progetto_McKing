package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		CittaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		CittaComboBox.setBounds(149, 99, 168, 21);
		getBodyPanel().add(CittaComboBox);
				
		JLabel InformazioniRistoranteLabel = new JLabel("//Far comparire le informazioni //");
		InformazioniRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		InformazioniRistoranteLabel.setBounds(43, 130, 245, 123);
		getBodyPanel().add(InformazioniRistoranteLabel);
		
		JButton CercaSullaMappaButton = new JButton("");
		CercaSullaMappaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ciao");
			}
		});
		CercaSullaMappaButton.setContentAreaFilled(false);		
		CercaSullaMappaButton.setIcon(new ImageIcon("C:\\Users\\anton\\OneDrive\\Desktop\\mappa.png"));
		CercaSullaMappaButton.setRequestFocusEnabled(false);
		CercaSullaMappaButton.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		CercaSullaMappaButton.setBounds(349, 212, 77, 29);
		CercaSullaMappaButton.setBorder(null);
		CercaSullaMappaButton.setBackground(null);
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
