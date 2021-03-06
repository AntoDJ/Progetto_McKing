package Utility;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MediumFrame extends JFrame {

	private int posX;
	private int posY;
	private JPanel contentPane;
	private JPanel titoloPanel;
	private JPanel bodyPanel;
	private JButton exitButton;
	private JButton backButton;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		exitButton.setIcon(new ImageIcon(SmallFrame.class.getResource("/GUI/icons/exit.png")));
		exitButton.setBackground(null);    
		exitButton.setFont(exitButton.getFont().deriveFont(0f));
		exitButton.setBounds(645, 13, 20, 20);
		exitButton.setBorder(null);
		titoloPanel.add(exitButton);

		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(255, 255, 153));
		bodyPanel.setBounds(0, 44, 675, 410);
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
		
		titoloPanel.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				posX=e.getX();
				posY=e.getY();
			}
		});

		titoloPanel.addMouseMotionListener(new MouseAdapter()
		{
		     public void mouseDragged(MouseEvent evt)
		     {
				//sets frame position when mouse dragged			
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
							
		     }
		});
	}

	public JButton getExitButton() {
		return exitButton;
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