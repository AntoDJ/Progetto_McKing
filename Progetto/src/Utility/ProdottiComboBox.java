package Utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Entità.Prodotto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdottiComboBox extends JComboBox {
	private ArrayList<Prodotto> prodotti;
	
	public ProdottiComboBox(ArrayList<Prodotto> formatiProdottoDisponibili) {
		prodotti = formatiProdottoDisponibili;
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		setAlignmentY(Component.RIGHT_ALIGNMENT);
		setBackground(Color.white);
		setFont(new Font("Bell MT", Font.ITALIC, 16));
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		
		for(Prodotto p: prodotti) {
			addItem(p.getDimensione());
		}
	}
	public Prodotto getProdottoSelected() {
		Prodotto ret = null;
		for(Prodotto p: prodotti) {
			if(p.getDimensione().equals(getSelectedItem())) ret = p;
		}
		return ret;
	}
	
}
