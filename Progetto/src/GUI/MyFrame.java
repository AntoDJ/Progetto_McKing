package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JPanel BodyPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		super();
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 450, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel TitoloLabel = new JLabel("McKing");
		TitoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitoloLabel.setForeground(new Color(255, 255, 50));
		TitoloLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		TitoloLabel.setBounds(0, 0, 450, 46);
		panel.add(TitoloLabel);
		
		BodyPanel = new JPanel();
		BodyPanel.setBackground(new Color(255, 255, 153));
		BodyPanel.setBounds(0, 44, 450, 256);
		contentPane.add(BodyPanel);
		

	}

	public JPanel getBodyPanel() {
		return BodyPanel;
	}

	public void setBodyPanel(JPanel bodyPanel) {
		BodyPanel = bodyPanel;
	}
	
	
}
