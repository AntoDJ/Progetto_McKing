package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

public class CatalogoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoGUI frame = new CatalogoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CatalogoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 858, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cards = new JPanel();
		cards.setBounds(171, 37, 663, 517);
		contentPane.add(cards);
		cards.setLayout(new CardLayout(0, 0));
		
		JPanel card_panini = new JPanel();
		card_panini.setFocusable(false);
		card_panini.setBounds(new Rectangle(0,0, 0, 0));
		card_panini.setAutoscrolls(true);
		cards.add(card_panini, "PANINI");
		card_panini.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
		ArrayList<ProdottoCatalogo> lista = new ArrayList<ProdottoCatalogo>();
		//Da modificare con le query dal database che mostranoo i prodotti della categoria corrispondente
		for(int i = 0; i<32;i++) {
			lista.add(new ProdottoCatalogo("Botdad" ));
			lista.get(i).setPreferredSize(lista.get(i).getPreferredSize());
			card_panini.add(lista.get(i));
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 37, 157, 517);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton PaniniButton = new JButton("Panini");
		PaniniButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PaniniButton.setBounds(0, 10, 153, 103);
		panel_1.add(PaniniButton);
		
		JButton PatatineButton = new JButton("Patatine");
		PatatineButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PatatineButton.setBounds(0, 110, 153, 103);
		panel_1.add(PatatineButton);
		
		JButton BevandeButton = new JButton("Bevande");
		BevandeButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		BevandeButton.setBounds(0, 210, 153, 103);
		panel_1.add(BevandeButton);
		
		JButton DessertsButton = new JButton("Desserts");
		DessertsButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		DessertsButton.setBounds(0, 310, 153, 103);
		panel_1.add(DessertsButton);
		
		JButton AltroButton = new JButton("Altro");
		AltroButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		AltroButton.setBounds(0, 410, 153, 103);
		panel_1.add(AltroButton);
		
		JButton VisualizzaProfiloButton = new JButton("VisualizzaProfilo");
		VisualizzaProfiloButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		VisualizzaProfiloButton.setBounds(695, 10, 139, 27);
		contentPane.add(VisualizzaProfiloButton);
		
		JLabel ProdottiLabel = new JLabel("I nostri prodotti:");
		ProdottiLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		ProdottiLabel.setBounds(28, 10, 265, 24);
		contentPane.add(ProdottiLabel);
	}
}
