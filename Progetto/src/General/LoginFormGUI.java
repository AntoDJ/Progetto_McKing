package General;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
	public LoginFormGUI(Controller controller) {
		this.controller= controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(30, 72, 75, 23);
		getBodyPanel().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 16));
		lblPassword.setBounds(30, 119, 75, 23);
		getBodyPanel().add(lblPassword);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(131, 74, 285, 23);
		getBodyPanel().add(emailTextField);
		emailTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();		
		passwordTextField.setBounds(131, 122, 285, 23);
		getBodyPanel().add(passwordTextField);
		
		MenuButton accediButton = new MenuButton("Accedi");
		accediButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.verificaAccesso(emailTextField.getText(), new String(passwordTextField.getPassword()));
				} catch (AccountNonDisponibileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		accediButton.setBounds(318, 212, 98, 23);
		getBodyPanel().add(accediButton);

	}
}
