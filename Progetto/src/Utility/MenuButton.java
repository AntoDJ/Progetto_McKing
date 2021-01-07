package Utility;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MenuButton extends JButton {

	public MenuButton() {
		initialize();
	}
	public MenuButton(Icon icon) {
		super(icon);
		initialize();
	}
	public MenuButton(String text) {
		super(text);
		initialize();
	}
	public MenuButton(Action a) {
		super(a);
		initialize();
	}
	private void initialize() {
		setBorderPainted(false);
		setFocusPainted(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setFont(new Font("Bell MT", Font.PLAIN, 16));
		setBackground(new Color(255,204,51));
		setForeground(Color.decode("#111111"));
	}

}
