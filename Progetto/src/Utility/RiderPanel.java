package Utility;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class RiderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RiderPanel() {
		setBorder(new LineBorder(new Color(0, 204, 102), 10, true));
		setBackground(new Color(255, 255, 102));
		setBounds(10, 10, 655, 115);
		setLayout(null);
		
		JLabel fotoRiderLabel = new JLabel("Foto");
		fotoRiderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fotoRiderLabel.setBounds(10, 10, 111, 95);
		add(fotoRiderLabel);
		
		JLabel dettagliRiderLabel = new JLabel("DettagliRider");
		dettagliRiderLabel.setBounds(131, 10, 514, 95);
		add(dettagliRiderLabel);
		

	}

}
