package Utility;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class SmallFrame extends JFrame {

	private JPanel contentPane;
	private JPanel titoloPanel;
	private JPanel bodyPanel;
	private JButton backButton;
	private JButton exitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmallFrame frame = new SmallFrame();
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
	public SmallFrame() {
		super();
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 280, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titoloPanel = new JPanel();
		titoloPanel.setBackground(new Color(255, 0, 0));
		titoloPanel.setBounds(0, 0, 450, 46);
		contentPane.add(titoloPanel);
		titoloPanel.setLayout(null);
		
		JLabel titoloLabel = new JLabel("McKing");
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloLabel.setForeground(new Color(255, 255, 50));
		titoloLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		titoloLabel.setBounds(85, 0, 282, 46);
		titoloPanel.add(titoloLabel);
		
		exitButton = new JButton("");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setFocusTraversalKeysEnabled(false);
		exitButton.setFocusPainted(false);
		exitButton.setFocusable(false);
		exitButton.setIcon(new ImageIcon(SmallFrame.class.getResource("/GUI/icons/exit.png")));
		exitButton.setBackground(null);		
		exitButton.setFont(exitButton.getFont().deriveFont(0f));
		exitButton.setBounds(420, 13, 20, 20);
		exitButton.setBorder(null);
		titoloPanel.add(exitButton);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(255, 255, 153));
		bodyPanel.setBounds(0, 44, 450, 256);
		contentPane.add(bodyPanel);
		
		backButton = new JButton();
		backButton = new JButton("");
		backButton.setFocusTraversalKeysEnabled(false);
		backButton.setFocusPainted(false);
		backButton.setFocusable(false);
		backButton.setIcon(new ImageIcon(SmallFrame.class.getResource("/GUI/icons/indietro.png")));
		backButton.setBackground(null);		
		backButton.setFont(backButton.getFont().deriveFont(0f));
		backButton.setBounds(20, 5, 42, 38);
		backButton.setBorder(null);
		titoloPanel.add(backButton);
		getTitoloPanel().add(backButton);

	}

	public JPanel getBodyPanel() {
		return bodyPanel;
	}
	public JPanel getTitoloPanel() {
		return titoloPanel;
	}
	public JButton getBackButton() {
		return backButton;
	}
}
