package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BigFrame extends JFrame {

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
					MediumFrame frame = new MediumFrame();
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
	public BigFrame() {
		super();
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 675, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBounds(0, 0, 675, 46);
		TitlePanel.setBackground(new Color(255, 0, 0));
		contentPane.add(TitlePanel);
		TitlePanel.setLayout(null);
		
		JLabel TitoloLabel = new JLabel("McKING");
		TitoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitoloLabel.setForeground(new Color(255, 255, 50));
		TitoloLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		TitoloLabel.setBounds(190, 0, 300, 46);
		TitlePanel.add(TitoloLabel);
		
		ExitButton = new JButton("");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ExitButton.setFocusTraversalKeysEnabled(false);
		ExitButton.setFocusPainted(false);
		ExitButton.setFocusable(false);
		ExitButton.setIcon(new ImageIcon(SmallFrame.class.getResource("/GUI/ExitIcon.png")));
		ExitButton.setBackground(null);		
		ExitButton.setFont(ExitButton.getFont().deriveFont(0f));
		ExitButton.setBounds(645, 10, 20, 20);
		ExitButton.setBorder(null);
		TitlePanel.add(ExitButton);
		
		BodyPanel = new JPanel();
		BodyPanel.setBackground(new Color(255, 255, 153));
		BodyPanel.setBounds(0, 44, 675, 410);
		contentPane.add(BodyPanel);		
	}

	public JPanel getBodyPanel() {
		return BodyPanel;
	}

	public void setBodyPanel(JPanel bodyPanel) {
		BodyPanel = bodyPanel;
	}
	
	
	
}
