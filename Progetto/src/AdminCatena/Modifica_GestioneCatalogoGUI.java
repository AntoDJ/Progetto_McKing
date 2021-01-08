package AdminCatena;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import Utility.MenuButton;
import Utility.SmallFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modifica_GestioneCatalogoGUI extends SmallFrame {
	private JTextField nuovoPrezzoTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifica_GestioneCatalogoGUI frame = new Modifica_GestioneCatalogoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Modifica_GestioneCatalogoGUI() {
		getBodyPanel().setLayout(null);
		
		JLabel nomeProdottoLabel = new JLabel("Nome Prodotto");
		nomeProdottoLabel.setBounds(21, 24, 165, 26);
		nomeProdottoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(nomeProdottoLabel);
		
		JLabel nomeLabel = new JLabel("Prodotto ###");
		nomeLabel.setBounds(192, 30, 149, 14);
		nomeLabel.setFont(new Font("Bell MT", Font.ITALIC, 16));
		getBodyPanel().add(nomeLabel);
		
		JLabel prezzoLabel = new JLabel("Prezzo");
		prezzoLabel.setBounds(21, 85, 165, 26);
		prezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(prezzoLabel);
		
		//TODO aggiungere verifica correttezza numero inserito e maxlength
		
		nuovoPrezzoTextField = new JTextField("20.00");
		nuovoPrezzoTextField.setEditable(false);
		nuovoPrezzoTextField.setBounds(242, 88, 50, 20);
		nuovoPrezzoTextField.setHorizontalAlignment(JTextField.RIGHT);
		
		getBodyPanel().add(nuovoPrezzoTextField);
		
		
		JLabel simboloEuroLabel = new JLabel("\u20AC");
		simboloEuroLabel.setBounds(302, 90, 46, 14);
		simboloEuroLabel.setFont(new Font("Bell MT", Font.BOLD, 14));
		getBodyPanel().add(simboloEuroLabel);
		
		MenuButton modificaPrezzoButton = new MenuButton("Modifica");
		modificaPrezzoButton.setFont(new Font("Bell MT", Font.BOLD,12));
		modificaPrezzoButton.setHorizontalAlignment(JButton.LEFT);
		modificaPrezzoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nuovoPrezzoTextField.isEditable()) {
					nuovoPrezzoTextField.setEditable(false);
					//TODO reimposta il valore del prezzo a quello precedente
				}
				else nuovoPrezzoTextField.setEditable(true);
			}
		});
		modificaPrezzoButton.setBounds(325, 88, 82, 20);
		getBodyPanel().add(modificaPrezzoButton);
		
		
		JLabel attivoLabel = new JLabel("Disponibile");
		attivoLabel.setBounds(21, 142, 165, 26);
		attivoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(attivoLabel);
		
		String[] campiAttivo = {"Attivo", "Non attivo"};
		JComboBox attivoComboBox = new JComboBox(campiAttivo);
		attivoComboBox.setForeground(Color.yellow);
		attivoComboBox.setFont(new Font("Bell MT", Font.BOLD, 14));
		
		if(attivoComboBox.getSelectedItem() == "Attivo") attivoComboBox.setBackground(new Color(0, 204, 102));
		else attivoComboBox.setBackground(new Color(255, 51, 0));
		attivoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(attivoComboBox.getSelectedItem() == "Attivo") attivoComboBox.setBackground(new Color(0, 204, 102));
				else attivoComboBox.setBackground(new Color(255, 51, 0));
			}
		});
		attivoComboBox.setBounds(192, 144, 100, 22);
		getBodyPanel().add(attivoComboBox);
		
		//TODO Modifica database
		
		MenuButton confermaModificheButton = new MenuButton("Conferma");
		confermaModificheButton.setFont(new Font("Bell MT", Font.BOLD, 12));
		confermaModificheButton.setBounds(325, 202, 100, 32);
		getBodyPanel().add(confermaModificheButton);
		
		

		
		
	}
}
