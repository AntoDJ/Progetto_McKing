package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MediumFrame;
import Utility.ModernScrollPane;
import Utility.OrdinePanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class VisualizzaStoricoGUI extends MediumFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaStoricoGUI frame = new VisualizzaStoricoGUI();
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
	public VisualizzaStoricoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel visualizzaStoricoLabel = new JLabel("Visualizza storico");
		visualizzaStoricoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		visualizzaStoricoLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
		visualizzaStoricoLabel.setBounds(10, 10, 655, 35);
		getBodyPanel().add(visualizzaStoricoLabel);
		
		JLabel annoLabel = new JLabel("Anno:");
		annoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		annoLabel.setBounds(15, 87, 48, 29);
		getBodyPanel().add(annoLabel);
		
		JComboBox annoComboBox = new JComboBox();
		annoComboBox.setBounds(68, 90, 115, 21);
		annoComboBox.setFocusTraversalKeysEnabled(false);
		annoComboBox.setFocusable(false);
		annoComboBox.setBackground(Color.white);
		annoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		getBodyPanel().add(annoComboBox);
		
		
		JPanel ordinePanel = new JPanel();
		ordinePanel.setForeground(Color.BLACK);
		ordinePanel.setBackground(new Color(255, 255, 153));
		
		ordinePanel.setLayout(new BoxLayout(ordinePanel, BoxLayout.Y_AXIS));

		ModernScrollPane scrollPane = new ModernScrollPane(ordinePanel);
		scrollPane.setBounds(10, 130, 655, 230);
		scrollPane.setBorder(new LineBorder(new Color(255, 51, 0), 2, true));
		
		//TODO Bisogna riempire gli ordini
		int size = 0;
		for (int i = 0; i< 4; i++) {
			size += 115;
			ordinePanel.add(new OrdinePanel());
			ordinePanel.add(Box.createVerticalStrut(10));
		}
		ordinePanel.setPreferredSize(new Dimension(100,size));
		getBodyPanel().add(scrollPane);
		
		
		String [] mezziDiTrasporto= {"  --Seleziona--", "Bicicletta", "Moto", "Auto"};
		JComboBox tipoMezzoComboBox = new JComboBox(mezziDiTrasporto);
		tipoMezzoComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		tipoMezzoComboBox.setFocusable(false);
		tipoMezzoComboBox.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox.setBackground(Color.WHITE);
		tipoMezzoComboBox.setBounds(307, 90, 115, 21);
		getBodyPanel().add(tipoMezzoComboBox);
		
		JLabel tipoMezzoLabel = new JLabel("Tipo Mezzo");
		tipoMezzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		tipoMezzoLabel.setBounds(216, 87, 81, 29);
		getBodyPanel().add(tipoMezzoLabel);
		
		JLabel prodottiLabel = new JLabel("Prodotti");
		prodottiLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		prodottiLabel.setBounds(465, 87, 64, 29);
		getBodyPanel().add(prodottiLabel);
		
		JComboBox tipoMezzoComboBox_1 = new JComboBox();
		tipoMezzoComboBox_1.setFont(new Font("Bell MT", Font.PLAIN, 14));
		tipoMezzoComboBox_1.setFocusable(false);
		tipoMezzoComboBox_1.setFocusTraversalKeysEnabled(false);
		tipoMezzoComboBox_1.setBackground(Color.WHITE);
		tipoMezzoComboBox_1.setBounds(535, 90, 115, 21);
		getBodyPanel().add(tipoMezzoComboBox_1);

	}

}
