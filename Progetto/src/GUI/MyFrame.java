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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JPanel BodyPanel;
	private JButton ExitButton;

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
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 450, 300);
		setLocationRelativeTo(null);
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
		TitoloLabel.setBounds(85, 0, 282, 46);
		panel.add(TitoloLabel);
		
		ExitButton = new JButton("");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ExitButton.setFocusTraversalKeysEnabled(false);
		ExitButton.setFocusPainted(false);
		ExitButton.setFocusable(false);
		ExitButton.setIcon(new ImageIcon(MyFrame.class.getResource("/GUI/exit.png")));
		ExitButton.setBackground(null);		
		ExitButton.setFont(ExitButton.getFont().deriveFont(0f));
		ExitButton.setBounds(420, 13, 20, 20);
		ExitButton.setBorder(null);
		panel.add(ExitButton);
		
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
