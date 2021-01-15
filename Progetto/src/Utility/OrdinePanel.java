package Utility;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Utility.MediumFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Entità.Ordine;

public class OrdinePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrdinePanel(Ordine o) {
		setBorder(new LineBorder(new Color(255, 204, 51), 10, true));
		setBackground(new Color(255, 255, 204));		
		setBounds(10, 10, 290, 115);
		setPreferredSize(new Dimension(300, 115));
		setLayout(null);
		
		JLabel dettagliOrdineLabel = new JLabel(o.getIndirizzoConsegna());
		dettagliOrdineLabel.setBounds(10, 10, 239, 95);
		add(dettagliOrdineLabel);
		
		JLabel checkLabel = new JLabel("X");
		checkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkLabel.setBounds(245, 43, 45, 29);
		add(checkLabel);

	}

}
