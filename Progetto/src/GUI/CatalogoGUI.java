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
		
		JPanel panel = new JPanel();
		panel.setBounds(163, 10, 671, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 151, 544);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton PaniniButton = new JButton("Panini");
		PaniniButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		PaniniButton.setBounds(0, 0, 153, 110);
		panel_1.add(PaniniButton);
		
		JButton PatatineButton = new JButton("Patatine");
		PatatineButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		PatatineButton.setBounds(0, 107, 153, 110);
		panel_1.add(PatatineButton);
		
		JButton BevandeButton = new JButton("Bevande");
		BevandeButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		BevandeButton.setBounds(0, 214, 153, 110);
		panel_1.add(BevandeButton);
		
		JButton DessertsButton = new JButton("Desserts");
		DessertsButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		DessertsButton.setBounds(0, 323, 153, 110);
		panel_1.add(DessertsButton);
		
		JButton AltroButton = new JButton("Altro");
		AltroButton.setFont(new Font("Bell MT", Font.PLAIN, 12));
		AltroButton.setBounds(0, 434, 153, 110);
		panel_1.add(AltroButton);
	}
}
