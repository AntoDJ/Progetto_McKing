package AdminCatena;

import java.awt.EventQueue;
import java.awt.Font;

import Utente.CatalogoGUI;
import Utility.MediumFrame;
import Utility.MenuButton;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperazioniCatenaGUI extends MediumFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperazioniCatenaGUI frame = new OperazioniCatenaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OperazioniCatenaGUI() {
		getBodyPanel().setLayout(null);
		
		getBackButton().setVisible(false);
		JLabel salutoLabel = new JLabel("Bentornato AdminCatena");
		salutoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salutoLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		salutoLabel.setBounds(0, 0, 264, 62);
		getBodyPanel().add(salutoLabel);
		
		JLabel operazioniLabel = new JLabel("Cosa vuoi gestire?");
		operazioniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		operazioniLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		operazioniLabel.setBounds(175, 42, 323, 82);
		getBodyPanel().add(operazioniLabel);
		
		MenuButton ristorantiButton = new MenuButton("Ristoranti");
		ristorantiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ristorantiButton.setBounds(212, 135, 248, 50);
		getBodyPanel().add(ristorantiButton);
		
		MenuButton catalogoProdottiButton = new MenuButton("Catalogo Prodotti");
		catalogoProdottiButton.setBounds(212, 200, 248, 50);
		getBodyPanel().add(catalogoProdottiButton);
		
		MenuButton adminButton = new MenuButton("Admin");
		adminButton.setBounds(212, 265, 248, 50);
		getBodyPanel().add(adminButton);
		
	}
}
