package AdminCatena;

import java.awt.EventQueue;
import java.awt.Font;

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

public class Modifica_GestioneCatalogoGUI extends SmallFrame {

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
		getBodyPanel().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(10dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(111dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(42dlu;default)"),
				RowSpec.decode("max(39dlu;default)"),
				RowSpec.decode("max(36dlu;default)"),}));
		
		JLabel nomeProdottoLabel = new JLabel("Nome Prodotto");
		nomeProdottoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(nomeProdottoLabel, "3, 2");
		
		JLabel lblNewLabel = new JLabel("New label");
		getBodyPanel().add(lblNewLabel, "5, 2");
		
		JLabel prezzoLabel = new JLabel("Prezzo");
		prezzoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(prezzoLabel, "3, 3");
		
		JLabel attivoLabel = new JLabel("Disponibile");
		attivoLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		getBodyPanel().add(attivoLabel, "3, 4");
		
		JComboBox comboBox = new JComboBox();
		getBodyPanel().add(comboBox, "5, 4, fill, default");
		
		
	}
}
