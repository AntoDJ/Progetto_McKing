package General;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MenuButton;
import Utility.SmallFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;
import ExceptionsSQL.AccountNonDisponibileException;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFormGUI extends SmallFrame {
	private JTextField emailTextField;

	private JPasswordField passwordTextField;
	private Controller controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginForm frame = new LoginForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */	
	
	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public LoginFormGUI(Controller controller, String tipoAccesso) {
		this.controller= controller;
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaDaLoginForm();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 74, 91, 23);
		getBodyPanel().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(30, 122, 91, 23);
		getBodyPanel().add(lblPassword);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(131, 74, 285, 23);
		getBodyPanel().add(emailTextField);
		emailTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(131, 122, 285, 23);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JLabel credenzialiSbagliateLabel = new JLabel("*Le credenziali inserite non sono corrette");
		credenzialiSbagliateLabel.setBounds(131, 156, 249, 14);
		credenzialiSbagliateLabel.setForeground(Color.red);
		credenzialiSbagliateLabel.setVisible(false);
		getBodyPanel().add(credenzialiSbagliateLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						controller.verificaAccesso(emailTextField.getText(), new String(passwordTextField.getPassword()));
					} catch (AccountNonDisponibileException e1) {
						credenzialiSbagliateLabel.setVisible(true);
						final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
						executorService.schedule(new Runnable() {
							public void run() {credenzialiSbagliateLabel.setVisible(false);}
						}, 3, TimeUnit.SECONDS);
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		passwordTextField.setBorder(null);
		passwordTextField.setBounds(1, 1, 259, 20);
		panel.add(passwordTextField);
		
		JLabel mostraLabel = new JLabel("");
		mostraLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(passwordTextField.getEchoChar() == 0) {
					mostraLabel.setToolTipText("Nascondi");
					mostraLabel.setIcon(new ImageIcon(RegistrazioneUtenteGUI.class.getResource("/GUI/icons/nonMostrare.png")));
					passwordTextField.setEchoChar('\u2022');
				}
				else {
					mostraLabel.setToolTipText("Mostra");
					mostraLabel.setIcon(new ImageIcon(RegistrazioneUtenteGUI.class.getResource("/GUI/icons/mostrare.png")));
					passwordTextField.setEchoChar((char)0);
				}
			}
		});
		mostraLabel.setIcon(new ImageIcon(RegistrazioneUtenteGUI.class.getResource("/GUI/icons/mostrare.png")));
		mostraLabel.setBounds(261, 1, 24, 22);
		panel.add(mostraLabel);
		
		MenuButton accediButton = new MenuButton("Accedi");
		accediButton.setFont(new Font("Bell MT", Font.BOLD, 16));
		accediButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.verificaAccesso(emailTextField.getText(), new String(passwordTextField.getPassword()));
				} catch (AccountNonDisponibileException e1) {
					credenzialiSbagliateLabel.setVisible(true);
					final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
					executorService.schedule(new Runnable() {
						public void run() {credenzialiSbagliateLabel.setVisible(false);}
					}, 3, TimeUnit.SECONDS);
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		accediButton.setBounds(318, 212, 98, 23);
		getBodyPanel().add(accediButton);
		
		if(tipoAccesso.equals("Utente")) {
			JLabel registrazioneLabel = new JLabel("<html><a href=\"\" style=\"pointer-events:none\">Registrati</a></html>");
			registrazioneLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.apriRegistrazioneUtente();
				}
			});
			registrazioneLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			registrazioneLabel.setHorizontalAlignment(SwingConstants.LEFT);
			registrazioneLabel.setBounds(131, 212, 91, 23);
			registrazioneLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			getBodyPanel().add(registrazioneLabel);

			JLabel oppureLabel = new JLabel("oppure");
			oppureLabel.setHorizontalAlignment(SwingConstants.CENTER);
			oppureLabel.setFont(new Font("Dialog", Font.ITALIC, 14));
			oppureLabel.setBounds(201, 213, 107, 23);
			getBodyPanel().add(oppureLabel);
		}


	}
}
