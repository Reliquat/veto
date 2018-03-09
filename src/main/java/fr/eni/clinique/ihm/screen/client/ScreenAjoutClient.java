package fr.eni.clinique.ihm.screen.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.rdv.ScreenRdv;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ScreenAjoutClient {

	private JFrame frmAjouterDesClients;
	private JTextField nomClientTxt;
	private JTextField prenomClientTxt;
	private JTextField adresse1Txt;
	private JTextField adresse2Txt;
	private JTextField cpTxt;
	private JTextField villeTxt;
	private JTextField numtelTxt;
	private JTextField assuranceTxt;
	private JTextField emailTxt;
	private JTextField remarqueTxt;
	
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
		frmAjouterDesClients.setType(Type.POPUP);
		frmAjouterDesClients.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAjouterDesClients.dispose();
			}
		});
		btnAnnuler.setBounds(585, 11, 89, 79);
		panel.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Client newClient = new Client();
				newClient.setNomClient(nomClientTxt.getText());
				newClient.setPrenomClient(prenomClientTxt.getText());
				newClient.setAdresse1(adresse1Txt.getText());
				newClient.setAdresse2(adresse2Txt.getText());
				newClient.setCodePostal(cpTxt.getText());
				newClient.setVille(villeTxt.getText());
				newClient.setNumTel(numtelTxt.getText());
				newClient.setEmail(emailTxt.getText());
				newClient.setAssurance(assuranceTxt.getText());
				newClient.setRemarque(remarqueTxt.getText());
				newClient.setArchive(false);
				newClient.setAnimaux(new ArrayList<Animal>());
				ScreenClient.getInstance().addClient(newClient);
				ScreenRdv.getInstance().addClient(newClient);
			}
		});
		btnValider.setBounds(486, 11, 89, 79);
		panel.add(btnValider);
		
		nomClientTxt = new JTextField();
		nomClientTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomClientTxt.setColumns(10);
		nomClientTxt.setBounds(363, 165, 160, 31);
		frmAjouterDesClients.getContentPane().add(nomClientTxt);
		
		prenomClientTxt = new JTextField();
		prenomClientTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenomClientTxt.setColumns(10);
		prenomClientTxt.setBounds(363, 207, 160, 31);
		frmAjouterDesClients.getContentPane().add(prenomClientTxt);
		
		adresse1Txt = new JTextField();
		adresse1Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse1Txt.setColumns(10);
		adresse1Txt.setBounds(363, 249, 160, 31);
		frmAjouterDesClients.getContentPane().add(adresse1Txt);
		
		adresse2Txt = new JTextField();
		adresse2Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse2Txt.setColumns(10);
		adresse2Txt.setBounds(363, 291, 160, 31);
		frmAjouterDesClients.getContentPane().add(adresse2Txt);
		
		cpTxt = new JTextField();
		cpTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cpTxt.setColumns(10);
		cpTxt.setBounds(363, 333, 160, 31);
		frmAjouterDesClients.getContentPane().add(cpTxt);
		
		villeTxt = new JTextField();
		villeTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		villeTxt.setColumns(10);
		villeTxt.setBounds(363, 375, 160, 31);
		frmAjouterDesClients.getContentPane().add(villeTxt);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setBounds(153, 165, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom.setBounds(153, 207, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse.setBounds(153, 249, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblAdresse);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVille.setBounds(153, 375, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodePostal.setBounds(153, 333, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblCodePostal);
		
		JLabel lblNumroTlphone = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone");
		lblNumroTlphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumroTlphone.setBounds(153, 416, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblNumroTlphone);
		
		numtelTxt = new JTextField();
		numtelTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numtelTxt.setColumns(10);
		numtelTxt.setBounds(363, 416, 160, 31);
		frmAjouterDesClients.getContentPane().add(numtelTxt);
		
		JLabel lblAssurance = new JLabel("Assurance");
		lblAssurance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAssurance.setBounds(153, 458, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblAssurance);
		
		assuranceTxt = new JTextField();
		assuranceTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		assuranceTxt.setColumns(10);
		assuranceTxt.setBounds(363, 458, 160, 31);
		frmAjouterDesClients.getContentPane().add(assuranceTxt);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(153, 500, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblEmail);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailTxt.setColumns(10);
		emailTxt.setBounds(363, 500, 160, 31);
		frmAjouterDesClients.getContentPane().add(emailTxt);
		
		JLabel lblRemarque = new JLabel("Remarque");
		lblRemarque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRemarque.setBounds(153, 542, 200, 31);
		frmAjouterDesClients.getContentPane().add(lblRemarque);
		
		remarqueTxt = new JTextField();
		remarqueTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		remarqueTxt.setColumns(10);
		remarqueTxt.setBounds(363, 542, 160, 31);
		frmAjouterDesClients.getContentPane().add(remarqueTxt);
		frmAjouterDesClients.setVisible(true);
	}
}
