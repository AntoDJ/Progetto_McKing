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

public class MediumFrame extends JFrame {

	private JPanel contentPane;
	private JPanel titoloPanel;
	private JPanel bodyPanel;
	private JButton exitButton;
	/* Launch the application.
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

	/* Create the frame.
	 */
	public MediumFrame() {
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


		titoloPanel = new JPanel();
		titoloPanel.setBounds(0, 0, 675, 46);
		titoloPanel.setBackground(new Color(255, 0, 0));
		contentPane.add(titoloPanel);
		titoloPanel.setLayout(null);

		JLabel titoloLabel = new JLabel("McKING");
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloLabel.setForeground(new Color(255, 255, 50));
		titoloLabel.setFont(new Font("Papyrus", Font.BOLD, 26));
		titoloLabel.setBounds(190, 0, 300, 46);
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
		exitButton.setIcon(new ImageIcon(SmallFrame.class.getResource("/GUI/ExitIcon.png")));
		exitButton.setBackground(null);    
		exitButton.setFont(exitButton.getFont().deriveFont(0f));
		exitButton.setBounds(645, 10, 20, 20);
		exitButton.setBorder(null);
		titoloPanel.add(exitButton);

		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(255, 255, 153));
		bodyPanel.setBounds(0, 44, 675, 410);
		contentPane.add(bodyPanel);    
	}

	public JPanel getBodyPanel() {
		return bodyPanel;
	}
	public JPanel getTitoloPanel() {
		return titoloPanel;
	}
}