package AdminCatena;

import java.awt.EventQueue;
import java.awt.Font;

import General.VisualizzaRistoranteGUI;
import Utility.MediumFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

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
		getBodyPanel().setLayout(new MigLayout("", "[][183.00][][191.00][184.00][]", "[][35.00][53.00]"));
		
		JLabel visualizzaLabel = new JLabel("Seleziona il ristorante");
		visualizzaLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
		getBodyPanel().add(visualizzaLabel, "cell 1 1");
		
		JComboBox comboBox = new JComboBox();
		getBodyPanel().add(comboBox, "cell 3 1,growx");
		
		JLabel lblNewLabel = new JLabel("New label");
		getBodyPanel().add(lblNewLabel, "cell 5 1");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		getBodyPanel().add(lblNewLabel_1, "cell 1 2,alignx right");
		
	}

}
