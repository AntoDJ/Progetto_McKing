package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdottoCatalogoButton extends JButton {
	public ProdottoCatalogoButton() {
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
		setBackground(Color.decode("#00C600"));
		setForeground(Color.white);

		setText("Text");
	}
	public ProdottoCatalogoButton(String text) {
		super();
		setVerticalAlignment(SwingConstants.BOTTOM);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setBounds(100,100,145,145);
		setPreferredSize(new Dimension(200,200));
		setFocusable(false);
		setBorderPainted(false);
		setBackground(Color.decode("#00C600"));
		setText(text);
		setForeground(Color.white);
	}
	
}
