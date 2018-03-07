package fr.eni.clinique.ihm.screen.client;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.controller.AnimalController;
import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.screen.animal.ScreenGestionAnimal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO 171

public class ScreenClient extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6111367380790098404L;

	private static ScreenClient activeInstance;
	private JFrame frmClient;
	private JPanel panel;
	private JLabel lblVille;

	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JButton btnValider;

	private JTextField remarqueTxt;
	private JTextField emailTxt;
	private JTextField assuranceTxt;
	private JTextField numtelTxt;
	private JTextField villeTxt;
	private JTextField cpTxt;
	private JTextField adresse1Txt;
	private JTextField adresse2Txt;
	private JTextField prenomTxt;
	private JTextField nomTxt;
	private JTextField codeCliTxt;

	private JLabel lblCodePostal;
	private ClientActionListener actionListener;
	private JTable tableAnimaux;
	private Client client;
	private DefaultTableModel tableModel;

	/**
	 * Create the application.
	 */
	public ScreenClient(String title) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(title);
		activeInstance = this;
		initialize();
	}

	public static ScreenClient getInstance() {
		return activeInstance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setResizable(false);
		frmClient.setTitle("Client");
		frmClient.setBounds(10, 11, 1074, 711);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 1080, 100);
		frmClient.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ScreenRechercheClient(actionListener);
			}
		});
		btnRechercher.setBounds(10, 11, 100, 78);

		panel.add(btnRechercher);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ScreenAjoutClient();
			}
		});
		btnAjouter.setIcon(new ImageIcon(ScreenClient.class.getResource("/Images/plus.png")));
		btnAjouter.setBounds(407, 11, 100, 78);

		panel.add(btnAjouter);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ValidDeleteClient(client);
			}
		});
		btnSupprimer.setBounds(516, 11, 100, 78);
		panel.add(btnSupprimer);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update(null, client);
			}
		});
		btnAnnuler.setBounds(956, 11, 100, 78);
		panel.add(btnAnnuler);

		btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateClient();
			}
		});
		btnValider.setBounds(846, 11, 100, 78);
		panel.add(btnValider);

		lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVille.setBounds(10, 338, 200, 25);
		frmClient.getContentPane().add(lblVille);

		cpTxt = new JTextField();
		cpTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cpTxt.setColumns(10);
		cpTxt.setBounds(220, 302, 176, 25);
		frmClient.getContentPane().add(cpTxt);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(520, 122, 544, 416);
		frmClient.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Editer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AnimalController().updateAnimalScreen(client.getAnimaux().get(tableAnimaux.getSelectedRow()));
			}
		});
		btnNewButton_1.setBounds(461, 362, 73, 43);
		panel_1.add(btnNewButton_1);

		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setBounds(378, 362, 73, 43);
		panel_1.add(btnSupprimer_1);

		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AnimalController().createAnimalScreen(client);
			}
		});
		btnAjouter_1.setIcon(new ImageIcon(ScreenClient.class.getResource("/Images/plus.png")));
		btnAjouter_1.setBounds(295, 362, 73, 43);
		panel_1.add(btnAjouter_1);

		tableAnimaux = new JTable();
		tableAnimaux.setBounds(10, 11, 524, 342);

		this.tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Numéro", "Nom", "Sexe", "Couleur", "Race", "Espece", "Tatouage" }) {

					/**
					 * 
					 */
					private static final long serialVersionUID = -7368993827700575318L;

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		tableAnimaux.setModel(this.tableModel);

		panel_1.add(tableAnimaux);

		JLabel lblAdresse_1 = new JLabel("Adresse");
		lblAdresse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse_1.setBounds(10, 230, 200, 25);
		frmClient.getContentPane().add(lblAdresse_1);

		adresse1Txt = new JTextField();
		adresse1Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse1Txt.setColumns(10);
		adresse1Txt.setBounds(220, 230, 176, 25);
		frmClient.getContentPane().add(adresse1Txt);

		JLabel lblPrenom_1 = new JLabel("Prenom");
		lblPrenom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom_1.setBounds(10, 194, 200, 25);
		frmClient.getContentPane().add(lblPrenom_1);

		prenomTxt = new JTextField();
		prenomTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(220, 194, 176, 25);
		frmClient.getContentPane().add(prenomTxt);

		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom_1.setBounds(10, 158, 200, 25);
		frmClient.getContentPane().add(lblNom_1);

		nomTxt = new JTextField();
		nomTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomTxt.setColumns(10);
		nomTxt.setBounds(220, 158, 176, 25);
		frmClient.getContentPane().add(nomTxt);

		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(10, 122, 200, 25);
		frmClient.getContentPane().add(lblCode);

		codeCliTxt = new JTextField();
		codeCliTxt.setEditable(false);
		codeCliTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		codeCliTxt.setColumns(10);
		codeCliTxt.setBounds(220, 122, 176, 25);
		frmClient.getContentPane().add(codeCliTxt);

		adresse2Txt = new JTextField();
		adresse2Txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adresse2Txt.setColumns(10);
		adresse2Txt.setBounds(220, 266, 176, 25);
		frmClient.getContentPane().add(adresse2Txt);

		villeTxt = new JTextField();
		villeTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		villeTxt.setColumns(10);
		villeTxt.setBounds(220, 338, 176, 25);
		frmClient.getContentPane().add(villeTxt);

		lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodePostal.setBounds(10, 302, 200, 25);
		frmClient.getContentPane().add(lblCodePostal);

		JLabel lblNumroTlphone = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone");
		lblNumroTlphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumroTlphone.setBounds(10, 374, 200, 25);
		frmClient.getContentPane().add(lblNumroTlphone);

		numtelTxt = new JTextField();
		numtelTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numtelTxt.setColumns(10);
		numtelTxt.setBounds(220, 374, 176, 25);
		frmClient.getContentPane().add(numtelTxt);

		JLabel lblAssurance = new JLabel("Assurance");
		lblAssurance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAssurance.setBounds(10, 410, 200, 25);
		frmClient.getContentPane().add(lblAssurance);

		assuranceTxt = new JTextField();
		assuranceTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		assuranceTxt.setColumns(10);
		assuranceTxt.setBounds(220, 410, 176, 25);
		frmClient.getContentPane().add(assuranceTxt);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 446, 200, 25);
		frmClient.getContentPane().add(lblEmail);

		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailTxt.setColumns(10);
		emailTxt.setBounds(220, 446, 176, 25);
		frmClient.getContentPane().add(emailTxt);

		JLabel lblRemarque = new JLabel("Remarque");
		lblRemarque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRemarque.setBounds(10, 482, 200, 25);
		frmClient.getContentPane().add(lblRemarque);

		remarqueTxt = new JTextField();
		remarqueTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		remarqueTxt.setColumns(10);
		remarqueTxt.setBounds(220, 482, 176, 25);
		frmClient.getContentPane().add(remarqueTxt);
		frmClient.setVisible(true);
	}

	protected void updateClient() {
		this.client.setNomClient(this.nomTxt.getText());
		this.client.setPrenomClient(this.prenomTxt.getText());
		this.client.setAdresse1(this.adresse1Txt.getText());
		this.client.setAdresse2(this.adresse2Txt.getText());
		this.client.setCodePostal(this.cpTxt.getText());
		this.client.setAssurance(this.assuranceTxt.getText());
		
		this.remarqueTxt.setText("");
	}

	public void supprimerClient() {
		this.client.setArchive(true);
		try {
			this.actionListener.SupprimerClient(this.client);
			reset();
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.codeCliTxt.setText("");
		this.nomTxt.setText("");
		this.prenomTxt.setText("");
		this.adresse1Txt.setText("");
		this.adresse2Txt.setText("");
		this.cpTxt.setText("");
		this.assuranceTxt.setText("");
		this.remarqueTxt.setText("");
		this.client = null;
	}

	public void setActionListener(ClientActionListener actionListener) {

		if (actionListener != null) {

			this.actionListener = actionListener;
		}
	}

	public void removeActionListener() {
		this.actionListener = null;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.client = (Client) arg1;

		nomTxt.setText(ObjectUtil.nullToBlank(client.getNomClient().trim()));
		prenomTxt.setText(ObjectUtil.nullToBlank(client.getPrenomClient()).trim());
		adresse1Txt.setText(ObjectUtil.nullToBlank(client.getAdresse1()).trim());
		adresse2Txt.setText(ObjectUtil.nullToBlank(client.getAdresse2()).trim());
		cpTxt.setText(ObjectUtil.nullToBlank(client.getCodePostal().trim()));
		villeTxt.setText(ObjectUtil.nullToBlank(client.getVille().trim()));
		numtelTxt.setText(ObjectUtil.nullToBlank(client.getNumTel().trim()));
		assuranceTxt.setText(ObjectUtil.nullToBlank(client.getAssurance().trim()));
		emailTxt.setText(ObjectUtil.nullToBlank(client.getEmail().trim()));
		remarqueTxt.setText(ObjectUtil.nullToBlank(client.getRemarque().trim()));
		
		this.tableModel.setRowCount(0);
		for (Animal animal : client.getAnimaux()) {
			this.tableModel.addRow(
					new String[] { String.valueOf(animal.getCodeAnimal()), animal.getNomAnimal(), animal.getSexe(),
							animal.getCouleur(), animal.getRace(), animal.getEspece(), animal.getTatouage() });
		}

		this.tableAnimaux.setModel(this.tableModel);

		this.tableModel.fireTableDataChanged();
	}

	public void addClient(Client newClient) {
		this.actionListener.AjouterClient(newClient);
		
	}
}
