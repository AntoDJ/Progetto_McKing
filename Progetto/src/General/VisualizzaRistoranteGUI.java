package General;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;

import Controller.Controller;
import Utility.BigFrame;
import Utility.SmallFrame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.NativeInterfaceListener;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class VisualizzaRistoranteGUI extends BigFrame {

	private Controller controller;


//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NativeInterface.open();
//					//for (NativeInterfaceListener nil : NativeInterface.getNativeInterfaceListeners()) nil.
//			        //UIUtils.setPreferredLookAndFeel();
//					VisualizzaRistoranteGUI frame = new VisualizzaRistoranteGUI();
//
//					frame.setVisible(true);	
//				} catch (Exception e) {
//					e.printStackTrace();
//				}	//NativeInterface.runEventPump();
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	
	public VisualizzaRistoranteGUI(Controller controller) {
		getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.tornaAdAccessoGUI();
			}
		});
		this.controller = controller;
		getBodyPanel().setLayout(null);
		
		NativeInterface.open();
		JLabel sceltaRistoranteLabel = new JLabel("Di quale ristorante vuoi avere informazioni?");
		sceltaRistoranteLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		sceltaRistoranteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sceltaRistoranteLabel.setBounds(62, 53, 364, 34);
		getBodyPanel().add(sceltaRistoranteLabel);
		
		//TODO riempire combobox
		
		
		JComboBox selezionaRistoranteComboBox = new JComboBox();
		controller.riempiComboBoxRistorante(selezionaRistoranteComboBox);
		selezionaRistoranteComboBox.setFocusable(false);
		selezionaRistoranteComboBox.setFocusTraversalKeysEnabled(false);
		selezionaRistoranteComboBox.setBackground(Color.white);
		selezionaRistoranteComboBox.setFont(new Font("Bell MT", Font.PLAIN, 14));
		selezionaRistoranteComboBox.setBounds(436, 58, 334, 26);
		selezionaRistoranteComboBox.setSelectedIndex(0);
		getBodyPanel().add(selezionaRistoranteComboBox);
		
		final JWebBrowser browser = new JWebBrowser();
		browser.navigate("https://www.google.it/maps/place/Via+Diocleziano,+67,+80124+Napoli+NA");
		JPanel webPanel = new JPanel();
		webPanel.setBounds(62, 126, 776, 390);
		webPanel.setBackground(new Color(255, 255, 179));
		getBodyPanel().add(webPanel);
		webPanel.setLayout(new BorderLayout(0, 0));
		webPanel.add(browser,BorderLayout.CENTER);
		browser.setMenuBarVisible(false);
		browser.setBarsVisible(false);
		browser.setVisible(false);
		browser.getNativeComponent().setEnabled(false);
		
		//browser.removeWebBrowserListener(browser.getMouseListeners());
		//browser.setVisible(false);
		//browser.setJavascriptEnabled(false);
		
		JLabel cercaSullaMappaIcon = new JLabel(new ImageIcon(VisualizzaRistoranteGUI.class.getResource("/GUI/icons/mappa.png")));
		cercaSullaMappaIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				browser.setVisible(true);
				browser.navigate("https://www.google.it/maps/place/" + selezionaRistoranteComboBox.getSelectedItem().toString());
			}
		});
		cercaSullaMappaIcon.setBounds(798, 53, 40, 40);
		cercaSullaMappaIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getBodyPanel().add(cercaSullaMappaIcon);
		
		
//		Mettere questo come azione nel Controller:
//		Desktop desktop = Desktop.getDesktop();
//		desktop.browse(new URI("https://www.google.it/maps/@40.853586,14.1729668,12z"));
//
//		Bisogna importare:
//		import java.awt.Desktop;
//		import java.net.URI;
		
	}
}
