package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RiepilogoOrdinePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RiepilogoOrdinePanel() {
		setBorder(new LineBorder(new Color(255, 204, 0), 4, true));
		setBackground(new Color(255, 255, 204));
		setBounds(10, 110, 880, 203);
		setLayout(null);
		
		JButton piuButton = new JButton("+");
		piuButton.setFocusPainted(false);
		piuButton.setFocusTraversalKeysEnabled(false);
		piuButton.setFocusable(false);
		piuButton.setForeground(new Color(0, 0, 0));
		piuButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		piuButton.setBounds(798, 53, 42, 27);
		piuButton.setBackground(new Color(255, 204, 0));
		add(piuButton);
		
		JLabel quantit‡Label = new JLabel("10");
		quantit‡Label.setHorizontalAlignment(SwingConstants.CENTER);
		quantit‡Label.setFont(new Font("Bell MT", Font.PLAIN, 22));
		quantit‡Label.setBounds(798, 90, 42, 25);
		add(quantit‡Label);
		
		JButton menoButton = new JButton("-");
		menoButton.setFocusPainted(false);
		menoButton.setFocusTraversalKeysEnabled(false);
		menoButton.setFocusable(false);
		menoButton.setForeground(new Color(0, 0, 0));
		menoButton.setFont(new Font("Bell MT", Font.PLAIN, 16));
		menoButton.setBounds(798, 125, 42, 27);
		menoButton.setBackground(new Color(255, 204, 0));
		add(menoButton);
		
		JLabel fotoProdottoLabel = new JLabel("Foto");
		fotoProdottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fotoProdottoLabel.setBounds(10, 10, 200, 183);
		add(fotoProdottoLabel);
		
		JLabel descrizioneProdottoLabel = new JLabel("Descrizione");
		descrizioneProdottoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descrizioneProdottoLabel.setBounds(228, 10, 560, 183);
		add(descrizioneProdottoLabel);

		

	}

}
