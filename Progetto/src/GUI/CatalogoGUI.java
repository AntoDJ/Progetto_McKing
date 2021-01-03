package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class CatalogoGUI extends JFrame {

	private JPanel CatalogoGUIPane;

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
		CatalogoGUIPane = new JPanel();
		CatalogoGUIPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CatalogoGUIPane);
		CatalogoGUIPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(163, 37, 671, 517);
		CatalogoGUIPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 37, 151, 517);
		CatalogoGUIPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton PaniniButton = new JButton("Panini");
		PaniniButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PaniniButton.setBounds(0, 10, 153, 103);
		panel_1.add(PaniniButton);
		
		JButton PatatineButton = new JButton("Patatine");
		PatatineButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		PatatineButton.setBounds(0, 113, 153, 103);
		panel_1.add(PatatineButton);
		
		JButton BevandeButton = new JButton("Bevande");
		BevandeButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		BevandeButton.setBounds(0, 218, 153, 103);
		panel_1.add(BevandeButton);
		
		JButton DessertsButton = new JButton("Desserts");
		DessertsButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		DessertsButton.setBounds(0, 315, 153, 103);
		panel_1.add(DessertsButton);
		
		JButton AltroButton = new JButton("Altro");
		AltroButton.setFont(new Font("Bell MT", Font.PLAIN, 18));
		AltroButton.setBounds(0, 414, 153, 103);
		panel_1.add(AltroButton);
		
		JButton VisualizzaProfiloButton = new JButton("VisualizzaProfilo");
		VisualizzaProfiloButton.setFont(new Font("Bell MT", Font.PLAIN, 14));
		VisualizzaProfiloButton.setBounds(695, 10, 139, 27);
		CatalogoGUIPane.add(VisualizzaProfiloButton);
	}
}