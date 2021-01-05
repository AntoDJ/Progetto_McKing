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
	private void initialize() {
		setFont(new Font("Bell MT", Font.BOLD, 14));
		setBackground(Color.decode("#D3D3D3"));
		setForeground(Color.decode("#111111"));
		setFocusable(false);
	}

}
