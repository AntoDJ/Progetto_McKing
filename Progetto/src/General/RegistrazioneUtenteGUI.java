package General;

import Controller.Controller;
import Entità.Utente;
import ExceptionsSQL.AccountNonDisponibileException;
import Utility.MediumFrame;
import Utility.MenuButton;
import Utility.SmallFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class RegistrazioneUtenteGUI extends SmallFrame {

	private Controller controller;
	private JTextField cognomeTextField;
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private JTextField indirizzoTextField;
	private JTextField numeroDiTelefonoTextField;
	private JTextField cartaDiCreditoTextField;

	public RegistrazioneUtenteGUI(Controller controller) {
		setBounds(550, 280, 450, 446);
		setLocationRelativeTo(null);
		getBodyPanel().setBounds(0, 44, 450, 400);
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaAdAccessoGUIDaRegistrazioneUtente();
			}
		});
		this.controller = controller;
		getBodyPanel().setLayout(null);
		
		JLabel infoFinestraLabel = new JLabel("Nuovo Utente");
		infoFinestraLabel.setBounds(25, 36, 134, 23);
		infoFinestraLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(infoFinestraLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(107, 92, 52, 21);
		nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setBounds(78, 124, 80, 21);
		cognomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cognomeLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(cognomeLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setToolTipText("Un cognome inizia con la lettera maiuscola");
		cognomeTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cognomeTextField.setColumns(10);
		cognomeTextField.setBounds(168, 126, 240, 20);
		getBodyPanel().add(cognomeTextField);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(102, 160, 57, 21);
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(78, 194, 81, 21);
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(passwordLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo:");
		indirizzoLabel.setBounds(85, 240, 74, 21);
		indirizzoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		indirizzoLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(indirizzoLabel);
		
		JLabel numeroDiTelefonoLabel = new JLabel("Numero di Telefono:");
		numeroDiTelefonoLabel.setBounds(25, 274, 134, 18);
		numeroDiTelefonoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroDiTelefonoLabel.setFont(new Font("Bell MT", Font.BOLD, 15));
		getBodyPanel().add(numeroDiTelefonoLabel);
		
		JLabel cartaDiCreditoLabel = new JLabel("Carta di Credito:");
		cartaDiCreditoLabel.setBounds(26, 305, 133, 21);
		cartaDiCreditoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartaDiCreditoLabel.setFont(new Font("Bell MT", Font.BOLD, 18));
		getBodyPanel().add(cartaDiCreditoLabel);
		
		MenuButton confermaButton = new MenuButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utente nuovoUtente = new Utente(nomeTextField.getText(), cognomeTextField.getText(), emailTextField.getText(), new String(passwordTextField.getPassword()), indirizzoTextField.getText(), numeroDiTelefonoTextField.getText(), cartaDiCreditoTextField.getText());
					System.out.println(nuovoUtente);
					controller.confermaNuovoUtente(nuovoUtente);
				} catch (SQLException e1) {
					JDialog errorDialog = new JDialog();
					errorDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					JOptionPane.showMessageDialog(errorDialog, "Controlla di aver compilato correttamente tutti i campi");
					e1.printStackTrace();
				}
				
			}
		});
		confermaButton.setBounds(297, 354, 111, 35);
		confermaButton.setFont(new Font("Bell MT", Font.BOLD, 16));
		getBodyPanel().add(confermaButton);
		
		nomeTextField = new JTextField();
		nomeTextField.setToolTipText("Un nome inizia con la lettera maiuscola");
		nomeTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeTextField.setBounds(169, 94, 239, 20);
		getBodyPanel().add(nomeTextField);
		nomeTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailTextField.setBounds(169, 162, 239, 20);
		getBodyPanel().add(emailTextField);
		emailTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBounds(169, 196, 239, 20);
		panel.setBackground(Color.white);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBorder(null);
		passwordTextField.setToolTipText("La password deve contenere almeno un simbolo, una lettera maiuscola ed essere lunga almeno 8 caratteri");
		passwordTextField.setBounds(1, 1, 213, 17);
		panel.add(passwordTextField);
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		mostraLabel.setBounds(215, 0, 24, 20);
		panel.add(mostraLabel);
		
		indirizzoTextField = new JTextField();
		indirizzoTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		indirizzoTextField.setToolTipText("Esempio Indirizzo: Via Roma, 7");
		indirizzoTextField.setBounds(169, 242, 239, 20);
		getBodyPanel().add(indirizzoTextField);
		indirizzoTextField.setColumns(10);
		
		numeroDiTelefonoTextField = new JTextField();
		numeroDiTelefonoTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numeroDiTelefonoTextField.setBounds(169, 273, 239, 20);
		numeroDiTelefonoTextField.setToolTipText("Esempio Numero di telefono: 3658965845");
		getBodyPanel().add(numeroDiTelefonoTextField);
		numeroDiTelefonoTextField.setColumns(10);
		
		cartaDiCreditoTextField = new JTextField();
		cartaDiCreditoTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cartaDiCreditoTextField.setBounds(169, 307, 239, 20);
		getBodyPanel().add(cartaDiCreditoTextField);
		cartaDiCreditoTextField.setColumns(10);
		
		JLabel campoObbligatorioLabel = new JLabel("*");
		campoObbligatorioLabel.setFont(new Font("Candara", Font.BOLD, 18));
		campoObbligatorioLabel.setToolTipText("campo obbligatorio");
		campoObbligatorioLabel.setBounds(415, 95, 25, 18);
		getBodyPanel().add(campoObbligatorioLabel);
		
		JLabel campoObbligatorioLabel_1 = new JLabel("*");
		campoObbligatorioLabel_1.setToolTipText("campo obbligatorio");
		campoObbligatorioLabel_1.setFont(new Font("Candara", Font.BOLD, 18));
		campoObbligatorioLabel_1.setBounds(415, 129, 25, 18);
		getBodyPanel().add(campoObbligatorioLabel_1);
		
		JLabel campoObbligatorioLabel_2 = new JLabel("*");
		campoObbligatorioLabel_2.setToolTipText("campo obbligatorio");
		campoObbligatorioLabel_2.setFont(new Font("Candara", Font.BOLD, 18));
		campoObbligatorioLabel_2.setBounds(415, 165, 25, 18);
		getBodyPanel().add(campoObbligatorioLabel_2);
		
		JLabel campoObbligatorioLabel_3 = new JLabel("*");
		campoObbligatorioLabel_3.setToolTipText("campo obbligatorio");
		campoObbligatorioLabel_3.setFont(new Font("Candara", Font.BOLD, 18));
		campoObbligatorioLabel_3.setBounds(415, 199, 25, 18);
		getBodyPanel().add(campoObbligatorioLabel_3);
		
	}
}
