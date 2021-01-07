package Utility;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Utility.MediumFrame;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class OrdineButton extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrdineButton() {
		setBorder(new LineBorder(new Color(255, 204, 51), 4, true));
		setBackground(new Color(255, 255, 204));
		
		setBounds(10, 10, 655, 115);
		setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel("DettagliOrdine");
		dettagliOrdineLabel.setBounds(10, 10, 580, 95);
		add(dettagliOrdineLabel);
		
		JLabel checkLabel = new JLabel("X");
		checkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkLabel.setBounds(600, 43, 45, 29);
		add(checkLabel);

	}

}
