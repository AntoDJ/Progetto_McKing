package Utility;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CategoriaProdottoButton extends JButton {

	public CategoriaProdottoButton(){
		setFocusable(false);
		setBackground(Color.decode("#66FF00"));
		setForeground(Color.decode("#FFE7FA"));
		setFont(new Font("Bell MT", Font.BOLD, 24));
		setText("Text");
	}
	public CategoriaProdottoButton(String text){
		setFocusable(false);
		setBackground(Color.decode("#66FF00"));
		setForeground(Color.decode("#FFE7FA"));
		setFont(new Font("Bell MT", Font.BOLD, 24));
		setText(text);
	}
	
}
