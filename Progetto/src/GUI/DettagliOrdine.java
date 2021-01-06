package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class DettagliOrdine extends SmallFrame {
	private JTextField selezionaIndirizzoField;
	private JTextField selezionaCartaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DettagliOrdine frame = new DettagliOrdine();
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
	public DettagliOrdine() {
		getBodyPanel().setBounds(0, 44, 450, 256);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getBodyPanel().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 222, 256);
		getBodyPanel().add(panel);
		panel.setLayout(null);
		
		JLabel titoloLabel = new JLabel("DettagliOrdine:");
		titoloLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		titoloLabel.setBounds(10, 10, 169, 31);
		panel.add(titoloLabel);
		
		JLabel selezionaRistoranteLabel = new JLabel("Seleziona ristorante:");
		selezionaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaRistoranteLabel.setBounds(10, 60, 169, 31);
		panel.add(selezionaRistoranteLabel);
		
		JLabel selezionaIndirizzoLabel = new JLabel("Seleziona indirizzo:");
		selezionaIndirizzoLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoLabel.setBounds(10, 105, 169, 31);
		panel.add(selezionaIndirizzoLabel);
		
		JLabel selezionaCartaLabel = new JLabel("Seleziona carta:");
		selezionaCartaLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaLabel.setBounds(10, 150, 169, 31);
		panel.add(selezionaCartaLabel);
		
		JLabel selezionaOrarioLabel_1 = new JLabel("Seleziona orario:");
		selezionaOrarioLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaOrarioLabel_1.setBounds(10, 195, 169, 31);
		panel.add(selezionaOrarioLabel_1);
		
		JComboBox selezionaRistorantecomboBox = new JComboBox();
		selezionaRistorantecomboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistorantecomboBox.setFocusable(false);
		selezionaRistorantecomboBox.setBounds(232, 60, 212, 21);
		getBodyPanel().add(selezionaRistorantecomboBox);
		
		selezionaIndirizzoField = new JTextField();
		selezionaIndirizzoField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaIndirizzoField.setBounds(232, 105, 212, 21);
		getBodyPanel().add(selezionaIndirizzoField);
		selezionaIndirizzoField.setColumns(10);
		
		selezionaCartaField = new JTextField();
		selezionaCartaField.setFont(new Font("Bell MT", Font.PLAIN, 16));
		selezionaCartaField.setColumns(10);
		selezionaCartaField.setBounds(232, 154, 212, 21);
		getBodyPanel().add(selezionaCartaField);
		
		JComboBox selezionaOrariocomboBox = new JComboBox();
		selezionaOrariocomboBox.setFocusTraversalKeysEnabled(false);
		selezionaOrariocomboBox.setFocusable(false);
		selezionaOrariocomboBox.setBounds(232, 200, 212, 21);
		getBodyPanel().add(selezionaOrariocomboBox);

	}
}
