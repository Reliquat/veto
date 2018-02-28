package fr.eni.clinique.ihm.screen.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ScreenAjoutClient {

	private JFrame frmAjouterDesClients;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenAjoutClient window = new ScreenAjoutClient();
					window.frmAjouterDesClients.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenAjoutClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterDesClients = new JFrame();
		frmAjouterDesClients.setResizable(false);
		frmAjouterDesClients.setAlwaysOnTop(true);
		frmAjouterDesClients.setTitle("Ajouter un client");
		frmAjouterDesClients.setBounds(100, 100, 720, 720);
		frmAjouterDesClients.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 684, 101);
		frmAjouterDesClients.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setBounds(585, 11, 89, 79);
		panel.add(btnNewButton);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(486, 11, 89, 79);
		panel.add(btnValider);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(360, 210, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(360, 252, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(360, 294, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(360, 336, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(360, 378, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(360, 420, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(360, 462, 140, 31);
		frmAjouterDesClients.getContentPane().add(textField_6);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 210, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setBounds(210, 252, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom.setBounds(210, 294, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse.setBounds(210, 336, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblAdresse);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVille.setBounds(210, 462, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodePostal.setBounds(210, 420, 140, 31);
		frmAjouterDesClients.getContentPane().add(lblCodePostal);
	}

}
