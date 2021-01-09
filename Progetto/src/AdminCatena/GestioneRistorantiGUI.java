package AdminCatena;

import java.awt.EventQueue;

import General.VisualizzaRistoranteGUI;
import Utility.MediumFrame;

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
		
	}

}
