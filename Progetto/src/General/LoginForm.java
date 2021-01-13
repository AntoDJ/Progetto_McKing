package General;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Utility.MenuButton;
import Utility.SmallFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginForm extends SmallFrame {
	private JTextField emailTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 122, 285, 23);
		getBodyPanel().add(passwordField);
		
		MenuButton accediButton = new MenuButton("Accedi");
		accediButton.setBounds(318, 212, 98, 23);
		getBodyPanel().add(accediButton);

	}
}
