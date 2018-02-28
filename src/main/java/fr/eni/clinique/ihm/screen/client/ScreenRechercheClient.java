package fr.eni.clinique.ihm.screen.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ScreenRechercheClient {

	private JFrame frmRechercher;
	private JTextField txtRechercher;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenRechercheClient window = new ScreenRechercheClient();
					window.frmRechercher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenRechercheClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechercher = new JFrame();
		frmRechercher.setResizable(false);
		frmRechercher.setAlwaysOnTop(true);
		frmRechercher.setTitle("R\u00E9sultat de la recherche");
		frmRechercher.setBounds(100, 100, 720, 500);
		frmRechercher.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 684, 78);
		frmRechercher.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setBounds(573, 11, 101, 56);
		panel.add(btnNewButton);
		
		txtRechercher = new JTextField();
		txtRechercher.setText("nom du client");
		txtRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		txtRechercher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRechercher.setBounds(10, 24, 553, 31);
		panel.add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 100, 684, 350);
		frmRechercher.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 664, 328);
		panel_1.add(list);
	}

}
