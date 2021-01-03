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


public class VisualizzaRistoranteGUI extends JFrame {

	private JPanel VisualizzaRistoranteGuiPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaRistoranteGUI frame = new VisualizzaRistoranteGUI();
					frame.setVisible(true);
					frame.setResizable(false);				
					
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 300);
		VisualizzaRistoranteGuiPane = new JPanel();
		VisualizzaRistoranteGuiPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VisualizzaRistoranteGuiPane);
		VisualizzaRistoranteGuiPane.setLayout(null);
		
		JLabel SceltaRistoranteLabel = new JLabel("Di quale ristorante vuoi avere informazioni?");
		SceltaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		SceltaRistoranteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SceltaRistoranteLabel.setBounds(43, 37, 364, 34);
		VisualizzaRistoranteGuiPane.add(SceltaRistoranteLabel);
		
		String [] citta= {"","Napoli","Pisa","Verona"};
		CittaComboBox = new JComboBox(citta);
		CittaComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		CittaComboBox.setBounds(120, 81, 168, 21);
		VisualizzaRistoranteGuiPane.add(CittaComboBox);
				
		JLabel InformazioniRistoranteLabel = new JLabel("//Far comparire le informazioni //");
		InformazioniRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 12));
		InformazioniRistoranteLabel.setBounds(43, 130, 245, 123);
		VisualizzaRistoranteGuiPane.add(InformazioniRistoranteLabel);
		
		JButton CercaSullaMappaButton = new JButton("Cerca sulla mappa");
		CercaSullaMappaButton.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		CercaSullaMappaButton.setBounds(298, 212, 128, 29);
		VisualizzaRistoranteGuiPane.add(CercaSullaMappaButton);
		
//		Mettere questo come azione nel Controller:
//		Desktop desktop = Desktop.getDesktop();
//		desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
//
//		Bisogna importare:
//		import java.awt.Desktop;
//		import java.net.URI;
		
	}
}
