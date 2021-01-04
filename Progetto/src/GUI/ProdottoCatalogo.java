package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdottoCatalogo extends JButton {
	private final JLabel label = new JLabel("New label");
	public ProdottoCatalogo() {
		super();
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setVerticalAlignment(SwingConstants.BOTTOM);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setBounds(100,100,145,145);
		setPreferredSize(new Dimension(200,200));
		setFocusable(false);
		setBorderPainted(false);
		setBackground(Color.yellow);

		setText("Text");
	}
	public ProdottoCatalogo(String text) {
		super();
		setVerticalAlignment(SwingConstants.BOTTOM);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setBounds(100,100,145,145);
		setPreferredSize(new Dimension(200,200));
		setFocusable(false);
		setBorderPainted(false);
		setBackground(Color.yellow);
		label.setText(text);
		label.setVisible(true);
	}
	
}
