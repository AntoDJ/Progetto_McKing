package GUI;

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

	public MenuButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}
	private void initialize() {
		setFont(new Font("Bell MT", Font.BOLD, 14));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.decode("#F4F6F7"));
		setFocusable(false);
	}

}
